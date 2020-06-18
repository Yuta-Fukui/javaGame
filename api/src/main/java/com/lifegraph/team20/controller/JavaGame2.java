package com.lifegraph.team20.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.service.QuestionService2;



@Controller
public class JavaGame2 {
	@Autowired
	private QuestionService2 qs;

	@GetMapping(value = "/question")
	public ResponseEntity<List<Question2>> question() throws IOException {
		// Listを適当に作っていれる

		List<Question2> listB = qs.updateQuestions();
		System.out.println(listB.toString());


		return ResponseEntity.ok(listB);
	}
}
