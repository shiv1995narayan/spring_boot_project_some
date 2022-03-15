package com.inn.util;

public class StudentException extends Exception {
	
		/**
		 *
		 */
		private static final long serialVersionUID = -7866616924378144580L;
		private String guiMessage;
		/**
		 * 
		 * @return String
		 */
		public String getGuiMessage(){
			return guiMessage;
		}
		/**
		 * 
		 * @param message
		 */
		public void setGuiMessage(String message){
			guiMessage="{\"errorMsg\": \""+message+"\"}";
		}
		/**
		 * 
		 */
	    public StudentException() {
	        super();
	    }
		/**
		 * Constructor.
		 *
		 * @param message
		 *             exception message
		 * @param cause
		 *             the cause of the exception
		 */
		public StudentException(String message, Throwable cause) {
			super(message, cause);
		}
		/**
		 * 
		 * @param cause
		 */
		public StudentException(Throwable cause) {
			super(cause.getMessage(), cause);
		}
		/**
		 * Constructor.
		 * @param message
		             
		 */
		public StudentException(String message) {
			super(message);
			setGuiMessage(message);
		}
		/**
		 * 
		 * @param message
		 * @param guiMessage
		 */
		public StudentException(String message, String guiMessage) {
			super(message);
			setGuiMessage(guiMessage);
		}

}