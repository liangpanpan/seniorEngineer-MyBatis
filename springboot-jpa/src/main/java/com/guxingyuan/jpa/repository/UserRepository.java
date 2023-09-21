package com.guxingyuan.jpa.repository;

import com.guxingyuan.jpa.entity.DepartmentEntity;
import com.guxingyuan.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/9/21       create this file
 * </pre>
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByDepartment(DepartmentEntity department);

    UserEntity findFirstByWorkId(String workId);

    List<UserEntity> findAllByDepartmentInAndUserNameLike(List<DepartmentEntity> departmentIds, String userName);

    @Query(value = "SELECT * FROM user WHERE user_name LIKE ?1", nativeQuery = true)
    List<UserEntity> fuzzyQueryByName(String userName);
}

