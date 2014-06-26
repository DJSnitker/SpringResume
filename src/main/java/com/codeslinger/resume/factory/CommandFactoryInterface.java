package com.codeslinger.resume.factory;

import com.codeslinger.resume.command.CommandInterface;

public interface CommandFactoryInterface{

	public CommandInterface getCommand(String commandLookup);
	
}