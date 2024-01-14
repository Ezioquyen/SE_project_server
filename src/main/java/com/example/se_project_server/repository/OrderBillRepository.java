package com.example.se_project_server.repository;

import com.example.se_project_server.entity.IBillProduct;
import com.example.se_project_server.entity.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderBillRepository extends JpaRepository<OrderBill, String> {
    @Query(value = "select p.name, "
            + "case when dd.count is null then 0 "
            + "else dd.count "
            + "end as count "
            + "from "
            + "( "
            + "select bp.product_id as id, sum(bp.product_count) as count  "
            + "from ( "
            + "select id "
            + "from order_bill "
            + "where buy_date between :dateStart and :dateEnd) as ob left join bill_product as bp on ob.id = bp.bill_id "
            + "group by bp.product_id ) as dd right join "
            + "( "
            + "select id, name "
            + "from product "
            + ") as p "
            + "on dd.id = p.id;", nativeQuery = true)
    List<IBillProduct> getProductCount(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query(value = "select date_format(buy_date, '%Y-%m-%d') as name, sum(total) as count "
            + "from order_bill as ob "
            + "where ob.buy_date between :dateStart and :dateEnd "
            + "group by name "
            + "order by name;", nativeQuery = true)
    List<IBillProduct> getProfitPerDay(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query(value = "select date_format(buy_date, '%Y-%m') as name, sum(total) as count "
            + "from order_bill as ob "
            + "where ob.buy_date between :dateStart and :dateEnd "
            + "group by name "
            + "order by name;", nativeQuery = true)
    List<IBillProduct> getProfitPerMonth(@Param("dateStart") LocalDateTime dateStart, @Param("dateEnd") LocalDateTime dateEnd);

    @Query(value = """
            select ob.id, buy_date as buyDate, customer_phone_number as customerPhoneNumber,
            user_staff_id as userStaffId, total, deduction, promotion_name as promotionName, received,
            change_money as changeMoney, pay_method as payMethod, original from order_bill ob
            where ob.id = :id
            """, nativeQuery = true)
    Map<String, Object> getOrderBillById(@Param("id") String id);

    @Query(value = """
            select ob.id, buy_date as buyDate, customer_phone_number as customerPhoneNumber,
            user_staff_id as userStaffId, total, deduction, promotion_name as promotionName, received,
            change_money as changeMoney, pay_method as payMethod, original from order_bill ob
            order by buyDate desc
                    
            """, nativeQuery = true)
    List<Map<String, Object>> getAllOrderBill();
}
