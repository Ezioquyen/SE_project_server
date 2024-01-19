package com.example.se_project_server.service;

import com.example.se_project_server.entity.Staff;
import com.example.se_project_server.entity.Timekeeping;
import com.example.se_project_server.repository.TimekeepingRepository;
import com.example.se_project_server.serializable.TimekeepingId;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Component
public class TimekeepingServiceImp implements TimekeepingService{
    private final TimekeepingRepository timekeepingRepository;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TimekeepingServiceImp(TimekeepingRepository timekeepingRepository) {
        this.timekeepingRepository = timekeepingRepository;
    }

    @Override
    public void saveTimekeeping(Map<String, Object> input) {
        Timekeeping timekeeping = new Timekeeping();
        TimekeepingId timekeepingId = new TimekeepingId( input.get("staffId").toString(), LocalDate.parse(input.get("workDate").toString(), formatter));
        Staff staff = new Staff();
        staff.setId(input.get("staffId").toString());
        timekeeping.setId(timekeepingId);
        timekeeping.setStaff(staff);
        timekeepingRepository.save(timekeeping);
    }
}
