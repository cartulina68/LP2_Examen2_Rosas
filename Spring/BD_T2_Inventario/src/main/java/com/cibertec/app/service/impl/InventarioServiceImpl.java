package com.cibertec.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.entity.Inventario;
import com.cibertec.app.repository.InventarioRepository;
import com.cibertec.app.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService{
	
	@Autowired
	InventarioRepository inventarioRepository;

	@Override
	public Inventario saveInventario(Inventario userEntity) {
		// TODO Auto-generated method stub
		return inventarioRepository.save(userEntity);
	}

	@Override
	public List<Inventario> getAllInventario() {
		// TODO Auto-generated method stub
		return inventarioRepository.findAll();
	}

	@Override
	public Inventario updateInventario(Inventario userEntity) {
		// TODO Auto-generated method stub
		return inventarioRepository.save(userEntity);
	}

	@Override
	public Inventario findInventarioByNro(Integer nroInventario) {
		// TODO Auto-generated method stub
		return inventarioRepository.findById(nroInventario).get();
	}

}
