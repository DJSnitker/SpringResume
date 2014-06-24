package com.codeslinger.resume;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeService {

    @RequestMapping("/interpret")
    public String executeCommand(@RequestParam(value="q", required=false, defaultValue="World") String command) {
        return "OK";
    }
}