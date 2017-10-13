package es.upm.miw.apaw.user.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.user.api.controllers.UserController;
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
    
    public void createUser(String userName) throws UserFieldInvalidException {
    	validateField(userName);
    	new UserController().createUser(userName);
    }
           
    public UserDto readUser (long userId) throws UserIdNotFoundException {
        Optional<UserDto> optional = new UserController().readUser(userId);
        return optional.orElseThrow(() -> new UserIdNotFoundException(Long.toString(userId)));
    }
    
    
    
   /* 
    
    
    public UserDto modifyActive (int userId, boolean activeState) throws UserIdNotFoundException {
    	if (userId != 1 ) throw new UserIdNotFoundException();
        return new UserDto("{\"id\":1,\"username\":\"David\",\"active\":\""+activeState+"\"}");
    }
    
    public UserDto linkSportToUser (int userId, int sportId) throws UserIdNotFoundException, SportIdNotFoundException {
    	if (userId  != 1) throw new UserIdNotFoundException();
    	if (sportId != 1) throw new SportIdNotFoundException();
    	return new UserDto("{\"id\":1,\"username\":\"David\",\"active\":\"true\", \"sport\":[ {\"title\":\"tennis\", \"category\":\"junior\"} ]}");
    }
    */
}
