package com.springboot.advaced_jpa.data.repository;

import com.springboot.advaced_jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByName(String name, Pageable pageable);

    @Query("SELECT p FROM Product AS p WHERE p.name = ?1")
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    @Query("SELECT p.name, p.price, p.stock FROM Product p WHERE p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);
// find...by
//    Optional<Product> findByNumber(Long number);
//    List<Product> findAllByName(String name);
//    Product queryByNumber(Long number);
//
//    // exists...by
//    boolean existsByNumber(Long number);
//
//    // count...by
//    long countByName(String name);
//
//    // delete...by, remove...by
//    void deleteByNumber(Long number);
//    long removeByName(String name);
//
//    // First<Number>..., ...Top<Number>...
//    List<Product> findByFirst5ByName(String name);
//    List<Product> findByTop10ByName(String name);
//
//    // IS 조건자
//    // findByNumber 메서드와 동일하게 동작
//    Product findByNumberIs(Long number);
//    Product findByNumberEquals(Long number);
//
//    //(IS)NOT 조건자
//    Product findByNumberIsNot(Long number);
//    Product findByNumberNot(Long number);
//
//    // (IS)Null, (IS)NotNull
//    List<Product> findByUpdateAtNull();
//    List<Product> findByUpdateAtIsNull();
//    List<Product> findByUpdateAtNotNull();
//    List<Product> findByUpdateAtIsNotNull();
//
//    // (IS)False,(IS)True Boolean 체크
////    Product findByisActiveTrue();
////    Product findByisActiveIsTrue();
////    Product findByisActiveFalse();
////    Product findByisActiveIsFalse();
//
//    // And, Or
//    Product findByNumberAndName(Long Number, String name);
//    Product findByNumberOrName(Long number, String name);
//
//    // GreaterThan, LessThan, BetWeen
//    List<Product> findByPriceIsGreaterThan(Integer price);
//    List<Product> findByPriceGreaterThan(Integer Price);
//    List<Product> findByPriceGreaterThanEqual(Integer Price);
//    List<Product> findByPriceIsLessThanEqual(Integer Price);
//    List<Product> findByPriceLessThan(Integer Price);
//    List<Product> findByPriceLessThanEqual(Integer Price);
//    List<Product> findByPriceIsBetween(Integer lowPrice, Integer highPrice);
//    List<Product> findByPriceBetween(Integer lowPrice, Integer highPrice);
//
//    // (Is)StartingWith(==StartsWith),(Is)EndingWith(==EndsWith)
//    // (Is)Containing(==Contains),(Is)Like
//    List<Product> findByNameLike(String name);
//    List<Product> findByNameIsLike(String name);
//    List<Product> findByNameContains(String name);
//    List<Product> findByNameContaining(String name);
//    List<Product> findByNameIsContaining(String name);
//
//    List<Product> findByNameStartsWith(String name);
//    List<Product> findByNameStartingWith(String name);
//    List<Product> findByNameIsStartingWith(String name);
//
//    List<Product> findByNameEndsWith(String name);
//    List<Product> findByNameEndingWith(String name);
//    List<Product> findByNameIsEndingWith(String name);
//
//    // Asc: 오름차순, Desc: 내림차순
//    List<Product> findByNameOrderByNumberAsc(String name);
//    List<Product> findByNameOrderByNumberDesc(String name);
//
//    // And를 붙이지 않음
//    List<Product> findByNameOrderByPriceAscStockDesc(String name);

    // 매개변수
    List<Product> findByName(String name, Sort sort);
}

