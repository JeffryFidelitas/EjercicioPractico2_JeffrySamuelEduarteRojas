package com.practica2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name="usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotEmpty
    @Column(name="username")
    private String username;
    
    @NotEmpty
    @Column(name="password")
    private String password;
    
    private boolean enabled;
    
    @OneToMany
    @JoinColumn(name="usuario_id")
    private List<Rol> roles;
}
