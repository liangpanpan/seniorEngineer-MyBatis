package com.guxingyuan.jpa.repository;

import com.guxingyuan.jpa.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/9/25       create this file
 * </pre>
 */
public interface UserExtRepository extends BaseRepository<UserEntity> {

    default Specification<UserEntity> getSpecification(UserEntity example) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<Integer> id = root.get("id");
            Path<String> workId = root.get("workId");
            Path<String> userName = root.get("userName");

            List<Predicate> predicateList = new ArrayList<>();

            if (example.getId() != null && example.getId() > 0) {
                predicateList.add(criteriaBuilder.equal(id, example.getId()));
            }
            if (example.getUserName() != null) {
                predicateList.add(criteriaBuilder.equal(userName, example.getUserName()));
            }
            if (!StringUtils.isEmpty(example.getWorkId())) {
                predicateList.add(criteriaBuilder.equal(workId, example.getWorkId()));
            }

            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }


    UserEntity findByUserName(String userName);

    // native SQL
    @Query(value = "select u.* from user u where u.id = ?1 or u.username = ?2 ", nativeQuery = true)
    UserEntity queryUser(Integer id, String userName);

    // JPQL
    @Modifying // 更新或删除时需要加此注解，查询时不需要
    @Query("update UserEntity set userName = :userName where id = :id ")
    UserEntity updateUserName(@Param("id") Integer id, @Param("userName") String userName);



}
