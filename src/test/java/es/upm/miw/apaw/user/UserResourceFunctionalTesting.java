package es.upm.miw.apaw.user;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.upm.miw.apaw.user.api.resources.SportResource;
import es.upm.miw.apaw.user.api.resources.UserResource;
import es.upm.miw.apaw.user.http.HttpClientService;
import es.upm.miw.apaw.user.http.HttpException;
import es.upm.miw.apaw.user.http.HttpMethod;
import es.upm.miw.apaw.user.http.HttpRequest;
import es.upm.miw.apaw.user.http.HttpRequestBuilder;

public class UserResourceFunctionalTesting {
	private void createUser () {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USER).body("David").build();
        new HttpClientService().httpRequest(request);
	}
	    
    private void createSport () {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(SportResource.SPORT).body("tennis:junior").build();
        new HttpClientService().httpRequest(request);
	}

	@Test
    public void testCreateUSer () {
		createUser();
    }
	
    @Test(expected = HttpException.class)
    public void testCreateUserNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USER).body("").build();
        new HttpClientService().httpRequest(request);
    }	

    public void testReadUser () {
    	createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USER).path(UserResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"username\":\"David\",\"active\":\"true\"}", new HttpClientService().httpRequest(request).getBody());        
    }
	
    @Test(expected = HttpException.class)
    public void testIdNotFoundReadUser () {
    	createUser();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USER).path(UserResource.ID).expandPath("2").build();
        new HttpClientService().httpRequest(request).getBody();      
    }
    
    @Test
    public void testAddSportToUser () {
    	createUser();
    	createSport();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PUT).path(UserResource.USER).path(UserResource.ID).expandPath("1").path(UserResource.SPORT).body("1").build();
        String response = new HttpClientService().httpRequest(request).getBody();  
        assertEquals("{\"id\":1,\"username\":\"David\",\"active\":\"true\", \"sport\":[ {\"title\":\"tennis\", \"category\":\"junior\"} ]}", response);        
    }
    
	@Test
    public void testModifyActiveOfUser () {
		createUser(); // Users are created having the active field as true by default.
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(UserResource.USER).path(UserResource.ID).expandPath("1").path(UserResource.ACTIVE).body("false").build();
        assertEquals("{\"id\":1,\"username\":\"David\",\"active\":\"false\"}", new HttpClientService().httpRequest(request).getBody());        	
    }
}
