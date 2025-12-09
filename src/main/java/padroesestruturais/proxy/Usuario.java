package padroesestruturais.proxy;

public class Usuario {
    private boolean administrador;
    private String nome;

    public Usuario(String nome, boolean administrador) {
        this.nome = nome;
        this.administrador = administrador;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public String getNome() {
        return nome;
    }
}

