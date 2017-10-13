package es.upm.miw.apaw.user.api.entities.builder;

import java.util.Calendar;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.User;


public class UserBuilder {
	private User user;
	public UserBuilder() {
		user = new User();
	}
	public UserBuilder name (String name) {
		user.setName(name);
		return this;
	}
	public UserBuilder birthDate (Calendar birthdate) {
		user.setBirthDate(birthdate);
		return this;
	}
	public UserBuilder active (boolean active) {
		user.setActive(active);
		return this;
	}
	public UserBuilder sport(Sport sport) {
		user.addSport(sport);
		return this;
	}
	public UserBuilder id (Long id) {
		user.setId(id);
		return this;
	}
	public User build() {
		return user;
	}
}
