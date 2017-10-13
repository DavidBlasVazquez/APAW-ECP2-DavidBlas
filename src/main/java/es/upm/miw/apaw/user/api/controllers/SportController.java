package es.upm.miw.apaw.user.api.controllers;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.upm.miw.apaw.user.api.daos.DaoFactory;
import es.upm.miw.apaw.user.api.dtos.SportDto;
import es.upm.miw.apaw.user.api.entities.builder.SportBuilder;

public class SportController {
	  private boolean existSportId(long sportId) {
	    	Logger logger = LogManager.getLogger(this.getClass().getName());
	    	logger.info("sportid::" + sportId);
	        return DaoFactory.getFactory().getSportDao().read(sportId) != null;
	    }
	    
		public void createSport(String title, String category) {
	        DaoFactory.getFactory().getSportDao().create(new SportBuilder().title(title).category(category).build());
	    }

		public Optional<SportDto> readSport(long sportId) {
			if (existSportId(sportId)) {
				return Optional.of(new SportDto(DaoFactory.getFactory().getSportDao().read(sportId)));
			} else {
				return Optional.empty();
			}
		}

}
