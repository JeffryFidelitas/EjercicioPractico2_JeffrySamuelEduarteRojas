package com.practica2.service.impl;

import com.practica2.service.UsuarioService;
import com.practica2.dao.UsuarioDao;
import com.practica2.dao.RolDao;
import com.practica2.domain.Usuario;
import com.practica2.domain.Rol;
import com.practica2.domain.Roles;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    @Autowired
    private RolDao rolDao;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        if (usuario == null) throw new UsernameNotFoundException(username);
        
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(Long.toString(rol.getRol_id().getId())));
        }
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuario;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean UsuarioExistsByUsername(String username) {
        return usuarioDao.existsByUsername(username);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsernameAndPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }
    
    @Override
    @Transactional
    public void save(Usuario usuario, boolean makeUserRole) {
        usuario=usuarioDao.save(usuario);
        if (makeUserRole) {
            Roles rolNombre = new Roles();
            rolNombre.setNombre("CLIENTE");
            rolNombre.setId((long) 2);
            Rol rol = new Rol();
            rol.setRol_id(rolNombre);
            rol.setUsuario_id(usuario);
            rolDao.save(rol);
        }
    }
    
    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
