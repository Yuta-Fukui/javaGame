package com.lifegraph.team20.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.lifegraph.team20.model.Question;
import com.lifegraph.team20.service.JavaGameService;

public class JavaGame {


//ボタンをおす
//APIが動く
//データを5こ引っ張ってくる

	@Autowired
	public JavaGameService service;

	@GetMapping(value = "/question")
	public ResponseEntity<List<Question>> Question(){
	return ResponseEntity.ok(service.Question());
	}
}