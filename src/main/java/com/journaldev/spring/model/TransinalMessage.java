package com.journaldev.spring.model;

public class TransinalMessage {
	
	
	public static String getResponse(String str) {
		
		 String typeOfDay;
	     switch (str) {
	         case "HI":
	             typeOfDay = "HI, I can create vm for you.DO you want me to do that";
	             break;
	         case "Yes":typeOfDay = "Ok, Please provide me following redail. 1. What is ram size";
             break;
	         case "Wednesday":
	         case "Thursday":
	             typeOfDay = "Midweek";
	             break;
	         case "Friday":
	             typeOfDay = "End of work week";
	             break;
	         case "Saturday":
	         case "Sunday":
	             typeOfDay = "Weekend";
	             break;
	         default:
	        	 typeOfDay = "re enter ur inputs";;
	     }
	     return typeOfDay;	
	     
	     
		
		//return "nand";
		
	}
	
	

}
