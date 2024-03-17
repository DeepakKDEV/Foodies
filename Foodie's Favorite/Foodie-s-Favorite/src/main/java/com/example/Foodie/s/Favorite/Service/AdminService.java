package com.example.Foodie.s.Favorite.Service;

import com.example.Foodie.s.Favorite.Model.Admin;
import com.example.Foodie.s.Favorite.Model.AuthenticationTOkenDTo.Authentication;
import com.example.Foodie.s.Favorite.Model.SignINputDto.SingInputDTO;
import com.example.Foodie.s.Favorite.Model.User;
import com.example.Foodie.s.Favorite.Repository.AuthenticationTokenRepo;
import com.example.Foodie.s.Favorite.Repository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {

         @Autowired
        IAdminRepo   iAdminRepo;

         @Autowired
    AuthenticationTokenRepo authenticationTokenRepo;

        @Autowired
        AuthenticationTokenService   authenticationTokenService;


    public String postUser(Admin admin) {

           String  newEmail =admin.getEmail();
           User existingAdmin=iAdminRepo.findFirstByEmail(newEmail);
           if(existingAdmin!=null){
               return  "Admin Email already use  ";
           }
           String  password=admin.getPassword();

           try{
               String  encryptedPassword=PasswordEncoder.encode(password);
               admin.setPassword(encryptedPassword);
               iAdminRepo.save(admin);
               return "Admin added";
           } catch (NoSuchAlgorithmException e) {
               throw new RuntimeException(e);
           }

    }

    public String adminLogin(SingInputDTO singInputDTO) {
        String  newEmail=singInputDTO.getEmail();
        User  existingAdmin=iAdminRepo.findFirstByEmail(newEmail);
        if(existingAdmin==null){
            return "sign up first than  SignIn";
        }
        String  password=singInputDTO.getPassword();
        try {
            String  encryptedPassword=PasswordEncoder.encode(password);
            if(existingAdmin.getPassword().equals(encryptedPassword)){
                Authentication token= new Authentication(existingAdmin);
                authenticationTokenRepo.save(token);
                return "this is  your  session id" + token.getTokenValue();

            } else {
                return "Invalid Credentials!!!";
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }

    public String AdminOut(String email, String tokenVal) {
        if(authenticationTokenService.authenticatedAdmin(email, tokenVal)){
            authenticationTokenService.delete(tokenVal);
            return "Sign Out successful!!";
        }else{
            return "un Authorization ";
        }
    }
}
