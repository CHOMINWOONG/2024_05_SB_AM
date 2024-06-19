package com.example.demo.vo;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	int id;
	String title;
	String body;
	
	public Optional<Article> findById(Long id2) {

		return null;
	}
}


