package com.app4j.tradeobserver.common.dao;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<E, I extends Serializable> {

    E getById(I id);
    void saveOrUpdate(E e);
    void delete(E e);
    List<E> getByCriteria(Criterion criterion);
}
