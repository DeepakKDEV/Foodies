package com.example.Foodie.s.Favorite.Repository;

import com.example.Foodie.s.Favorite.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepo  extends JpaRepository<Order, Integer> {


}
