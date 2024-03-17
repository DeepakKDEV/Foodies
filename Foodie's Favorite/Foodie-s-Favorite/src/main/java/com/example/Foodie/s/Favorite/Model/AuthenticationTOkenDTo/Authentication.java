package com.example.Foodie.s.Favorite.Model.AuthenticationTOkenDTo;

import com.example.Foodie.s.Favorite.Model.Admin;
import com.example.Foodie.s.Favorite.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authentication {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        private Integer token_Id;
        private String tokenValue;
        private LocalDateTime tokenCreationTime;

    public Authentication(User user){
        this.user=user;
        this.tokenCreationTime = LocalDateTime.now();
        this.tokenValue = UUID.randomUUID().toString();
    }

    @OneToOne
    @JoinColumn(name = "fk_UserId_")
    User user;


    public Authentication(Admin existadmin) {
        this.admin= existadmin;
        this.tokenCreationTime = LocalDateTime.now();
        this.tokenValue = UUID.randomUUID().toString();
    }
    @OneToOne
    @JoinColumn(name = "fk_admin_")
    Admin admin;
}
