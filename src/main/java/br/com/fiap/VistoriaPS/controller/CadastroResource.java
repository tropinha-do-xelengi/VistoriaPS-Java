package br.com.fiap.VistoriaPS.controller;

import java.io.IOException;
import java.util.ArrayList; 

import br.com.fiap.VistoriaPS.model.entity.Cadastro;
import br.com.fiap.VistoriaPS.model.repository.CadastroRepository;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.Provider;

@Provider
@Path("/VistoriaPS/cadastro")
public class CadastroResource implements ContainerResponseFilter {

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
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext
			ResponseContext) 
					throws IOException{
		ResponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		ResponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		ResponseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		ResponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		
	}
	
}

