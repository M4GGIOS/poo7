package poo;

import java.time.LocalDate;

class ClientePF extends Cliente {

    private String cpf;
    private LocalDate DTN;

    public ClientePF(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    public void setCpf() {
        this.cpf = cpf;
    }

    public void setDTN() {
        this.DTN = DTN;
    }

    public String getCpf() {
        return this.cpf;
    }

    public LocalDate getDNT() {
        return this.DTN;
    }

    public String getIdentificadorUni() {
        return cpf;
    }
}
