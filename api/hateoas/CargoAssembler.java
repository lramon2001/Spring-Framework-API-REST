package br.com.treinaweb.twprojetos.api.hateoas;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import br.com.treinaweb.twprojetos.api.controles.CargoControleApi;
import br.com.treinaweb.twprojetos.entidades.Cargo;

@Component
public class CargoAssembler implements SimpleRepresentationModelAssembler<Cargo>{

    @Override
    public void addLinks(EntityModel<Cargo> resource) {
        
            Long id = resource.getContent().getId();
            Link selfLink = WebMvcLinkBuilder.
            linkTo(WebMvcLinkBuilder.
            methodOn(CargoControleApi.class).
            buscaPorId(id)).
            withSelfRel().withType("GET");
          
            Link editarLink = WebMvcLinkBuilder.
            linkTo(WebMvcLinkBuilder.
            methodOn(CargoControleApi.class).
            atualizar(null, id)).
            withSelfRel().
            withType("PUT");
            
            Link excluirLink = WebMvcLinkBuilder.
            linkTo(WebMvcLinkBuilder.methodOn(CargoControleApi.class).
            excluirPorId(id)).withSelfRel().withType("NO CONTENT");
            resource.add(selfLink,editarLink);
          
        
    }

    @Override
    public void addLinks(CollectionModel resources)
    {
        Link cadastrarLink =  WebMvcLinkBuilder.
        linkTo(WebMvcLinkBuilder.
        methodOn(CargoControleApi.class).
        cadastrar(null)).
        withSelfRel().
        withType("POST");

        resources.add(cadastrarLink);
        Link selfLink = WebMvcLinkBuilder.
        linkTo(WebMvcLinkBuilder.
        methodOn(CargoControleApi.class).
        buscarTodos()).
        withSelfRel().
        withType("GET");
        resources.add(selfLink);
    }
    
}
