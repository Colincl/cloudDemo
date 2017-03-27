package com.cloud.dao;


import com.cloud.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * Created by ChenLei on 2016/7/22.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    //1
    List<Person> findByAddress(String name);
    //2
    Person findByNameAndAddress(String name, String address);
    //3
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);
    //4
    Person withNameAndAddressNamedQuery(String name, String address);
    //5
//    @Query(value = "select * from person where age = ?1",nativeQuery = true)//原生sql查询
//    List<Person> findByAge(String age, Pageable pageable);
}
