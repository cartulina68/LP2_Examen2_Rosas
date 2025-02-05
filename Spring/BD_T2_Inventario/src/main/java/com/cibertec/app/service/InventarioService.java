package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.entity.Inventario;

public interface InventarioService {
	
	public Inventario saveInventario(Inventario userEntity);

	public List<Inventario> getAllInventario();
	
	public Inventario updateInventario(Inventario userEntity);
	
	public Inventario findInventarioByNro(Integer nroInventario);
}
