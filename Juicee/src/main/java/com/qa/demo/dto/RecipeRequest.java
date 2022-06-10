package com.qa.demo.dto;

import com.qa.demo.dao.Ingredients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipeRequest {
	
	
	
	private Ingredients Ingredients;

}
