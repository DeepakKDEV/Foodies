package com.example.Foodie.s.Favorite.Repository;

import com.example.Foodie.s.Favorite.Model.Admin;
import com.example.Foodie.s.Favorite.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {

    User findFirstByEmail(String newEmail);

}
