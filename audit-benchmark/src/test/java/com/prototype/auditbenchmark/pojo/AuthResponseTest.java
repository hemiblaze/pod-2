package com.prototype.auditbenchmark.pojo;
/**
 * Test AuthResponse class
 */
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

	
	AuthResponse authResponse=new AuthResponse();
	/**
	 * Testing constructor
	 */	
	@Test
	public void testConstructor() {
		AuthResponse response=new AuthResponse("name",true);
		assertEquals("name",response.getUid());
	}
	/**
	 * Testing setter for uid
	 */	
	@Test
	public void testUid() {
		authResponse.setUid("name1");
		assertEquals("name1",authResponse.getUid());
	}
	/**
	 * Testing isValid setter
	 */	
	@Test
	public void testIsValid() {
		authResponse.setValid(true);
		assertEquals(true,authResponse.isValid());
	}
	

}
