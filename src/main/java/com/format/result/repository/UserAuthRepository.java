package com.format.result.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.format.result.model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth,UUID>
{
    UserAuth  findByUserEmail(String userEmail);
}
