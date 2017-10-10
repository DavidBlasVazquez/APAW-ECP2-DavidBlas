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
	private void createUSer () {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USER).body("username:David").build();
        new HttpClientService().httpRequest(request);
	}
	
	@Test
    public void testCreateUSer () {
		createUSer();
    }
	
    @Test(expected = HttpException.class)
    public void testCreateUserNameEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(UserResource.USER).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadUser () {
    	createUSer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USER).path(UserResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"username\":\"David\",\"active\":\"true\"}", new HttpClientService().httpRequest(request).getBody());        
    }
	
    @Test(expected = HttpException.class)
    public void testIdNotFoundReadSport () {
    	createUSer();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USER).path(UserResource.ID).expandPath("2").build();
        new HttpClientService().httpRequest(request).getBody();      
    }
    
	@Test
    public void testDeactiveUser () {
		createUSer();
		HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PUT).path(UserResource.USER).path(UserResource.DEACTIVE).build();
		new HttpClientService().httpRequest(request).getBody();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(UserResource.USER).path(UserResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"username\":\"David\",\"active\":\"false\"}", new HttpClientService().httpRequest(request).getBody());        	
    }
}
