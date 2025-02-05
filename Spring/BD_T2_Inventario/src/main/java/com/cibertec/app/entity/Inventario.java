package com.cibertec.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nro_inventario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroInventario;
	
	@Column(name="fecha")
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name="id_prod")
	private Producto idProd;
	
	@Column(name="costo_ingreso")
	private BigDecimal costoIngreso;
	


	public Integer getNroInventario() {
		return nroInventario;
	}



	public void setNroInventario(Integer nroInventario) {
		this.nroInventario = nroInventario;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Producto getIdProd() {
		return idProd;
	}



	public void setIdProd(Producto idProd) {
		this.idProd = idProd;
	}



	public BigDecimal getCostoIngreso() {
		return costoIngreso;
	}



	public void setCostoIngreso(BigDecimal costoIngreso) {
		this.costoIngreso = costoIngreso;
	}



	public Inventario() {}
}
