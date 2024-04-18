package com.practica2.dao;

import com.practica2.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository <Hotel,Long> {
    
}