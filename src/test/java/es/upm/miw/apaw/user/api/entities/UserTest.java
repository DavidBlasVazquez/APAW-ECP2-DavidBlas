package es.upm.miw.apaw.user.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.entities.User;
import es.upm.miw.apaw.user.api.entities.builder.SportBuilder;

public class UserTest {
		private User user;	
		
		@Before 
		public void before () {
			user = new User(new Long(1));
			user.setName("David");
			user.addSport(new SportBuilder(1).title("tennis").category("junior").build());
		}
		
		@Test
		public void getIdTest() {
			assertEquals(new Long(1), user.getId());
		}
		
		@Test
		public void getNameTest() {
			assertEquals("David", user.getName());	
		}
		
		@Test
		public void getSportTest() {
			assertEquals("tennis", user.getSport(new Long(1)).getTitle());	
		}
}
