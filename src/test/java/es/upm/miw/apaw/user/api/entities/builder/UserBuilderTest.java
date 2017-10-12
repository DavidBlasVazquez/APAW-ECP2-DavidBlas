package es.upm.miw.apaw.user.api.entities.builder;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.User;
import es.upm.miw.apaw.user.api.entities.builder.UserBuilder;

public class UserBuilderTest {
	private User user;
	private UserBuilder userBuilder;
	private Long id = new Long(123456);
	@Before
	public void before() {
		user = new User(id);
		userBuilder = new UserBuilder(id);
	}
	@Test
	public void idTest() {
		assertEquals(user.getId(), userBuilder.build().getId());
	}
	@Test
	public void nameTest() {
		String name = "name";
		user.setName(name);
		userBuilder.name(name);
		assertEquals(user.getName(), userBuilder.build().getName());
	}
	@Test
	public void birthDateTest() {
		Calendar calendar = Calendar.getInstance();
		user.setBirthDate(calendar);
		userBuilder.birthDate(calendar);
		assertEquals(user.getBirthDate(), userBuilder.build().getBirthDate());
	}
	@Test
	public void activeTest() {
		user.setActive(true);
		userBuilder.active(true);
		assertEquals(user.isActive(), userBuilder.build().isActive());
	}
	@Test
	public void sportsTest() {
		Sport sport = (new SportBuilder(1)).title("football").build();
		user.addSport(sport);
		userBuilder.sport(sport);
		assertEquals(user.getSport(new Long(1)).getTitle(), userBuilder.build().getSport(new Long(1)).getTitle());
	}
}
