package br.com.treinaweb.twprojetos.api.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.treinaweb.twprojetos.servicos.CargoServico;
//Identificador de controller
@Controller
//Identificador da rota em que esta controller responderá
@RequestMapping("/api/v1/cargos")

public class CargoControleApi {
   //Injeção de dependências
   @Autowired
   private CargoServico cargoServico;
   //Indetificador do verbo http do metodo buscar todos 
   @GetMapping
   //Identificador do tipo de resposta para api "serialização"
   @ResponseBody
   public List<br.com.treinaweb.twprojetos.entidades.Cargo> buscarTodos()
   {
    return cargoServico.buscarTodos();
   }

}
