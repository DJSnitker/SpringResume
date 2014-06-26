package com.codeslinger.resume.factory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Service;

import com.codeslinger.resume.command.Command;

@Service
public class CommandFactory implements CommandFactoryInterface {

	public Command getCommand(String commandLookup){
		return new Command();
	}

}