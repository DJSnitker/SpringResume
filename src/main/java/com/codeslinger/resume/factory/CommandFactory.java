package com.codeslinger.resume.factory;

import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.codeslinger.resume.command.CommandInterface;

@Service
public class CommandFactory implements CommandFactoryInterface, ApplicationContextAware {
 
 	private ApplicationContext applicationContext;

 	@Override
  	public void setApplicationContext(ApplicationContext applicationContext) {
    	this.applicationContext = applicationContext;
  	}
	
	public CommandInterface getCommand(String commandLookup){
		return (CommandInterface)applicationContext.getBean(commandLookup);
	}

}