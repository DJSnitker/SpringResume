package com.codeslinger.resume.command;

import com.codeslinger.resume.command.CommandInterface;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PuzzleCommand implements CommandInterface{

	private int height;
	private int width;

	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}

	public String execute( String command, String dynamicData ){
		return "OK";
	}

}