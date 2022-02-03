package com.springboot.demo.repositories;

import com.springboot.demo.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

// <Session, Long> 指定数据类型和Table的主键
// JpaRepository<Session, Long> 接口中包含基本的数据库执行的操作
public interface SessionRepository extends JpaRepository<Session, Long> {

    // 自定义执行的方法: 抽象执行的逻辑

}
