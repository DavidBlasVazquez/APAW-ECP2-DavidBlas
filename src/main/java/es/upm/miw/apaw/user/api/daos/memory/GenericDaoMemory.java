package es.upm.miw.apaw.user.api.daos.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.upm.miw.apaw.user.api.daos.GenericDao;

public abstract class GenericDaoMemory<T> implements GenericDao<T, Long> {

    private Map<Long, T> map;

    private long id;

    public GenericDaoMemory() {
        id = 1;
    }

    protected void setMap(Map<Long, T> map) {
        this.map = map;
    }

    @Override
    public void create(T entity) {
        map.put(id, entity);
        this.setId(entity,id);
        id++;
    }

    @Override
    public T read(Long id) {
        return map.get(id);
    }

    @Override
    public void update(T entity) {
        if (map.containsKey(this.getId(entity))) {
            map.put(this.getId(entity), entity);
        }
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    protected abstract Long getId(T entity);

    protected abstract void setId(T entity, Long id);

}
