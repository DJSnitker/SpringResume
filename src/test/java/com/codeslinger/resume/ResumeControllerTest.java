package com.codeslinger.resume;

import org.junit.Assert;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeslinger.resume.ResumeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
public class ResumeControllerTest{

	@Autowired
	ResumeController testResumeControllerInstance;

    @Test
    public void testControllerTestContext() {
    	Assert.assertNotNull("Test setup not successful, resume controller did not inject",testResumeControllerInstance);
    }

    @Test
    public void testDefaultCommand(){
    	Assert.assertTrue("Default Command Should Return OK",testResumeControllerInstance.interpretRequest("Ping","Data").equalsIgnoreCase("OK"));
    }

}