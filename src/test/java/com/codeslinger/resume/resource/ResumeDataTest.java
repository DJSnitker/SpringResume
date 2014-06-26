package com.codeslinger.resume.resource;

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
import com.codeslinger.resume.resource.ResumeData;
import org.jdom2.Element;
import org.jdom2.Attribute;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-context.xml"})
public class ResumeDataTest{

    @Autowired
    private ResumeData myResumeData;

    //This tests the spring configuration in test for using the resume data object
    @Test
    public void testResumeInjection(){
       Assert.assertNotNull("myResumeData object did not inject", myResumeData); 
    }

    //The following tests are overkill, and not necessarily purely unit tests since this is a key value reader - 
    //all of the tests below are included for completeness against the data set.  The commands themselves are functional
    //and are covered under the appropriate command test
    @Test
    public void testName(){    	
    	Assert.assertTrue("name is the same", myResumeData.getDataValue("Name").equalsIgnoreCase("Douglas J Snitker"));
    }

    @Test
    public void testEmail(){   	
    	Assert.assertTrue("email is the same", myResumeData.getDataValue("Email").equalsIgnoreCase("dougsnitker@gmail.com"));
    }

    @Test
    public void testPhone(){   	
    	Assert.assertTrue("phone numbers are the same", myResumeData.getDataValue("Phone").equalsIgnoreCase("432-250-4375"));
    }

    @Test
    public void testReferrer(){	
    	Assert.assertTrue("referrer is the same", myResumeData.getDataValue("Referrer").equalsIgnoreCase("CareerBuilder / Websearches"));
    }

    @Test
    public void testYears(){   	
    	Assert.assertTrue("years are the same", myResumeData.getDataValue("Years").equalsIgnoreCase("14"));
    }

    @Test
    public void testResume(){  	
    	Assert.assertTrue("resume is the same", myResumeData.getDataValue("Resume").equalsIgnoreCase("url"));
    }

    @Test
    public void testDegree(){   	
    	Assert.assertTrue("degree is the same", myResumeData.getDataValue("Degree").equalsIgnoreCase("Bachelor of Science, Computer Science - Angelo State University, Class of 2000"));
    }

    @Test
    public void testPosition(){	
    	Assert.assertTrue("position is the same", myResumeData.getDataValue("Position").equalsIgnoreCase("Senior Developer"));
    }

    @Test
    public void testSource(){ 	
    	Assert.assertTrue("source url is the same", myResumeData.getDataValue("Source").equalsIgnoreCase("url"));
	}    	
}