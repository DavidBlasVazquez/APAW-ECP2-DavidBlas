package es.upm.miw.apaw.user.api.entities.builder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.builder.SportBuilder;

public class SportBuilderTest {
	private Sport sport;
	private SportBuilder sportBuilder;

	@Before
	public void before () {
		sport = new Sport();
		sport.setId(new Long(1));
		sport.setTitle("tennis");
		sport.setCategory("junior");
		sportBuilder = new SportBuilder().id(new Long(1)).category("junior").title("tennis");
	}
	@Test
	public void idTest() {
		assertEquals(sport.getId(), sportBuilder.build().getId());
	}
	@Test
	public void titleTest() {
		assertEquals(sport.getTitle(), sportBuilder.build().getTitle());
	}
	@Test
	public void categoryTest() {
		assertEquals(sport.getCategory(), sportBuilder.build().getCategory());
	}

}
