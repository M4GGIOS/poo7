package poo;

class ClientePJ extends Cliente {

    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;

    public ClientePJ(String nome, String email, String cnpj) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    public void setCnpj() {
        this.cnpj = cnpj;
    }

    public void setraRazaoSocial() {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setInscricaoEstadual() {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getIdentificadorUni() {
        return cnpj;
    }

}
