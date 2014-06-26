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

    @Test
    public void testResumeInjection(){
       Assert.assertNotNull("myResumeData object did not inject", myResumeData); 
    }

    @Test
    public void testRetrievValueInDataFile(){    	
    	Assert.assertTrue("Name lookup works for key values", myResumeData.getDataValue("Name").equalsIgnoreCase("Douglas J Snitker"));
    }

    @Test
    public void testRetrievValueInDataFileWithComplexName(){       
        Assert.assertTrue("Name lookup works for key values", myResumeData.getDataValue("Email Address").equalsIgnoreCase("dougsnitker@gmail.com"));
    }

    @Test
    public void testRetrieveValueNotInDataFile(){   	
    	Assert.assertNull("email is the same", myResumeData.getDataValue("EmailAddress"));
    }
    
}