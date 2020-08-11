package com.lifegraph.team20.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lifegraph.team20.entity.Answer;
import com.lifegraph.team20.entity.Question2;


@Repository
public class QuestionRepository2  {

	@Autowired
	private JdbcTemplate db;

	public List<Question2> selectQuestions () {
		final String sql = "SELECT * FROM Question";
		return db.query(sql, new RowMapper<Question2>() {
			public Question2 mapRow(ResultSet rs, int RowNum) throws SQLException {
				return new Question2(rs.getLong("id"),rs.getString("questionStatement"), rs.getString("answer1"),
						rs.getString("answer2"),rs.getString("answer3"),rs.getString("answer4"));
			}
		});
	}

	public List<Answer> selectAnswer (Long id) {
		final String sql = "SELECT * FROM Correct_Answer where questionId =" + id;
		return db.query(sql, new RowMapper<Answer>() {
			public Answer mapRow(ResultSet rs, int RowNum) throws SQLException {
				return new Answer(rs.getLong("id"),rs.getLong("questionId"),
						rs.getString("correctAnswer"),rs.getString("explanation"));
			}
		});
	}
}
