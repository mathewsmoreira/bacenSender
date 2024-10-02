package org.devlouco.bacensenderhub.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class GenericCrudService<T, ID> {


    protected final JpaRepository<T, ID> repository;


    public GenericCrudService(final JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        Objects.requireNonNull(entity);
        return repository.save(entity);
    }

    public T update(T entity) {
        Objects.requireNonNull(entity);
        return repository.save(entity);
    }

    public Optional<T> findById(ID id) {
        Objects.requireNonNull(id);
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void delete(T entity) {
        Objects.requireNonNull(entity);
        repository.delete(entity);
    }


}
