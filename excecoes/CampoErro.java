package br.com.lucasramon.lrprojetos.api.excecoes;

public class CampoErro {

    private String campo;

    private String mensagem;

    public CampoErro() {
    }

    public CampoErro(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    


    
}
