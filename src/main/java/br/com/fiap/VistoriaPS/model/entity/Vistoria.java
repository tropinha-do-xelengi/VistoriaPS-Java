package br.com.fiap.VistoriaPS.model.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class Vistoria {
	
	private Long id;
	@NotNull
	private String marca;
	@NotNull
	private String modelo;
	@NotNull
	@PositiveOrZero
	private Long numSerie;
	@NotNull
	@PastOrPresent
	private LocalDate dataCompra;
	
	public Vistoria() {
		
	}

	public Vistoria(Long id, @NotNull String marca, @NotNull String modelo, @NotNull @PositiveOrZero Long numSerie,
			@NotNull @PastOrPresent LocalDate dataCompra) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.numSerie = numSerie;
		this.dataCompra = dataCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(Long numSerie) {
		this.numSerie = numSerie;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	
	
	
	
	
	

}
