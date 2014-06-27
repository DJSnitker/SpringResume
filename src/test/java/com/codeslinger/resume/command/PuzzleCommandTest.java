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
	public void testBuildingPuzzler(){
		Assert.assertNotNull( "Construction Failed", puzzler );
	}

	@Test
	public void testBuildingSizeSetting(){
		String result = puzzler.execute("Puzzle","Please solve this puzzle: ABCD A-->- B---< C---> D---=");
		Assert.assertTrue("Failed to calculate properly", " ABCD\nA=>>>\nB<=<<\nC<>=>\nD<><=".equals(result));
		
	}
}