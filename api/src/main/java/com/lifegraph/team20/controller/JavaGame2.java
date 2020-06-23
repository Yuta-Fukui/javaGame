package com.lifegraph.team20.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lifegraph.team20.entity.Answer;
import com.lifegraph.team20.entity.Question2;
import com.lifegraph.team20.service.QuestionService2;


@Controller
public class JavaGame2 {
	@Autowired
	private QuestionService2 qs;

	@GetMapping(value = "/question")
	public ResponseEntity<Question2> question() throws IOException {

		// get Question
		Question2 list = qs.updatedQuestion();

		return ResponseEntity.ok(list);
	}
//
//	@GetMapping(value = "/answer/{questionId}")
//	public ResponseEntity<List<Answer>> answer(@PathVariable("questionId") Long questionId) throws IOException {
//
//		List<Answer> answer = qs.updatedAnswer(questionId);
//		System.out.println(answer.toString());
//		System.out.println("-----------------");
//
//		return ResponseEntity.ok(answer);
//	}

	@GetMapping(value = "/answer")
	public ResponseEntity<List<Answer>> answer(@RequestParam("questionId") Long questionId) throws IOException {

		List<Answer> answer = qs.updatedAnswer(questionId);

		return ResponseEntity.ok(answer);
	}

}
