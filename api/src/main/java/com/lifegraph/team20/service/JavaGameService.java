package com.lifegraph.team20.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifegraph.team20.model.Question;
import com.lifegraph.team20.repository.QuestionRepository;



public class JavaGameService {
	@Autowired
	public QuestionRepository repository;

	public List<Question> Question() {
		return repository.findAll();
	}
}
