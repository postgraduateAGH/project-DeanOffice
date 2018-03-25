package com.mwo.group2;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest extends User {
    		
	@Test
    public void testGetYear() {
		Student student = new Student();
		student.setYear((short) 5);
		Assert.assertEquals(5, student.getYear());
    }
 
	@Test
    public void testSetYear() {
		Student student = new Student();
		student.setYear((short) 5);
		Assert.assertEquals(5, student.getYear());
    }
	
    @Test
    public void testGetGroup() {
    	Student student = new Student();
    	student.setGroup("test");
    	Assert.assertEquals("test", student.getGroup());
    }
 
    @Test
    public void testSetGroup() {
    	Student student = new Student();
    	student.setGroup("test");
    	Assert.assertEquals("test", student.getGroup());
    }
        
    @Test
    public void testGetLabGroup() {
    	Student student = new Student();
    	student.setLabGroup("test");
    	Assert.assertEquals("test", student.getLabGroup());
    }
     
    @Test
    public void testSetLabGroup() {
    	Student student = new Student();
    	student.setLabGroup("test");
    	Assert.assertEquals("test", student.getLabGroup());
    }
     
    @Test
    public void testGetStatus() {
    	Student student = new Student();
    	student.setStatus("test");
    	Assert.assertEquals("test", student.getStatus());
    }
     
    @Test
    public void testSetStatus() {
    	Student student = new Student();
    	student.setStatus("test");
        Assert.assertEquals("test", student.getStatus());
    }
    
    @Test
    public void testGetGrades() {
    	Student student = new Student();
    	student.setGrades("test");
    	Assert.assertEquals("test", student.getGrades());
    }
    
    @Test
    public void testSetGrades() {
    	Student student = new Student();
    	student.setGrades("test");
    	Assert.assertEquals("test", student.getGrades());
    }
    
}
