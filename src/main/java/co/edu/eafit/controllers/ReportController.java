package co.edu.eafit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.edu.eafit.models.Report;

@RestController
public class ReportController {
	private List<Report> reportList = new ArrayList<Report>();
	
	public ReportController() {
		reportList.add(new Report(1, "CAR993", "taxi", 1, "Me dejo tirado"));
		reportList.add(new Report(2, "ASD678", "bus", 1, "No me devolvio correctamente"));
		reportList.add(new Report(3, "GHJ", "taxi", 5, "Muy amable"));
	}
	
	@GetMapping(path="/report", produces="application/json")
	public String getReports() {
		Gson gson = new Gson();
		return gson.toJson(reportList);
	}

}
