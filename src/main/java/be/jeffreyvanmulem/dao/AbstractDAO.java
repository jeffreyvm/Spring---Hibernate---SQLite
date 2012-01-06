package be.jeffreyvanmulem.dao;

import be.jeffreyvanmulem.model.AbstractEntity;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 06/01/12
 * Time: 10:04
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractDAO<T extends AbstractEntity> {
    protected final Logger LOG = Logger.getLogger(getClass());

    @PersistenceContext
    protected EntityManager em;

    private Class<T> entityClass;

    public AbstractDAO() {

    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public long count(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select( cb.count(cq.from(getEntityClass())) );
        return em.createQuery(cq).getSingleResult();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public T find(Long key){
        LOG.info("Trying to find " + getEntityClass() + " with id " + key + " among " + count() + " elements.");
        return em.find(getEntityClass(), key);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<T> findAll(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        cq.select( cq.from( getEntityClass() ) );
        return em.createQuery( cq ).getResultList();
    }
    
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<T> findAll(int firstResult, int maxResults){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        cq.select( cq.from( getEntityClass() ) );
        return em.createQuery( cq ).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<T> findRange(int from, int to){
        return findAll( from, ( to - from ) );
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
     public void clear(){
        em.clear();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void flush(){
        em.flush();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public T merge(T entity){
        return em.merge(entity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void persist(T entity){
        em.persist( entity );
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void remove(T entity){
        em.remove( em.merge(entity) );
    }

    public Class<T> getEntityClass() {
        if(entityClass == null){
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }
        
        return entityClass;
    }
}
