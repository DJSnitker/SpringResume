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
        Assert.assertEquals("Names Match", "Douglas J Snitker", commandResult);
    }

    @Test
    public void testExecutingEmailCommand(){
        String commandResult = myCommand.execute("Email+Address","SPAM - the other not so meat, meat product");
        Assert.assertEquals("Emails Match", "dougsnitker@gmail.com", commandResult);
    }

    @Test
    public void testExecutingPhoneCommand(){
        String commandResult = myCommand.execute("Phone","Hey I just met you, and this is crazy - here's my number, so call me maybe?");
        Assert.assertEquals("Phone Numbers Match", "432-250-4375", commandResult);
    }

    @Test
    public void testExecutingReferrerCommand(){
        String commandResult = myCommand.execute("Referrer","Who sent you?!");
        Assert.assertEquals("Referrers Match", "CareerBuilder / Websearches", commandResult);
    }

    @Test
    public void testExecutingDegreeCommand(){
        String commandResult = myCommand.execute("Degree","Show me your papers!");
        Assert.assertEquals("Degrees Match", "Bachelor of Science, Computer Science - Angelo State University, Class of 2000", commandResult);
    }

    @Test
    public void testExecutingResumeCommand(){
        String commandResult = myCommand.execute("Resume","Hello Dispatch, we need a records check on a male subject...");
        Assert.assertEquals("Resume is a Match", "url", commandResult);
    }

    @Test
    public void testExecutingSourceCommand(){
        String commandResult = myCommand.execute("Source","Ooooooh!  Shiny!");
        Assert.assertEquals("Source is a Match", "url", commandResult);
    }

    @Test
    public void testExecutingYearsCommand(){
        String commandResult = myCommand.execute("Years","With great power comes great responsibility!");
        Assert.assertEquals("Years Match", "14", commandResult);
    }

    @Test
    public void testExecutingPositionCommand(){
        String commandResult = myCommand.execute("Position","Ask not what your country can do for you, but what you can do for your country!");
        Assert.assertEquals("Positions Match", "Senior Developer", commandResult);
    } 

    @Test
    public void testExecutingStatusCommand(){
        String commandResult = myCommand.execute("Status","You ain't riding dirty are you?!");
        Assert.assertEquals("Status Match", "Yes", commandResult);
    }    

}