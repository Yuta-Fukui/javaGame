package com.lifegraph.team20.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name =  "Question")

public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "questionStatement")
	private String  questionStatement;

	@Column(name = "answer1")
	private String  answer1;

	@Column(name = "answer2")
	private String  answer2;

	@Column(name = "answer3")
	private String  answer3;

	@Column(name = "answer4")
	private String  answer4;


}