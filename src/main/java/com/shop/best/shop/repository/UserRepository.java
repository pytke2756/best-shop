package com.shop.best.shop.repository;

import com.shop.best.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query("update User u " +
            "set " +
            "u.firstName = :firstName, " +
            "u.lastName = :lastName," +
            " u.registrationDate = :registrationDate," +
            " u.street = :street " +
            "where u.id = :id")
    int updateUserData(
            @Param(value = "id") Integer id,
            @Param(value = "firstName") String firstName,
            @Param(value = "lastName") String lastName,
            @Param(value = "registrationDate") LocalDate registrationDate,
            @Param(value = "street") String street
    );
}
