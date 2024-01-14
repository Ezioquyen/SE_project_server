package com.example.se_project_server.service;


import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;

@Component
public interface OrderBillService {
    String saveBill(Map<String, Object> bill);
    List<Map<String,Object>> getAllOrderBill();
}
