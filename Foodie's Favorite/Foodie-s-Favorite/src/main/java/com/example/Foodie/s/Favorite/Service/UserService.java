package com.example.Foodie.s.Favorite.Service;


import com.example.Foodie.s.Favorite.Model.AuthenticationTOkenDTo.Authentication;
import com.example.Foodie.s.Favorite.Model.SignINputDto.SingInputDTO;
import com.example.Foodie.s.Favorite.Model.User;
import com.example.Foodie.s.Favorite.Repository.AuthenticationTokenRepo;
import com.example.Foodie.s.Favorite.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

       @Autowired
    IUserRepo  iUserRepo;

       @Autowired
       AuthenticationTokenService authenticationTokenService;

       @Autowired
    AuthenticationTokenRepo  authenticationTokenRepo;

     public  String  UserSigNUp(User user) {

     String newEmail=user.getEmail();
     User existingUser=iUserRepo.findFirstByEmail(newEmail);

     if(existingUser!=null){
         return  "email Already exists  in database";
      }

     String  password=user.getPassword();
     try{
       String  encryptedPassword=PasswordEncoder.encode(password);
         user.setPassword(encryptedPassword);
          iUserRepo.save(user);
          return "user Added";
     }
     catch (NoSuchAlgorithmException e) {

         throw new RuntimeException(e);
       }

     }

    public String UserLogin(SingInputDTO singInputDTO) {
            String  newEmail=singInputDTO.getEmail();
            User  existingAdmin=iUserRepo.findFirstByEmail(newEmail);
            if(existingAdmin==null){
                return "sign up first than  SignIn";
            }
            String  password=singInputDTO.getPassword();
            try {
                String  encryptedPassword=PasswordEncoder.encode(password);
                if(existingAdmin.getPassword().equals(encryptedPassword)){
                    Authentication  token= new Authentication(existingAdmin);
                        authenticationTokenRepo.save(token);
                         return "this is  your  session id   "  + token.getTokenValue();

                } else {
                    return "Invalid Credentials!!!";
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
    }

    public String userSignOut(String email, String tokenVal) {
     if(authenticationTokenService.authenticated(email, tokenVal)){
         authenticationTokenService.delete(tokenVal);
         return "Sign Out successful!!";
       }else{
         return "un Authorization ";
      }

    }
}

