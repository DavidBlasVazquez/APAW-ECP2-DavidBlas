package es.upm.miw.apaw.user.api.resources;

import es.upm.miw.apaw.user.api.dtos.SportDto;
import es.upm.miw.user.api.resources.exceptions.SportFieldInvalidException;
import es.upm.miw.user.api.resources.exceptions.SportIdNotFoundException;

public class SportResource {
    public static final String SPORT = "sport";
    public static final String CATEGORY = "/category";
    public static final String ID = "/{id}";
    
    private void validateField(String field) throws SportFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new SportFieldInvalidException(field);
        }
    }
    
    public SportDto readSport (int sportId) throws SportIdNotFoundException {
    	if (sportId != 1) throw new SportIdNotFoundException();
    	return new SportDto("{\"id\":1,\"sport\":\"tennis\",\"category\":\"junior\"}");
    }
    
    public void createSport(String sportName) throws SportFieldInvalidException {
    	validateField(sportName);
    	new SportIdNotFoundException(sportName);
    }
    
    public SportDto  modifyCategory (int sportId, String category) throws SportIdNotFoundException {
    	if (sportId != 1) throw new SportIdNotFoundException();
    	return new SportDto("{\"id\":1,\"sport\":\"tennis\",\"category\":\""+category+"\"}");
    }
}
