package com.gomesdevelopers.NutriSmart.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	
	private String errorHttpStatus;
	private String message;
}
