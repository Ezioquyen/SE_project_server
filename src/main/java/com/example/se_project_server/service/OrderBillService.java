package com.example.se_project_server.service;

import com.example.se_project_server.entity.OrderBill;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Map;

@Component
public interface OrderBillService {
    String saveBill(Map<String, Object> bill) throws ParseException;
}
