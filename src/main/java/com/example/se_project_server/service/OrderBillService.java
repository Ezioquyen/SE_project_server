package com.example.se_project_server.service;


import org.springframework.stereotype.Component;


import java.text.ParseException;
import java.util.Map;

@Component
public interface OrderBillService {
    String saveBill(Map<String, Object> bill) throws ParseException;
}
