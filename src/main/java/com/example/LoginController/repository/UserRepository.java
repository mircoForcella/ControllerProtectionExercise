package com.example.LoginController.repository;


import com.example.LoginController.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT c FROM UserEntity c")
    List<UserEntity> findAllUserEntity();

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    UserEntity findUserByID(@Param("id") Long id);

    UserEntity getUserEntityByUsername(String username);
}