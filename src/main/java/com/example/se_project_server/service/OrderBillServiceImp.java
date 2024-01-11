package com.example.se_project_server.service;

import com.example.se_project_server.entity.BillProduct;
import com.example.se_project_server.entity.OrderBill;
import com.example.se_project_server.entity.Product;
import com.example.se_project_server.repository.BillProductRepository;
import com.example.se_project_server.repository.OrderBillRepository;

import com.example.se_project_server.serializable.BillProductId;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class OrderBillServiceImp implements OrderBillService {
    private final BillProductRepository billProductRepository;
    private final OrderBillRepository orderBillRepository;


    public OrderBillServiceImp(BillProductRepository billProductRepository, OrderBillRepository orderBillRepository) {
        this.billProductRepository = billProductRepository;
        this.orderBillRepository = orderBillRepository;
    }

    @Override
    public String saveBill(Map<String, Object> bill) {
        OrderBill orderBill = new OrderBill();
        orderBill.setId(bill.get("id").toString());
        orderBill.setTotal(Integer.parseInt(bill.get("total").toString()));
        orderBill.setBuyDate(LocalDate.parse(bill.get("buyDate").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        if (bill.get("customerPhoneNumber") != null) orderBill.setCustomerPhoneNumber(bill.get("customerPhoneNumber").toString());
        orderBill.setUserStaffId(bill.get("userStaffId").toString());
        orderBill.setReceived(Integer.parseInt(bill.get("received").toString()));
        orderBill.setChangeMoney(Integer.parseInt(bill.get("changeMoney").toString()));
        orderBill.setOriginal(Integer.parseInt(bill.get("original").toString()));
        orderBill.setDeduction(Integer.parseInt(bill.get("deduction").toString()));
        orderBill.setPayMethod((Boolean) bill.get("payMethod"));
        orderBillRepository.save(orderBill);
        for (Map<String, Object> product : (List<Map<String, Object>>) bill.get("products")) {
            BillProduct billProduct = new BillProduct();
            BillProductId billProductId = new BillProductId();
            billProductId.setBillId(orderBill.getId());
            billProductId.setProductId(Integer.parseInt(product.get("productId").toString()));
            billProduct.setProductCount(Integer.parseInt(product.get("count").toString()));
            billProduct.setOrderBill(orderBill);
            Product productFromId = new Product();
            productFromId.setId(Integer.parseInt(product.get("productId").toString()));
            billProduct.setProduct(productFromId);
            billProduct.setBillProductId(billProductId);
            billProductRepository.save(billProduct);
        }
        return "done";
    }
}
