package com.example.springHtml.Repository;

import com.example.springHtml.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<UserModel, Integer> {


    @Query("select u.password from UserModel u where u.email = :email")
    Object getPasswordByEmail(@Param("email") String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserModel u WHERE u.email = :email")
    boolean checkMailExistedorNot(@Param("email") String email);

    @Query("select u from UserModel u where u.email = :email")
    UserModel getByEmail(@Param("email") String email);
}
