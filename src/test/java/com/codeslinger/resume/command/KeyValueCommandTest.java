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
    public void testExecutingNameCommand(){
        String commandResult = myCommand.execute("Name","Who do you think you are?");
        Assert.assertEquals("Names Match", commandResult, "Douglas J Snitker");
    }

    @Test
    public void testExecutingEmailCommand(){
        String commandResult = myCommand.execute("Email","SPAM - the other not so meat, meat product");
        Assert.assertEquals("Emails Match", commandResult, "dougsnitker@gmail.com");
    }

    @Test
    public void testExecutingPhoneCommand(){
        String commandResult = myCommand.execute("Phone","Hey I just met you, and this is crazy - here's my number, so call me maybe?");
        Assert.assertEquals("Phone Numbers Match", commandResult, "432-250-4375");
    }

    @Test
    public void testExecutingReferrerCommand(){
        String commandResult = myCommand.execute("Referrer","Who sent you?!");
        Assert.assertEquals("Referrers Match", commandResult, "CareerBuilder / Websearches");
    }

    @Test
    public void testExecutingDegreeCommand(){
        String commandResult = myCommand.execute("Degree","Show me your papers!");
        Assert.assertEquals("Degrees Match", commandResult, "Bachelor of Science, Computer Science - Angelo State University, Class of 2000");
    }

    @Test
    public void testExecutingResumeCommand(){
        String commandResult = myCommand.execute("Resume","Hello Dispatch, we need a records check on a male subject...");
        Assert.assertEquals("Resume is a Match", commandResult, "url");
    }

    @Test
    public void testExecutingSourceCommand(){
        String commandResult = myCommand.execute("Source","Ooooooh!  Shiny!");
        Assert.assertEquals("Source is a Match", commandResult, "url");
    }

    @Test
    public void testExecutingYearsCommand(){
        String commandResult = myCommand.execute("Years","With great power comes great responsibility!");
        Assert.assertEquals("Years Match", commandResult, "14");
    }

    @Test
    public void testExecutingPositionCommand(){
        String commandResult = myCommand.execute("Position","Ask not what your country can do for you, but what you can do for your country!");
        Assert.assertEquals("Positions Match", commandResult, "Senior Developer");
    }    

}