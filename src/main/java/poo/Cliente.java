package poo;

abstract class Cliente {
    private String nome;
    private String email;
    private String id;
    private String telefone;

    public Cliente(String nome, String email) {

        this.nome = nome;
        this.email = email;
    }

    public void setNome() {
        this.nome = nome;
    }

    public void setPreco() {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId() {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTelefone() {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public abstract String getIdentificadorUni();
}
