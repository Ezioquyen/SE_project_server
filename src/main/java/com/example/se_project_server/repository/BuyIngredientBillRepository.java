package com.example.se_project_server.repository;

import com.example.se_project_server.entity.BuyIngredientBill;
import com.example.se_project_server.entity.IBillIngredient;
import com.example.se_project_server.entity.IBillProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BuyIngredientBillRepository extends JpaRepository<BuyIngredientBill,String> {
    @Query(value = "select i.name, c.count, i.unit, i.unit_price * c.count as total from "
            + "ingredient as i, "
            + "( "
            + "select bi.ingredient_id as iid, sum(bi.count_by_unit) as count from bill_ingredient as bi "
            + "where bi.bill_id in "
            + "( "
            + "select id "
            + "from buy_ingredient_bill "
            + "where buy_date between :dateStart and :dateEnd "
            + ") "
            + "group by iid "
            + ") as c "
            + "where i.id = c.iid;", nativeQuery = true)
    List<IBillIngredient> getIngredientCount(@Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);

    @Query(value = "select bib.buy_date as name, sum(bib.price) as count "
            + "from buy_ingredient_bill as bib "
            + "where bib.buy_date between :dateStart and :dateEnd "
            + "group by name "
            + "order by name asc;", nativeQuery = true)
    List<IBillProduct> getBIPerDay(@Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);

    @Query(value = "select date_format(bib.buy_date, '%Y-%m') as name, sum(bib.price) as count "
            + "from buy_ingredient_bill as bib "
            + "where bib.buy_date between :dateStart and :dateEnd "
            + "group by name "
            + "order by name asc;", nativeQuery = true)
    List<IBillProduct> getBIPerMonth(@Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);
}
