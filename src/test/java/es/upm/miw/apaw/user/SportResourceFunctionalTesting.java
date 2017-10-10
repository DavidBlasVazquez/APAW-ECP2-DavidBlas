package es.upm.miw.apaw.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.http.HttpClientService;
import es.upm.miw.apaw.user.http.HttpException;
import es.upm.miw.apaw.user.http.HttpMethod;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpRequestBuilder;

public class SportResourceFunctionalTesting {
	private void createSport () {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SportResource.SPORT).body("sport:tennis").build();
        new HttpClientService().httpRequest(request);
	}
	
	@Test
    public void testCreateSport () {
		createSport();
    }
	
    @Test(expected = HttpException.class)
    public void testCreateSportNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SportResource.SPORT).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadSport () {
    	createSport();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SportResource.SPORT).path(SportResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"sport\":\"tennis\"}", new HttpClientService().httpRequest(request).getBody());        
    }
	
    @Test(expected = HttpException.class)
    public void testIdNotFoundReadSport () {
    	createSport();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(SportResource.SPORT).path(SportResource.ID).expandPath("2").build();
        String response = new HttpClientService().httpRequest(request).getBody();      
    }
}
