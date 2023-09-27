package com.guxingyuan.jpa.repository;

import com.guxingyuan.jpa.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

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
public interface BaseRepository<S extends UserEntity> extends JpaSpecificationExecutor<S>, JpaRepository<S, Integer> {

    default Specification<S> getSpecification(S example) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<String> id = root.get("workId");
            Path<String> userName = root.get("userName");

            List<Predicate> predicateList = new ArrayList<>();

            if (example.getId() != null && example.getId() > 0) {
                predicateList.add(criteriaBuilder.equal(id, example.getId()));
            }
            if (example.getUserName() != null) {
                predicateList.add(criteriaBuilder.equal(userName, example.getUserName()));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }

}
