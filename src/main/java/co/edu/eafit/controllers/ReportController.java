package co.edu.eafit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.edu.eafit.models.Report;

@RestController
public class ReportController {
	
	@GetMapping(path="/report", produces="application/json")
	public String getReports() {
		Gson gson = new Gson();
		
		Report report = new Report(1, "CAR993", "taxi", 1, "Me dejo tirado");
		
		return gson.toJson(report);
	}

}
