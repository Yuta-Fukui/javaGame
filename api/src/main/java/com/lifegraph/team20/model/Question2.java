package com.lifegraph.team20.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question")
public class Question2 {
    @Id
    @GeneratedValue
    private Long id;

	@Column(name = "questionStatement")
	private String questionStatement;

	@Column(name = "answer1")
	private String answer1;

	@Column(name = "answer2")
	private String answer2;

	@Column(name = "answer3")
	private String answer3;

	@Column(name = "answer4")
	private String answer4;
}
