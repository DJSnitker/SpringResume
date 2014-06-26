package com.codeslinger.resume.command;

import org.junit.Assert;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.codeslinger.resume.command.PuzzleCommand;

public class PuzzleCommandTest{

	private PuzzleCommand puzzler;

	@Before
	public void setup(){
		puzzler = new PuzzleCommand();
	}

	@After
	public void tearDown(){
		puzzler = null;
	}

	@Test
	public void testBuildingArray(){
		Assert.assertTrue( puzzler.getHeight() == puzzler.getWidth() );
	}
}