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

@Controller
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/")
    public String Inventario(Model model) {
        model.addAttribute("inventarios",inventarioService.getAllInventario());
        return "inventario/index";
    }
    
    @GetMapping("/inventario/new")
    public String createInventarioForm(Model model) {
    	Inventario inventario = new Inventario();
    	
    	model.addAttribute("inventario", inventario);
    	
    	return "inventario/create";
    }
    
    @PostMapping("/inventario")
    public String saveInventario(@ModelAttribute("inventario") Inventario inventario) {
    	inventarioService.saveInventario(inventario);
    	return "redirect:/inventario";
    }
    
    @GetMapping("/inventario/edit/{id}")
    public String editInventario(@PathVariable Integer id,Model model) {
        Inventario inv = inventarioService.findInventarioByNro(id);
        model.addAttribute("inventario",inv);
        return "inventario/edit";
    }
    @PostMapping("/Inventario/{id}")
    public String updateCliente(@PathVariable Integer id,@ModelAttribute("inventario") Inventario inventario, Model model) {

        Inventario existentInv = inventarioService.findInventarioByNro(id);
        //cargarlo
        existentInv.setNroInventario(id);
        existentInv.setFecha(inventario.getFecha());
        existentInv.setCostoIngreso(inventario.getCostoIngreso());
        existentInv.setIdProd(inventario.getIdProd());
        //guardar el estudiante actualizado
        inventarioService.updateInventario(existentInv);
        return "redirect:/";
    }
}