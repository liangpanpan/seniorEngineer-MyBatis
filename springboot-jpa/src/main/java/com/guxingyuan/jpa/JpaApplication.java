package com.guxingyuan.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2023/9/20       create this file
 * </pre>
 */
@SpringBootApplication
// 可选，指定扫描的表映射实体Entity的目录，如果不指定，会扫描全部目录
@EntityScan("com.guxingyuan.jpa.entity")
// 可选，指定扫描的表repository目录，如果不指定，会扫描全部目录
@EnableJpaRepositories(basePackages = {"com.guxingyuan.jpa.repository"})
// 可选，开启JPA auditing能力，可以自动赋值一些字段，比如创建时间、最后一次修改时间等等
@EnableJpaAuditing
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}
