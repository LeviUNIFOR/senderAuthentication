package Entidades;

public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected Integer telefone = null;
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getTelefone() {
        return telefone;
    }

    public String getTelefoneString() {
        return telefone.toString();
    }

    public abstract void setTelefone(Integer telefone);
    
}
