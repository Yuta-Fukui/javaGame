package com.lifegraph.team20.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lifegraph.team20.entity.Question2;

@Service
public class QuestionService2 {

//	public void Question(QurstionRepository2 qr) {
//	List<Question2> list = qr.selectQuestions();
//		System.out.println(list.toString());
//	}
	public void updateQuestions() {
		List<Question2> list = new ArrayList<Question2>();
		List<Question2>  newList = list.stream()
				.collect(Collectors.toList());
		newList.forEach(System.out::println);
	}

}
