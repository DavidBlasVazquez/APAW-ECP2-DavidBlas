package es.upm.miw.apaw.user.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.builder.SportBuilder;

public class SportTest {

	private Sport sport;
	
	@Before 
	public void before () {
		sport = new SportBuilder(new Long(1)).title("tennis").category("junior").build();
	}
	
	@Test
	public void getIdTest() {
		assertEquals(1, sport.getId());
	}
	
	@Test
	public void getTitleTest() {
		assertEquals("tennis", sport.getTitle());	
	}
	
	@Test
	public void getCategoryTest() {
		assertEquals("junior", sport.getCategory());	
	}
}
