package com.example.Foodie.s.Favorite.Repository;

import com.example.Foodie.s.Favorite.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepo  extends JpaRepository<User, Integer> {

       User findFirstByEmail(String newEmail);


}
