package com.cityclassifiedandsearch.exception;


public class ErrorResponse {
	
		 public ErrorResponse() {
			super();
			
		}
	 	public ErrorResponse(String message) {
	        super();
	        this.message = message;
	    }
	    private String message;	    

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
}
