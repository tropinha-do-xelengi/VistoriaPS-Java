package br.com.fiap.VistoriaPS.controller;

import java.util.ArrayList; 

import br.com.fiap.VistoriaPS.model.entity.Cadastro;
import br.com.fiap.VistoriaPS.model.repository.CadastroRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/VistoriaPS/cadastro")
public class CadastroResource {

	@GET
	@Path("/cliente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		Cadastro resposta = CadastroRepository.findById(id);
		ResponseBuilder response = Response.ok();
		if (resposta == null) {
			response = Response.status(404);
		}
		response.entity(resposta);
		return response.build();
	}
	
	@GET
	@Path("/clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Cadastro> resposta = CadastroRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Cadastro cadastro) {
		Cadastro resposta = CadastroRepository.save(cadastro);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); 
		} else {
			response = Response.status(400); 
		}
		response.entity(resposta);
		return response.build();
	}
	
	@DELETE
	@Path("/deletar/{id}")
	public Response delete(@PathParam("id") Long id) {
		if (CadastroRepository.delete(id)) {
			ResponseBuilder response = Response.noContent(); 
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404); 
			return response.build();
		}
	}
	
	@PUT
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid Cadastro cadastro) {
		Cadastro resposta = CadastroRepository.update(cadastro);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null); 
		} else {
			response = Response.status(400); 
		}
		response.entity(resposta);
		return response.build();
	}
	
}

