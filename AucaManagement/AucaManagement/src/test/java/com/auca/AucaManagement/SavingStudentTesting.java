package com.auca.AucaManagement;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.auca.AucaManagement.configuration.ConfigurationUtil;

public class SavingStudentTesting {

	Boolean connected = false;
	@Test
	public void test() {
	   Session session = ConfigurationUtil.getConnectionForStudent().openSession();
	   
	   if(session != null) {
		   connected = true;
	   }else {
		   connected = false;
	   }
	   assertTrue(connected);
	}

}
