package es.upm.miw.apaw.user.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.user.api.daos.UserDao;
import es.upm.miw.apaw.user.api.entities.User;

public class UserDaoMemory extends GenericDaoMemory<User> implements UserDao {

    public UserDaoMemory() {
        this.setMap(new HashMap<Long, User>());
    }

    @Override
    protected Long getId(User entity) {
        return entity.getId();
    }

    @Override
    protected void setId(User entity, Long id) {
        entity.setId(id);

    }
}
