package es.upm.miw.apaw.user.api.resources;

import es.upm.miw.user.api.resources.exceptions.SportIdNotFoundException;
import es.upm.miw.user.api.resources.exceptions.UserFieldInvalidException;
import es.upm.miw.user.api.resources.exceptions.UserIdNotFoundException;

public class UserResource {
    public static final String USER = "/user";
    public static final String ACTIVE = "/active";
    public static final String ID = "/{id}";
    
    public String readUser (int sportId) throws SportIdNotFoundException {
	    return "{\"id\":1,\"username\":\"David\",\"active\":\"false\"}";
   	    //return "{\"id\":1,\"username\":\"David\",\"active\":\"true\"}";
   	    //return "{\"id\":1,\"username\":\"David\",\"active\":\"true\", \"sport\":[ {\"title\":\"tennis\", \"category\":\"junior\"} ]}");
    }
    
    public void createUser(String userName) throws UserFieldInvalidException {
    	validateField(userName);
    	new UserIdNotFoundException(userName);
    }
    
    public void modifyActive (int userId) throws SportIdNotFoundException {
    	new SportIdNotFoundException(String.valueOf(userId));
    }
    
    public void addSport (int userId, int sportId) throws UserIdNotFoundException, SportIdNotFoundException {
    	new SportIdNotFoundException(String.valueOf(userId));
    }
    
    private void validateField(String field) throws UserFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new UserFieldInvalidException(field);
        }
    }
}
