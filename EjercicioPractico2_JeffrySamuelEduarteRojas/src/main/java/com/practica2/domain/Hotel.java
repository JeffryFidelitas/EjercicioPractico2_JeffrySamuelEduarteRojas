package com.practica2.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.IdClass;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "hoteles")
public class Hotel implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="ubicacion")
    private String ubicacion;
    
    @Column(name="descripcion")
    private String descripcion;
}
