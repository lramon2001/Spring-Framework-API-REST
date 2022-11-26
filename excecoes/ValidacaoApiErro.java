package br.com.lucasramon.lrprojetos.api.excecoes;

import java.util.List;

public class ValicaoApiErro extends ApiErro{


    private List<CampoErro> erros;

    public ValicaoApiErro() {
    }

    public ValicaoApiErro(List<CampoErro> erros) {
        this.erros = erros;
    }

    public List<CampoErro> getErros() {
        return erros;
    }

    public void setErros(List<CampoErro> erros) {
        this.erros = erros;
    }

    
    
    
}
