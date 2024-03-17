package com.example.Foodie.s.Favorite.Model;

import com.example.Foodie.s.Favorite.Model.ModelEnums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Integer  id;
   //  @NotBlank
     private  String  name;
    // @NotBlank
     private  String  city;
    // @Email
     private  String email;
  //   @NotBlank
     private String  password;
     private String  phoneNumber;
     @Enumerated(value =EnumType.STRING)
     private Gender gender;


}
