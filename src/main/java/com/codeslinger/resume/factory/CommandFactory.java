package com.codeslinger.resume.factory;

import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.codeslinger.resume.command.CommandInterface;
import com.codeslinger.resume.command.KeyValueCommand;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CommandFactory implements CommandFactoryInterface, ApplicationContextAware {
 
 	private ApplicationContext applicationContext;

 	@Autowired
 	KeyValueCommand kvCommand;

 	@Override
  	public void setApplicationContext(ApplicationContext applicationContext) {
    	this.applicationContext = applicationContext;
  	}
	
	public CommandInterface getCommand(String commandLookup){
		CommandInterface retrievedCommand;
		try{
			retrievedCommand = (CommandInterface)applicationContext.getBean(commandLookup);		
		}
		catch(Exception e){
			//return the default command as this catch means there is no named bean
			retrievedCommand = kvCommand;
		}
		return retrievedCommand;
	}

}