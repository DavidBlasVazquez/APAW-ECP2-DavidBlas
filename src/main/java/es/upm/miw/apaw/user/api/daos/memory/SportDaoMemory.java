package es.upm.miw.apaw.user.api.daos.memory;

import java.util.HashMap;


import es.upm.miw.apaw.user.api.daos.SportDao;
import es.upm.miw.apaw.user.api.entities.Sport;

public class SportDaoMemory extends GenericDaoMemory<Sport> implements SportDao {

    public SportDaoMemory() {
        this.setMap(new HashMap<Long, Sport>());
    }

    @Override
    protected Long getId(Sport entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Sport entity, Long id) {
        entity.setId(id);
    }
}
