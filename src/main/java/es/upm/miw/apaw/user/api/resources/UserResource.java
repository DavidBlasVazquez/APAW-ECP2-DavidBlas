package es.upm.miw.apaw.user.api.resources;

import es.upm.miw.apaw.user.api.dtos.UserDto;
import es.upm.miw.user.api.resources.exceptions.SportIdNotFoundException;
import es.upm.miw.user.api.resources.exceptions.UserFieldInvalidException;
import es.upm.miw.user.api.resources.exceptions.UserIdNotFoundException;

public class UserResource {
    public static final String USER = "user";
    public static final String ACTIVE = "/active";
    public static final String ID = "/{id}";
    public static final String SPORT = "/sport";
        
    private void validateField(String field) throws UserFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new UserFieldInvalidException(field);
        }
    }
    
    public UserDto readUser (int userId) throws SportIdNotFoundException {
    	if (userId != 1)throw new SportIdNotFoundException(); 
        return new UserDto("{\"id\":1,\"username\":\"David\",\"active\":\"true\"}");
    }
    
    public void createUser(String userName) throws UserFieldInvalidException {
    	validateField(userName);
    	new UserIdNotFoundException(userName);
    }
    
    public UserDto modifyActive (int userId, boolean activeState) throws UserIdNotFoundException {
    	if (userId != 1 ) throw new UserIdNotFoundException();
        return new UserDto("{\"id\":1,\"username\":\"David\",\"active\":\""+activeState+"\"}");
    }
    
    public UserDto linkSportToUser (int userId, int sportId) throws UserIdNotFoundException, SportIdNotFoundException {
    	if (userId  != 1) throw new UserIdNotFoundException();
    	if (sportId != 1) throw new SportIdNotFoundException();
    	return new UserDto("{\"id\":1,\"username\":\"David\",\"active\":\"true\", \"sport\":[ {\"title\":\"tennis\", \"category\":\"junior\"} ]}");
    }
}
