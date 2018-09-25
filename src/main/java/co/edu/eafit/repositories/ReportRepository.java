package co.edu.eafit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.eafit.models.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{
	
}
