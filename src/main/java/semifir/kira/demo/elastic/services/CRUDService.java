package semifir.kira.demo.elastic.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface CRUDService<T> {
    Page<T> searchSimilar(T entity, String[] fields, Pageable pageable);

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);

    Optional<T> findById(String s);

    boolean existsById(String s);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<String> strings);

    long count();

    void deleteById(String s);

    void delete(T entity);

    void deleteAllById(Iterable<? extends String> strings);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();
}
