package com.ensa.paiement.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ensa.paiement.model.Salarie;
import com.ensa.paiement.service.itf.SalarieServices;

public class TestServices {

	
	
	private static ClassPathXmlApplicationContext context;
    private static SalarieServices  iSalarie;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("/WEB-INF/spring-servlet.xml");
	    iSalarie=(SalarieServices) context.getBean("salarieServices");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() {
      iSalarie.add(new Salarie());
	}

//	@Test
//	public void testEdit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetSalarieById() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetSalarieByDepartement() {
		assertNotNull(iSalarie.getSalarieByDepartement("A"));
		
	}

//	@Test
//	public void testGetAllSalarie() {
//		fail("Not yet implemented");
//	}

}
