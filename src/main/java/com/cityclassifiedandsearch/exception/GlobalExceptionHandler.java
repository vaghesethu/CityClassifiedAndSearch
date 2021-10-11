package com.cityclassifiedandsearch.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoRecordFoundException.class)
	@ResponseBody
	public ErrorResponse noRecordFoundHandler(Exception ex) {
		ErrorResponse response=new ErrorResponse();
		response.setMessage("Record Not Found");
		return response;
	}

}
