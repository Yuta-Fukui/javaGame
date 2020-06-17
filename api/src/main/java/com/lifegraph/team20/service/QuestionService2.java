package com.lifegraph.team20.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.repository.QuestionRepository2;


@Service
public class QuestionService2 {

	@Autowired
	private QuestionRepository2 qr;

//	public void Question(QurstionRepository2 qr) {
//	List<Question2> list = qr.selectQuestions();
//		System.out.println(list.toString());
//	}
	public List<Question2> updateQuestions() {
		List<Question2> list = new ArrayList<Question2>();
		list = qr.selectQuestions();
		Collections.shuffle(list);
		return list;

	}

}
