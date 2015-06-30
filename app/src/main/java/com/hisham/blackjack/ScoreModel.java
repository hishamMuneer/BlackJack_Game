package com.hisham.blackjack;

public class ScoreModel {
	
	String name;
	int score;
	String date;
	
	public ScoreModel() {
		// TODO Auto-generated constructor stub
	}

	public ScoreModel(String name, int score, String date) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

}
