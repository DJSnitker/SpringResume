package com.codeslinger.resume.command;

import com.codeslinger.resume.command.CommandInterface;
import com.codeslinger.resume.resource.ResumeData;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class KeyValueCommand implements CommandInterface{
	@Autowired
	private ResumeData resumeData;

	public ResumeData getResumeData(){
		return resumeData;
	}

	public String execute( String command, String dynamicData ){
		if(resumeData == null )
		{
			System.out.println("null xml data");
		}
		return resumeData.getDataValue( command );
	}

}