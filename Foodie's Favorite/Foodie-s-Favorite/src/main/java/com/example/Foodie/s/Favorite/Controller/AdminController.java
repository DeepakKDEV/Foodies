package com.example.Foodie.s.Favorite.Controller;
import com.example.Foodie.s.Favorite.Model.Admin;
import com.example.Foodie.s.Favorite.Model.SignINputDto.SingInputDTO;
import com.example.Foodie.s.Favorite.Service.AdminService;
import com.example.Foodie.s.Favorite.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

           @Autowired
           AdminService  adminService;

           @PostMapping("Admin/use")
         public String   postUser(@RequestBody Admin   admin){
                return  adminService .postUser(admin);
           }

           @PostMapping("Admin/Login")
          public String  adminLogin(@RequestBody SingInputDTO  singInputDTO){
               return  adminService.adminLogin(singInputDTO);
           }

          @DeleteMapping("Admin/Out")
           public String AdminOut(@RequestParam String email, @RequestParam String tokenVal) {
               return adminService.AdminOut(email, tokenVal);
        }






}
