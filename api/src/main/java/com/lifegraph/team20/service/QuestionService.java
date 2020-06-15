package com.lifegraph.team20.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifegraph.team20.entity.Question;
import com.lifegraph.team20.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository qr;

	public List<Question> test() {
		return qr.findAll();
	}

}
