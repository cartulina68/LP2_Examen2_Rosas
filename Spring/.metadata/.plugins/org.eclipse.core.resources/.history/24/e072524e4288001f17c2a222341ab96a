package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.app.entity.Inventario;
import com.cibertec.app.service.InventarioService;
import com.cibertec.app.service.ProductoService;

@Controller
public class InventarioController {

	@Autowired
	private InventarioService inventarioService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/inventario")
	public String listInventario(Model model) {
		model.addAttribute("inventarios", inventarioService.getAllInventario());
		model.addAttribute("productos", productoService.getAllProducto());
		
		return "inventario/index";
	}
	
	@GetMapping("/inventario/new")
	public String createInventario(Model model) {
		Inventario inventario = new Inventario();
		model.addAttribute("inventario", inventario);
		model.addAttribute("producto", productoService.getAllProducto());
		
		return "inventario/create";
	}
	
	@PostMapping("inventario")
	public String saveInventario(@ModelAttribute("inventario") Inventario inventario) {
		inventarioService.saveInventario(inventario);
		return "redirect:/inventario";
	}
	
	@GetMapping("/inventario/new")
	public String editInventario(@PathVariable Integer id, Model model) {
		Inventario st = inventarioService.findInventarioByNro(id);
		model.addAttribute("inventario", st);
		model.addAttribute("producto", productoService.getAllProducto());
		
		return "inventario/edit";
	}
	
	@PostMapping("/inventario/{id}")
	public String updateInventario(@PathVariable Integer id, @ModelAttribute("inventario") Inventario inventario, Model model) {
		Inventario existente = inventarioService.findInventarioByNro(id);
		
		existente.setNroInventario(id);
		existente.setFecha(inventario.getFecha());
		existente.setIdProd(inventario.getIdProd());
		existente.setCostoIngreso(inventario.getCostoIngreso());
		
		inventarioService.updateInventario(existente);
		return "redirect:/inventario";
	}
}
