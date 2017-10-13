package es.upm.miw.apaw.user.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.user.api.daos.DaoFactory;
import es.upm.miw.apaw.user.api.dtos.UserDto;
import es.upm.miw.apaw.user.api.entities.builder.UserBuilder;

public class UserController {
    private boolean existUserId(long userId) {
        return DaoFactory.getFactory().getUserDao().read(userId) != null;
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
}
