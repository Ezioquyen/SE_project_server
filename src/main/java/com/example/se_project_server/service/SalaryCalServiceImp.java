package com.example.se_project_server.service;
import com.example.se_project_server.entity.IBillProduct;
import com.example.se_project_server.entity.ISalaryCal;
import com.example.se_project_server.repository.TimekeepingRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
@Component
public class SalaryCalServiceImp implements SalaryCalService{
    private final TimekeepingRepository timekeepingRepo;

    public SalaryCalServiceImp(TimekeepingRepository timekeepingRepo) {
        this.timekeepingRepo = timekeepingRepo;
    }


    @Override
    public List<ISalaryCal> getAllSalaryCal(LocalDate dateStart, LocalDate dateEnd) {
        return timekeepingRepo.getAllSalaryCal(dateStart, dateEnd);
    }

    @Override
    public List<ISalaryCal> getSalaryBySearching(String stringSearch, LocalDate dateStart, LocalDate dateEnd) {
        return  timekeepingRepo.getSalaryBySearch(stringSearch, dateStart, dateEnd);
    }

    @Override
    public List<IBillProduct> getSalaryPerDay(LocalDate dateStart, LocalDate dateEnd) {
        return timekeepingRepo.getSalaryPerDay(dateStart, dateEnd);
    }

    @Override
    public List<IBillProduct> getSalaryPerMonth(LocalDate dateStart, LocalDate dateEnd) {
        return timekeepingRepo.getSalaryPerMonth(dateStart, dateEnd);
    }
}
