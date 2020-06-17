package com.lifegraph.team20.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Question2 {

	private Long id;

	private String questionStatement;

	private String answer1;

	private String answer2;

	private String answer3;

	private String answer4;

//	public Question2(String questionStatement, String answer1, String answer2, String answer3, String answer4) {
//		super();
//		this.questionStatement = questionStatement;
//		this.answer1 = answer1;
//		this.answer2 = answer2;
//		this.answer3 = answer3;
//		this.answer4 = answer4;
//	}



}
