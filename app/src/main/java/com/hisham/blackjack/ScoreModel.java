package com.hisham.blackjack;

import java.util.Date;

public class ScoreModel {
	
	String name;
	int score;
	Date date;
	
	public ScoreModel() {
		// TODO Auto-generated constructor stub
	}

	public ScoreModel(String name, int score, Date date) {
		super();
		this.name = name;
		this.score = score;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
