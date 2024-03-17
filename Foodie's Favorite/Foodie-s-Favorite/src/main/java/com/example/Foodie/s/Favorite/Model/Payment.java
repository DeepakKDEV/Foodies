package com.example.Foodie.s.Favorite.Model;

import com.example.Foodie.s.Favorite.Model.SignINputDto.PaymentMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int paymentId;
     private int customerId;
     private double amount;
     private PaymentMode mode;
     private LocalDate paymentDate;
}
