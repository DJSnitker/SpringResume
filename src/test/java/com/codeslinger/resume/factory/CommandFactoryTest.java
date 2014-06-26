package com.codeslinger.resume.factory;

import org.junit.Assert;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeslinger.resume.factory.CommandFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
public class CommandFactoryTest{

	@Autowired
	CommandFactory testCommandFactory;

    @Test
    public void testCommandFactoryInjected() {
    	Assert.assertNotNull("Test setup not successful, resume controller did not inject",testCommandFactory);
    }

    @Test
    public void testPingCommandReturns(){
    	Assert.assertNotNull("Verify Command Object is created by default", testCommandFactory.getCommand("Ping"));
    }

    @Test
    public void testDefaultCommandReturns(){
        Assert.assertNotNull("Verify Command Object is created by default", testCommandFactory.getCommand(""));
    }

}