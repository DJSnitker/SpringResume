package com.codeslinger.resume;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeslinger.resume.factory.CommandFactoryInterface;

@Controller
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	private CommandFactoryInterface commandFactory;

    @RequestMapping(value="/interpret", method=RequestMethod.GET)
	@ResponseBody
    public String interpretRequest(@RequestParam(value="q", required=false, defaultValue="Ping") String command,
    							   @RequestParam(value="d", required=false, defaultValue="") String dynamicData) {
        return commandFactory.getCommand(command).execute(command,dynamicData);
    }
}