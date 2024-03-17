package com.example.Foodie.s.Favorite.Service;

import com.example.Foodie.s.Favorite.Model.AuthenticationTOkenDTo.Authentication;
import com.example.Foodie.s.Favorite.Repository.AuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {

        @Autowired
      AuthenticationTokenRepo  authenticationTokenRepo;

    public boolean authenticated(String email, String tokenVal) {
        Authentication token = authenticationTokenRepo.findFirstByTokenValue(tokenVal);
          if(token!=null)
        {
            return token.getUser().getEmail().equals(email);
        }else
        {
            return false;
        }
    }

    public void delete(String tokenVal) {
        Authentication token =  authenticationTokenRepo.findFirstByTokenValue(tokenVal);
        authenticationTokenRepo.delete(token);
    }

//    Admin  Authorization



    public boolean authenticatedAdmin(String email, String tokenVal) {
        Authentication token = authenticationTokenRepo.findFirstByTokenValue(tokenVal);
        if(token!=null)
        {
           return token.getAdmin().getEmail().equals(email);
        }else
        {
            return false;
        }
    }




}
