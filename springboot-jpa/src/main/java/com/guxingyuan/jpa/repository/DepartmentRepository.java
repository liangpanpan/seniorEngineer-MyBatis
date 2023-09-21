package com.guxingyuan.jpa.repository;

import com.guxingyuan.jpa.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/9/21       create this file
 * </pre>
 */
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
