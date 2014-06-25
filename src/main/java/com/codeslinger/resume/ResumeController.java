package com.codeslinger.resume;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @RequestMapping(value="/interpret", method=RequestMethod.GET)
	@ResponseBody
    public String executeCommand(@RequestParam(value="q", required=false, defaultValue="Ping") String command) {
        return "OK";
    }
}