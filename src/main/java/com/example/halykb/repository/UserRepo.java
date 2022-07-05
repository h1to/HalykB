package com.example.halykb.repository;

import com.example.halykb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    Users findByPerNum(Long PerNum);
    List<Users> findAll();
}
