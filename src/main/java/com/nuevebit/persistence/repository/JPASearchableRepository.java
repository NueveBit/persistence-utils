/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevebit.persistence.repository;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author emerino
 */
public abstract class JPASearchableRepository<T, S>
        extends AbstractJPARepository<T>
        implements SearchableRepository<T, S> {

    protected JPASearchableRepository(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    public T searchOne(S searchCriteria) {
        List<T> resultados = search(searchCriteria);
        if (resultados.size() > 1) {
            // TODO: Excepción específica
            throw new RuntimeException("There's more than 1 result for this "
                    + "search criteria");
        }

        return (resultados.isEmpty()) ? null : resultados.get(0);
    }

    @Override
    public List<T> search(S searchCriteria) {
        return search(searchCriteria, null);
    }

    @Override
    public final List<T> search(S searchCriteria, Pageable pageable) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(getEntityClass());

        Root<T> p = createQueryRoot(query, searchCriteria);
        query.select(p);

        Order sortOrder = getSortOrder(cb);
        if (sortOrder != null) {
            query.orderBy(sortOrder);
        }

        TypedQuery<T> typedQuery = getEntityManager().createQuery(query);
        if (pageable != null) {
            typedQuery
                    .setFirstResult(pageable.getOffset())
                    .setMaxResults(pageable.getPageSize());
        }

        return typedQuery.getResultList();
    }

    @Override
    public long count(S searchCriteria) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> q = cb.createQuery(Long.class);

        Root<T> p = createQueryRoot(q, searchCriteria);
        q.select(cb.count(p));

        return getEntityManager().createQuery(q).getSingleResult();
    }

    protected Order getSortOrder(CriteriaBuilder cb) {
        return null;
    }

    protected abstract Root<T> createQueryRoot(CriteriaQuery<?> query, S criteria);

}
