package com.practica2.service.impl;

import com.practica2.dao.HotelDao;
import com.practica2.domain.Hotel;
import com.practica2.service.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelDao hotelDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Hotel> getHoteles() {
        var lista=hotelDao.findAll();  
        return lista;
    }
        
}
