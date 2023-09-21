package com.guxingyuan.jpa.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/9/21       create this file
 * </pre>
 */
@Data
@Entity
@Table(name = "user")
@EntityListeners(value = AuditingEntityListener.class)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workId;

    private String userName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "department")
    private DepartmentEntity department;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
