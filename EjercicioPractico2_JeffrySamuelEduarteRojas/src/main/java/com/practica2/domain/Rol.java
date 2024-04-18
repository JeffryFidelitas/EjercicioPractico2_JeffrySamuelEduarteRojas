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
@IdClass(RolId.class)
@Table(name = "usuario_roles")
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Roles rol_id;
    
}