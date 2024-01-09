package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Timekeeping;
import com.example.se_project_server.serializable.TimekeepingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimekeepingRepository extends JpaRepository<Timekeeping, TimekeepingId> {
}
