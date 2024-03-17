package com.example.Foodie.s.Favorite.Repository;

import com.example.Foodie.s.Favorite.Model.AuthenticationTOkenDTo.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationTokenRepo extends JpaRepository<Authentication, Integer> {

    Authentication findFirstByTokenValue(String tokenVal);

}
