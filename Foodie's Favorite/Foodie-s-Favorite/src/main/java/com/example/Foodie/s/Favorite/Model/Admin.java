package com.example.Foodie.s.Favorite.Model;

import com.example.Foodie.s.Favorite.Model.ModelEnums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @NotBlank
    private String username;
    private String password;
    @Enumerated(value =EnumType.STRING)
    private Gender   gender;
    @Email
    private String email;
    private boolean isAdmin;


}
