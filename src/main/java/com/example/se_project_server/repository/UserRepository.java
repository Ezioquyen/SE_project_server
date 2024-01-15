package com.example.se_project_server.repository;

import com.example.se_project_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where username like :username", nativeQuery = true)
    List<User> getUserByUsername(@Param("username") String username);

    @Query(value = "select * from user where staff_id like %:stringSearch% or id like %:stringSearch% or username like %:stringSearch%", nativeQuery = true)
    List<User> getBySearch(@Param("stringSearch") String stringSearch);

}
