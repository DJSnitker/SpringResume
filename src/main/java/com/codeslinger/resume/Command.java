package com.codeslinger.resume;

import com.codeslinger.resume.CommandInterface;

public class Command implements CommandInterface{

	public String execute( String dynamicData ){
		return "OK";
	}

}