package br.com.treinaweb.twprojetos.api.controles;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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
import br.com.treinaweb.twprojetos.api.hateoas.CargoAssembler;
import br.com.treinaweb.twprojetos.entidades.Cargo;
import br.com.treinaweb.twprojetos.servicos.CargoServico;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/cargos")

public class CargoControleApi {
   @Autowired
   private CargoServico cargoServico;
   @Autowired
   private CargoAssembler cargoAssembler;
   @Autowired
   private PagedResourcesAssembler pagedResourcesAssembler;

   
   @GetMapping
  
   public CollectionModel<EntityModel<Cargo>> buscarTodos(Pageable paginacao)
   {
    Page<Cargo> cargos = cargoServico.buscarTodos(paginacao);
    return pagedResourcesAssembler.toModel(cargos,cargoAssembler);
   }

  @GetMapping("/{id}")

  public EntityModel<Cargo> buscaPorId(@PathVariable long id)
  {
    Cargo cargo = this.cargoServico.buscarPorId(id);
   return this.cargoAssembler.toModel(cargo);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public EntityModel<Cargo> cadastrar(@RequestBody @Valid CargoDto cargo)
  {

    return cargoAssembler.toModel(this.cargoServico.cadastrar(cargo));
  }

  @PutMapping("/{id}")
  public EntityModel<Cargo> atualizar(@RequestBody @Valid CargoDto cargoDto, @PathVariable Long id)
  {
    return cargoAssembler.toModel(this.cargoServico.atualizar(cargoDto, id));
  }
     
  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public ResponseEntity<?> excluirPorId (@PathVariable Long id)
  {
    
    this.cargoServico.excluirPorId(id);

    return ResponseEntity.noContent().build();
  }
  
}
