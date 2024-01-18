package com.example.se_project_server.repository;

import com.example.se_project_server.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Integer> {
    @Query(value = """
    select id, information, start_date startDate, end_date endDate, name from promotion
    order by startDate desc
""",nativeQuery = true )
    List<Map<String,Object>> getAll();
    @Query(value = """
                select id, information, start_date startDate, end_date endDate, name from promotion
                where start_date<=:date and end_date >=:date
            """,nativeQuery = true )
   Map<String,Object> getPromotionByDate(@Param("date") String date);

    @Query(value = """
                     select distinct IF(
                     exists(
                     select id from promotion where
                     ((end_date between :startDate and :endDate)
                      or (start_date between :startDate and :endDate))
                      and id != :id), 'false', 'true')
                     from promotion
    """,nativeQuery = true)
    Boolean checkPromotion(@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("id") Integer id);

}
