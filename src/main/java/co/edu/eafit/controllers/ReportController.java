package co.edu.eafit.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.edu.eafit.models.Report;
import co.edu.eafit.repositories.ReportRepository;

@RestController
public class ReportController {
	private HashMap<String, Report> reportMap = new HashMap<>();
	
	@Autowired
	private ReportRepository reportRepository;
	
	public ReportController() {
	}
	
	@GetMapping(path="/report", produces="application/json")
	public String getReports(@RequestParam(value="carPlate", required=false) String carPlate) {
		Gson gson = new Gson();
		
		if (carPlate == null) {	
			List<Report> reportList = reportRepository.findAll();
			reportMap.clear();
			for (Report report : reportList) {
				reportMap.put(report.getCarPlate(), report);
			}
			return gson.toJson(reportMap.values());
		} else {
			Report report = reportMap.get(carPlate);
			List<Report> reportList = new ArrayList<>();
			reportList.add(report);
			return gson.toJson(reportList);
		}
	}
	
	@PostMapping(path="/report", consumes="application/json", produces="application/json")
	public String createReport(@RequestBody String json) {
		Gson gson = new Gson();
		Report report = gson.fromJson(json, Report.class);
		reportMap.put(report.getCarPlate(), report);
		
		Report stored = reportRepository.save(report);
		return gson.toJson(stored);
	}
}
