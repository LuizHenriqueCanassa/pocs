package br.com.luizcanassa.repository;

import br.com.luizcanassa.RepositoryException;

import java.util.List;

public interface Repository<T, I> {

    T findById(I i) throws RepositoryException;

    List<T> findAll();

    void save(T t);

    void delete(I i) throws RepositoryException;

    void update(T t, I i) throws RepositoryException;

}
