package com.example.Foodie.s.Favorite.Model;

import com.example.Foodie.s.Favorite.Model.SignINputDto.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FoodiesOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer OrderId;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private LocalDateTime localDateTime;


//    @ManyToMany
//    List<FoodItem> foodItem;

    @ManyToOne()
    @JoinColumn(name ="FK_UserId")
    User user;

    @ManyToOne()
    @JoinColumn(name ="FK_food_item_id")
    FoodItem foodItem;




}
