package br.com.lucasramon.lrprojetos.api.excecoes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApiErro {

    private int erro;
    
    private String status;

    private LocalDateTime timestamp;

    private String mensagem;

    public ApiErro() {
    }

    public ApiErro(int erro, String status, LocalDateTime timestamp, String mensagem) {
        this.erro = erro;
        this.status = status;
        this.timestamp = timestamp;
        this.mensagem = mensagem;
    }

    public int getErro() {
        return erro;
    }

    public void setErro(int erro) {
        this.erro = erro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    

    
}
