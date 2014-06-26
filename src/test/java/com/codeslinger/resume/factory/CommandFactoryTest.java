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
import com.codeslinger.resume.command.CommandInterface;
import com.codeslinger.resume.command.Command;
import com.codeslinger.resume.command.KeyValueCommand;

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
    public void testPingCommandReturnsCommand(){
        CommandInterface myCommand = testCommandFactory.getCommand("Ping");
    	Assert.assertNotNull("Verify Command Object is created by default", myCommand );
        Assert.assertTrue("Ping returns a Command Type", Command.class.getName().equalsIgnoreCase(myCommand.getClass().getName()));
    }

    @Test
    public void testDefaultCommandReturnsKeyValueCommand(){
        CommandInterface myCommand = testCommandFactory.getCommand("");
        Assert.assertNotNull("Verify Command Object is created by default", myCommand);
        Assert.assertTrue("<empty> returns a KeyValueCommand Type", KeyValueCommand.class.getName().equalsIgnoreCase(myCommand.getClass().getName()));
    }

}