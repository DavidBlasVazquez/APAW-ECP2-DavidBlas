package es.upm.miw.apaw.user.api.controllers;

import es.upm.miw.apaw.user.api.daos.DaoFactory;
import es.upm.miw.apaw.user.api.entities.builder.UserBuilder;

public class UserController {

	   public void createUser(String username) {
	        DaoFactory.getFactory().getUserDao().create(new UserBuilder().name(username).build());
	    }
}
