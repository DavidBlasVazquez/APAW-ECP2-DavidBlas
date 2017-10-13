package es.upm.miw.apaw.user.api.dtos;

import es.upm.miw.apaw.user.api.entities.Sport;

public class SportDto {

	private long id;
	private String title;
	private String category;

	public SportDto () {

	}
	
	public SportDto (Sport sport) {
		id = sport.getId();
		title = sport.getTitle();
		category = sport.getCategory();
	}
	
	public String getTitle () {
		return title;
	}
	
	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return  "{\"id\":" + id + ",\"title\":\"" + title + "\",\"category\":\"" + category + "\"}";
	}
}
