package es.upm.miw.apaw.user.api.dtos;

import java.util.Calendar;

import es.upm.miw.apaw.user.api.entities.User;

public class UserDto {
	private Long id;
	private String name;
	private Calendar birthdate;
	private boolean active; 
	
	public UserDto () {
		
	}

	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		active = user.isActive();
	}
	
	public Long getId () {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isActive () {
		return active;
	}
	
	@Override
	public String toString () {
		return "{\"id:\" + id + \"name:\" + name + ,\"active\":\" + active + \"}";
		
		
	}
	    
}
