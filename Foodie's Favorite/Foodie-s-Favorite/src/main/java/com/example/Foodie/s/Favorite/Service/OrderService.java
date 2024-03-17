package com.example.Foodie.s.Favorite.Service;

import com.example.Foodie.s.Favorite.Model.Order;
import com.example.Foodie.s.Favorite.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

         @Autowired
       IOrderRepo   iOrderRepo;
         @Autowired
          AuthenticationTokenService authenticationTokenService;

    public String orderByUser(Order order, String email, String tokenVal) {
              if(authenticationTokenService.authenticated(email, tokenVal)){
                   iOrderRepo.save(order);
                   return "new  Order  save our System";
              }else{
                  return "you  are  not Authorized person";
              }
    }

    public String  getOrderByUser(String email, String tokenVal) {
        if(authenticationTokenService.authenticated(email, tokenVal)){
            return iOrderRepo.findAll().toString();
        }else{
            return "Not found  user are not authorized person";
        }

    }

    public String  getOrderById(Integer id, String email, String tokenVal) {
        if(authenticationTokenService.authenticated(email, tokenVal)){
            //  iOrderRepo.findById(id).toString();
             return   iOrderRepo.findById(id).toString();

        }
        return "empty order";
    }




}
