package br.com.treinaweb.twprojetos.api.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.twprojetos.api.dto.CargoDto;
import br.com.treinaweb.twprojetos.entidades.Cargo;
import br.com.treinaweb.twprojetos.servicos.CargoServico;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/cargos")

public class CargoControleApi {
   @Autowired
   private CargoServico cargoServico;

   @GetMapping
  
   public List<Cargo> buscarTodos()
   {
    List<Cargo> cargos = cargoServico.buscarTodos();

    cargos.forEach(cargo-> {
      Long id = cargo.getId();
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
      cargo.add(selfLink,editarLink);
    });
    
    return cargos;
   }

  @GetMapping("/{id}")

  public Cargo buscaPorId(@PathVariable long id)
  {
   return this.cargoServico.buscarPorId(id);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Cargo cadastrar(@RequestBody @Valid CargoDto cargo)
  {
    return this.cargoServico.cadastrar(cargo);
  }

  @PutMapping("/{id}")
  public Cargo atualizar(@RequestBody @Valid CargoDto cargoDto, @PathVariable Long id)
  {
    return this.cargoServico.atualizar(cargoDto, id);
  }
     
  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public ResponseEntity<?> excluirPorId (@PathVariable Long id)
  {
    
    this.cargoServico.excluirPorId(id);

    return ResponseEntity.noContent().build();
  }
  
}
