package es.upm.miw.apaw.user.api.entities.builder;

import es.upm.miw.apaw.user.api.entities.Sport;

public class SportBuilder {
	private Sport sport;
	public SportBuilder (long id ) {
		sport = new Sport(id);
		sport.setId(id);	
	}
	public SportBuilder title(String title) {
		sport.setTitle(title);
		return this;	
    }
	public SportBuilder category(String category) {
		sport.setCategory(category);
		return this;	
    }
	public Sport build () {
		return sport;
	}
}
