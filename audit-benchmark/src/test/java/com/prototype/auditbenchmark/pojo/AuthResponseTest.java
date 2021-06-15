package com.prototype.auditbenchmark.pojo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

	
	AuthResponse authResponse=new AuthResponse();
	
	@Test
	public void testConstructor() {
		AuthResponse response=new AuthResponse("name",true);
		assertEquals("name",response.getUid());
	}
	
	@Test
	public void testUid() {
		authResponse.setUid("name1");
		assertEquals("name1",authResponse.getUid());
	}
	
	@Test
	public void testIsValid() {
		authResponse.setValid(true);
		assertEquals(true,authResponse.isValid());
	}
	

}
