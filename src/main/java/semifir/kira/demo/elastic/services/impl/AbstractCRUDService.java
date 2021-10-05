package semifir.kira.demo.elastic.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import semifir.kira.demo.elastic.services.CRUDService;

import java.util.Optional;

public abstract class AbstractCRUDService<T> implements CRUDService<T> {

    private ElasticsearchRepository<T, String> repository;

    public AbstractCRUDService(ElasticsearchRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public Page<T> searchSimilar(T entity, String[] fields, Pageable pageable) {
        return repository.searchSimilar(entity, fields, pageable);
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Optional<T> findById(String s) {
        return repository.findById(s);
    }

    @Override
    public boolean existsById(String s) {
        return repository.existsById(s);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<T> findAllById(Iterable<String> strings) {
        return repository.findAllById(strings);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(String s) {
        repository.deleteById(s);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        repository.deleteAllById(strings);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
