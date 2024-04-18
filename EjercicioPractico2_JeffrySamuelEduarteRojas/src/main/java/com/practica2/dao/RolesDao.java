package com.practica2.dao;

import com.practica2.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDao extends JpaRepository <Rol,Long> {
    
}
