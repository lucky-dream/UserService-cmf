package com.usermanager.test;

public class Print {
	private String _message;
	
	
	public String get_message() {
		return _message;
	}


	public void set_message(String _message) {
		this._message = _message;
	}


	public void printMessage()
	{
		System.out.println(_message);
	}
}
