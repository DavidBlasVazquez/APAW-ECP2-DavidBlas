package es.upm.miw.apaw.user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.user.api.daos.DaoFactory;
import es.upm.miw.apaw.user.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.http.HttpClientService;
import es.upm.miw.apaw.user.http.HttpException;
import es.upm.miw.apaw.user.http.HttpMethod;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpRequestBuilder;

public class SportResourceFunctionalTesting {
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }
    
	private void createSport () {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SportResource.SPORT).body("tennis:junior").build();
        new HttpClientService().httpRequest(request);
	}
	
	@Test
    public void testCreateSport () {
		createSport();
    }
	
    @Test(expected = HttpException.class)
    public void testCreateSportEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SportResource.SPORT).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadSport () {
    	createSport();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SportResource.SPORT).path(SportResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"title\":\"tennis\",\"category\":\"junior\"}", new HttpClientService().httpRequest(request).getBody());        
    }
    
    @Test(expected = HttpException.class)
    public void testEmptyReadSport () {
    	createSport();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SportResource.SPORT).path(SportResource.ID).expandPath("").build();
        assertEquals("{\"id\":1,\"title\":\"tennis\",\"category\":\"junior\"}", new HttpClientService().httpRequest(request).getBody());        
    }
	  
    @Test(expected = HttpException.class)
    public void testIdNotFoundReadSport () {
    	createSport();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SportResource.SPORT).path(SportResource.ID).expandPath("2").build();
        new HttpClientService().httpRequest(request).getBody();      
    }
    
    @Test
    public void testModifyCategoryToSport () {
    	createSport(); // It is created as junior.
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(SportResource.SPORT).path(SportResource.ID).expandPath("1").path(SportResource.CATEGORY).body("senior").build();
        assertEquals("{\"id\":1,\"title\":\"tennis\",\"category\":\"senior\"}", new HttpClientService().httpRequest(request).getBody());   
    }
}
