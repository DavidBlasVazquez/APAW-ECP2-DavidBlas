package es.upm.miw.apaw.user.api.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User  {
	private Long id;
	private String name;
	private Calendar birthDate;
	private boolean active;
	private Map<Long,Sport> sports = new HashMap<Long,Sport>();
	public User (Long id)  {
		assert id != null;
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		assert id != null;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		assert name != null;
		this.name = name;
	}
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar birthdate) {
		assert birthdate != null;
		this.birthDate = birthdate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		assert active != null;
		this.active = active;
	}
	public void addSport(Sport sport) {
		assert sport != null;
		sports.put(sport.getId(), sport);
	}
	public Sport getSport(Long id) {
		assert id != null;
		return sports.get(id);
	}
}
