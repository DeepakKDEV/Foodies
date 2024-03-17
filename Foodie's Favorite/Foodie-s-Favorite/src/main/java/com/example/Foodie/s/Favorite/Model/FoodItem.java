package com.example.Foodie.s.Favorite.Model;

import com.example.Foodie.s.Favorite.Model.SignINputDto.TypeFood;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Integer id;
        @Column(nullable = false)
        @Min(value = 10, message = "Food price must be greater than 10 rupees")
        private  String  food_item;
        private String   description;
        private Double  food_Price;
        @Enumerated(value = EnumType.STRING)
        private TypeFood category;




}
