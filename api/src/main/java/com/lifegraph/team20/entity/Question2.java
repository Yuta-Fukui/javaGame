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

	private String name;
}
