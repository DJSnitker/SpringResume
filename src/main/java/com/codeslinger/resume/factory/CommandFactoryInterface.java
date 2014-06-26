package com.codeslinger.resume.factory;

import com.codeslinger.resume.command.Command;

public interface CommandFactoryInterface{

	public Command getCommand(String commandLookup);
	
}