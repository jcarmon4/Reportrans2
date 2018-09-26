package co.edu.eafit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.edu.eafit.models.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

	List<Report> findByCarPlate(@Param("carPlate") String carPlate);
}
