package com.example.Foodie.s.Favorite.Controller;


import com.example.Foodie.s.Favorite.Model.Order;
import com.example.Foodie.s.Favorite.Model.SignINputDto.SingInputDTO;
import com.example.Foodie.s.Favorite.Model.User;
import com.example.Foodie.s.Favorite.Service.OrderService;
import com.example.Foodie.s.Favorite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

           @Autowired
          UserService  userService;
           @Autowired
            OrderService     orderService;

           @PostMapping("/user/Up")
           public String  UserSigNUp(@RequestBody User user){
               return userService.UserSigNUp(user);
           }
           @PostMapping("user/Login")
           public String  UserLogin(@RequestBody SingInputDTO singInputDTO){
               return   userService.UserLogin(singInputDTO);
           }

            @DeleteMapping("user/signOut")
            public String userSignOut(@RequestParam String email, @RequestParam String tokenVal) {
               return userService.userSignOut(email, tokenVal);
           }

            @PostMapping("order/user")
            public String   orderByUser(@RequestBody Order order, @PathVariable String  email, @PathVariable String  tokenVal){
                        return  orderService.orderByUser(order,email, tokenVal);
            }

            @GetMapping("By/user/seen/Order")
            public String  getOrderByUser( @RequestParam String  email, @RequestParam String  TokenVal){
                             return  orderService.getOrderByUser( email, TokenVal);
            }

            @GetMapping("user/order/by/id/{id}")
            public String  getOrderById(@PathVariable Integer  id, @RequestParam String  email, @RequestParam String  tokenVal){
               return orderService. getOrderById(id, email, tokenVal);
            }






}
