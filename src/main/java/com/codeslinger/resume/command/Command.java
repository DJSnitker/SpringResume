package com.codeslinger.resume.command;

import com.codeslinger.resume.command.CommandInterface;

public class Command implements CommandInterface{

	public String execute( String command, String dynamicData ){
		return "OK";
	}

}