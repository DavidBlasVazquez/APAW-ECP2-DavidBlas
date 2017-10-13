package es.upm.miw.apaw.user.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.user.api.controllers.SportController;
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
    
    public void createSport(String title, String category) throws SportFieldInvalidException {
    	validateField(title);
    	new SportController().createSport(title, category);
    } 
       
    public SportDto readSport (Long sportId) throws SportIdNotFoundException {
        Optional<SportDto> optional = new SportController().readSport(sportId);
        return optional.orElseThrow(() -> new SportIdNotFoundException(Long.toString(sportId)));
    }
  /*
    public SportDto  modifyCategory (int sportId, String category) throws SportIdNotFoundException {
    	if (sportId != 1) throw new SportIdNotFoundException();
    	return new SportDto("{\"id\":1,\"sport\":\"tennis\",\"category\":\""+category+"\"}");
    }
    */
}
