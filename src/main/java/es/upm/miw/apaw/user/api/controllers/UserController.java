package es.upm.miw.apaw.user.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.user.api.daos.DaoFactory;
import es.upm.miw.apaw.user.api.dtos.ListSportFromUserDto;
import es.upm.miw.apaw.user.api.dtos.UserDto;
import es.upm.miw.apaw.user.api.entities.Sport;
import es.upm.miw.apaw.user.api.entities.User;
import es.upm.miw.apaw.user.api.entities.builder.UserBuilder;

public class UserController {
    private boolean existUserId(long userId) {
        return DaoFactory.getFactory().getUserDao().read(userId) != null;
    }
    
    private boolean existSportId(long sportId) {
        return DaoFactory.getFactory().getSportDao().read(sportId) != null;
    }
    
	public void createUser(String username) {
        DaoFactory.getFactory().getUserDao().create(new UserBuilder().name(username).build());
    }

	public Optional<UserDto> readUser(long  userId) {
		if (existUserId(userId)) {
			return Optional.of(new UserDto(DaoFactory.getFactory().getUserDao().read(userId)));
		} else {
			return Optional.empty();
		}
	}
	
	public Optional<UserDto> modifyActive(Long userId, boolean active) {
		if (existUserId(userId)) {
			User user = DaoFactory.getFactory().getUserDao().read(userId);
			user.setActive(active);
			return Optional.of(new UserDto(user));
		} else {
			return Optional.empty();
		}
	}

	public Optional<ListSportFromUserDto> addSportToUser(Long userId, Long sportId) {
		if (existUserId(userId) && existSportId(sportId)) {
			User user = DaoFactory.getFactory().getUserDao().read(userId);
			Sport sport = DaoFactory.getFactory().getSportDao().read(sportId);
			user.addSport(sport);
			return Optional.of(new ListSportFromUserDto(user));
		} else {
			return Optional.empty();
		}
	}
}
