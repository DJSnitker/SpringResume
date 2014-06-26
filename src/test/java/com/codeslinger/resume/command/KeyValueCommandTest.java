package com.codeslinger.resume.command;

import org.junit.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.codeslinger.resume.command.Command;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
public class KeyValueCommandTest{
    
    @Autowired
    private KeyValueCommand myCommand;

    @Test
    public void testResumeDataNotNull(){
        Assert.assertNotNull("Resume Data failed to construct", myCommand.getResumeData());
    }

    @Test
    public void testExecutingSimpleNameCommandThatExists(){
        String commandResult = myCommand.execute("Name","Who do you think you are?");
        Assert.assertEquals("Names Match", "Douglas J Snitker", commandResult);
    }

    @Test
    public void testExecutingComplexNameCommandThatExists(){
        String commandResult = myCommand.execute("Email Address","SPAM - the other not so meat, meat product");
        Assert.assertEquals("Emails Match", "dougsnitker@gmail.com", commandResult);
    }

    @Test
    public void testExecutingUnknownCommand(){
        String commandResult = myCommand.execute("Call","Hey I just met you, and this is crazy - here's my number, so call me maybe?");
        Assert.assertNull("Phone Numbers Match", commandResult);
    }    

}