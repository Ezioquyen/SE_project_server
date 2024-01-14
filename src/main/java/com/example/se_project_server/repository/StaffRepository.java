package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Staff;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    @Transactional
    @Modifying
    @Query(value = """
                update staff set is_deleted = 1 where id = :id
            """, nativeQuery = true)
    void deleteById(@Param("id") String id);

    @Query(value = """
    select * from staff where id = :id and is_deleted = false
    """,nativeQuery = true)
    Staff getById(@Param("id") String id);
}
