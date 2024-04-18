package com.practica2.service;

import org.springframework.security.core.userdetails.*;
import com.practica2.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    
    public Usuario getUsuarioByUsername(String username);
    
    public boolean UsuarioExistsByUsername(String username);
    
    public Usuario getUsuarioByUsernameAndPassword(String username, String password);
    
    public void save(Usuario usuario, boolean makeUserRol);
    
    public void delete(Usuario usuario);
}
