package es.upm.miw.apaw.user.api.entities.builder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.User;
import es.upm.miw.apaw.user.api.entities.builder.UserBuilder;

public class UserBuilderTest {
	private User user;
	private UserBuilder userBuilder;
	
	@Before
	public void before() {
		user = new User();
		user.setName("David");
		user.setActive(true);
		Sport sport = new SportBuilder().id(new Long(1)).title("tennis").category("junnior").build();
		user.addSport(sport);
		user.setId(new Long(1));
		userBuilder = new UserBuilder().id(new Long(1)).name("David").active(true).sport(sport);;
	}
	@Test
	public void idTest() {
		assertEquals(user.getId(), userBuilder.build().getId());
	}
	@Test
	public void nameTest() {
		assertEquals(user.getName(), userBuilder.build().getName());
	}
	@Test
	public void activeTest() {
		assertEquals(user.isActive(), userBuilder.build().isActive());
	}
	@Test
	public void sportsTest() {
		assertEquals(user.getSport(new Long(1)).getTitle(), userBuilder.build().getSport(new Long(1)).getTitle());
	}
}
