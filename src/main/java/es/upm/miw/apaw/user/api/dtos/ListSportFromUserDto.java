package es.upm.miw.apaw.user.api.dtos;

import java.util.HashMap;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.User;

public class ListSportFromUserDto {
	private User user;
	private Long id;
	private String name;
	private boolean active; 
	
	public ListSportFromUserDto (User user) {
		this.user = user;
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
	
	public String listSports () {
		String str = "";
		HashMap<Long, Sport> sports = (HashMap<Long, Sport>) user.getSports();
		for (HashMap.Entry<Long, Sport> entry : sports.entrySet()) {
		    str += "{\"title\":\"" + entry.getValue().getTitle() +"\", \"category\":\"" + entry.getValue().getCategory() + "\"}," ;
		}
		return str.substring(0, str.length() -1);
	}
	
	@Override
	public String toString () {
		return "{\"id\":1,\"name\":\"David\",\"active\":\"true\", \"sport\":[" + listSports() + "]}";
	}
}
