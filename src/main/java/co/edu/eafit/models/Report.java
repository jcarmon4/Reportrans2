package co.edu.eafit.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Report {
	
	@Id
	private Integer id;
	private String carPlate;
	private String type;
	private Integer score;
	private String comment;

	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(Integer id, String carPlate, String type, Integer score, String comment) {
		super();
		this.id = id;
		this.carPlate = carPlate;
		this.type = type;
		this.score = score;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
