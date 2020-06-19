package com.lifegraph.team20.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

	private Long id;

	private Long questionId;

	private String correctAnswer;

	private String explanation;
}
