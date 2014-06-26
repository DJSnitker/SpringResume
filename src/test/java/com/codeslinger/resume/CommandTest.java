package com.codeslinger.resume;

import org.junit.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.codeslinger.resume.Command;

public class CommandTest{

    private Command myCommand;

    @Before
    public void setup(){
        myCommand = new Command();
    }

    @After
    public void tearDown(){
        myCommand = null;
    }

    @Test
    public void testCommandResponse(){
        Assert.assertTrue("Default Command returns 'OK'", myCommand.execute("random data").equalsIgnoreCase("OK"));
    }

}