package br.com.treinaweb.twprojetos.api.mapeadores;

import org.springframework.stereotype.Component;

import br.com.treinaweb.twprojetos.api.dto.CargoDto;
import br.com.treinaweb.twprojetos.entidades.Cargo;

@Component
public class CargoMapeador {
    
    public Cargo converterParaEntidade(CargoDto cargoDto)
    {
        Cargo cargo = new Cargo();
        cargo.setNome(cargoDto.getNome());
        return cargo;
    }
}
