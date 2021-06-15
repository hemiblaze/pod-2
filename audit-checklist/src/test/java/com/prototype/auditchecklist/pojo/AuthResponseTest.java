package com.prototype.auditchecklist.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthResponseTest {

	@Mock
	AuthResponse authResponse=new AuthResponse();

	@Test
	public void testAuthResponseConstructor()
	{
		
		AuthResponse response=new AuthResponse("audit1", true);
		assertEquals( "audit1" ,  response.getUid() );
	}

	@Test
	public void testUid()
	{
		
		authResponse.setUid("audit1");
		assertEquals("audit1" , authResponse.getUid() );
	}
	

	@Test
	public void testIsValid()
	{
	
		authResponse.setValid(true);
		assertEquals( true , authResponse.isValid());
	}

	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }

}
