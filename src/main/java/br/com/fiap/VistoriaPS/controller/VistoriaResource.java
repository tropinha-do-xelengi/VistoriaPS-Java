package br.com.fiap.VistoriaPS.controller;

import java.util.ArrayList; 

import br.com.fiap.VistoriaPS.model.entity.Vistoria;
import br.com.fiap.VistoriaPS.model.repository.VistoriaRepository;
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

@Path("/VistoriaPS/vistoria")
public class VistoriaResource {

	@GET
	@Path("/encontrar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		Vistoria resposta = VistoriaRepository.findById(id);
		ResponseBuilder response = Response.ok();
		if (resposta == null) {
			response = Response.status(404);
		}
		response.entity(resposta);
		return response.build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Vistoria> resposta = VistoriaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Vistoria vistoria) {
		Vistoria resposta = VistoriaRepository.save(vistoria);
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
		if (VistoriaRepository.delete(id)) {
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
	public Response update(@Valid Vistoria vistoria) {
		Vistoria resposta = VistoriaRepository.update(vistoria);
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
