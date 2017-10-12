package es.upm.miw.apaw.user.api.daos.memory;

import es.upm.miw.apaw.user.api.daos.DaoFactory;
import es.upm.miw.apaw.user.api.daos.UserDao;
import es.upm.miw.apaw.user.api.daos.SportDao;

public class DaoMemoryFactory extends DaoFactory {

    private UserDao userDao;

    private SportDaoMemory sportDao;

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoMemory();
        }
        return userDao;
    }

    @Override
    public SportDao getSportDao() {
        if (sportDao == null) {
            sportDao = new SportDaoMemory();
        }
        return sportDao;
    }

}
