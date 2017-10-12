package es.upm.miw.apaw.user.api.resources;

import es.upm.miw.user.api.resources.exceptions.SportFieldInvalidException;
import es.upm.miw.user.api.resources.exceptions.SportIdNotFoundException;

public class SportResource {
    public static final String SPORT = "sport";
    public static final String CATEGORY = "/category";
    public static final String ID = "/{id}";
    
    public String readSport (int sportId) throws SportIdNotFoundException {
    	return "{\"id\":1,\"sport\":\"tennis\"}";
    }
    
    public void createSport(String sportName) throws SportFieldInvalidException {
    	validateField(sportName);
    	new SportIdNotFoundException(sportName);
    }
    
    public void modifyCategory (int sportId) throws SportIdNotFoundException {
    	new SportIdNotFoundException(String.valueOf(sportId));
    }
    private void validateField(String field) throws SportFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new SportFieldInvalidException(field);
        }
    }
}
