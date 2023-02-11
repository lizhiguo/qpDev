/*
package com.qp.common.manager;


import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface JpaManager<T, ID extends Serializable, R extends ExtendedQuerydslJpaRepository<T, ID>> {

    R getR();

    */
/**************************ExtendedQuerydslJpaRepository****************************************//*

    default Optional<List<T>> findAll(Predicate predicate){
        return Optional.ofNullable(getR().findAll(predicate));
    }

    default Optional<List<T>> findAll(Predicate predicate, Sort sort){
        return Optional.ofNullable(getR().findAll(predicate,sort));
    }

    default Optional<List<T>> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers){
        return Optional.ofNullable(getR().findAll(predicate,orderSpecifiers));
    }

    default Optional<List<T>> findAll(OrderSpecifier<?>... orderSpecifiers){
        return Optional.ofNullable(getR().findAll(orderSpecifiers));
    }
    */
/***********************JpaRepository********************************//*

    default Optional<List<T>> findAll(){
        return Optional.ofNullable(getR().findAll());
    }

    default Optional<List<T>> findAll(Sort var1){
        return Optional.ofNullable(getR().findAll(var1));
    }

    default Optional<List<T>> findAllById(Iterable<ID> var1){
        return Optional.ofNullable(getR().findAllById(var1));
    }
    default Optional<T> findById(ID var1){
        return getR().findById(var1);
    }
    default void flush(){
        getR().flush();
    }

    default boolean existsById(ID var1){
        return getR().existsById(var1);
    }

    default long count(){
        return getR().count();
    }

    default T getById(ID var1){
        return getR().getById(var1);
    }

    default <S extends T> Optional<List<S>> findAll(Example<S> var1){
        return Optional.ofNullable(getR().findAll(var1));
    }

    default <S extends T> Optional<List<S>> findAll(Example<S> var1, Sort var2){
        return Optional.ofNullable(getR().findAll(var1,var2));
    }

    */
/************************PagingAndSortingRepository*********************************//*

    default Optional<Page<T>> findAll(Pageable var1){
        return Optional.ofNullable(getR().findAll(var1));
    }
    */
/*******************QueryByExampleExecutor****************************//*

    default <S extends T> Optional<S> findOne(Example<S> var1){
        return getR().findOne(var1);
    }

    default <S extends T> Optional<Page<S>> findAll(Example<S> var1, Pageable var2){
        return Optional.ofNullable(getR().findAll(var1,var2));
    }

    default <S extends T> long count(Example<S> var1){
        return getR().count(var1);
    }

    default <S extends T> boolean exists(Example<S> var1){
        return getR().exists(var1);
    }

    */
/***********************QuerydslPredicateExecutor**************************//*

    default Optional<T> findOne(Predicate var1){
        return getR().findOne(var1);
    }

//    default Iterable<T> findAll(OrderSpecifier<?>... var1){
//        return getR().findAll(var1);
//    }

    default Optional<Page<T>> findAll(Predicate var1, Pageable var2){
        return Optional.ofNullable(getR().findAll(var1,var2));
    }

    default long count(Predicate var1){
        return getR().count(var1);
    }

    default boolean exists(Predicate var1){
        return getR().exists(var1);
    }
}
*/
