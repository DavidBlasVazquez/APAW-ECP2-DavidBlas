package es.upm.miw.apaw.user.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.user.api.controllers.UserController;
import es.upm.miw.apaw.user.api.dtos.ListSportFromUserDto;
import es.upm.miw.apaw.user.api.dtos.UserDto;
import es.upm.miw.user.api.resources.exceptions.UserIdNotFoundException;
import es.upm.miw.user.api.resources.exceptions.UserFieldInvalidException;

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
    
    public UserDto  modifyActive (Long userId, boolean active) throws UserIdNotFoundException {
        Optional<UserDto> optional = new UserController().modifyActive(userId, active);
        return optional.orElseThrow(() -> new UserIdNotFoundException(Long.toString(userId)));
    }

    public ListSportFromUserDto addSportToUser (Long userId, Long sportId) throws UserIdNotFoundException, UserIdNotFoundException {
        Optional<ListSportFromUserDto> optional = new UserController().addSportToUser(userId, sportId);
        return optional.orElseThrow(() -> new UserIdNotFoundException(Long.toString(userId)));        
    }

}
