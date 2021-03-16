package com.cg.eis.exception;

public class SalaryException {
	public static boolean ExceptionHandler(int sal) {

		try {
			if(sal<1000) {
				throw new Exception("Wrong entry");
			}
		}
		catch(Exception e){
			System.out.println("No such salary exists");
		}
		return false;
	}
}
