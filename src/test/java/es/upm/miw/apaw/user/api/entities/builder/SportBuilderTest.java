package es.upm.miw.apaw.user.api.entities.builder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.builder.SportBuilder;

public class SportBuilderTest {
	private Sport sport;
	private SportBuilder sportBuilder;
	private Long id = new Long(1234);

	@Before
	public void before () {
		sport = new Sport(id);
		sportBuilder = new SportBuilder(id);
	}
	@Test
	public void idTest() {
		assertEquals(sport.getId(), sportBuilder.build().getId());
	}
	@Test
	public void titleTest() {
		String title = "title";
		sport.setTitle(title);
		sportBuilder.title(title);
		assertEquals(sport.getTitle(), sportBuilder.build().getTitle());
	}
	@Test
	public void categoryTest() {
		String category= "category";
		sport.setCategory(category);
		sportBuilder.category(category);
		assertEquals(sport.getCategory(), sportBuilder.build().getCategory());
	}

}
