package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class Documento implements IDocumento {
    private Integer id;
    private String titulo;
    private String dataCriacao;
    private String conteudoSensivel;

    public Documento(Integer id, String titulo, String dataCriacao, String conteudoSensivel) {
        this.id = id;
        this.titulo = titulo;
        this.dataCriacao = dataCriacao;
        this.conteudoSensivel = conteudoSensivel;
        System.out.println("Documento Real (ID: " + id + ") carregado do repositório.");
    }

    public Documento(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterMetadados() {
        return Arrays.asList(titulo, dataCriacao);
    }

    @Override
    public String obterConteudoCompleto(Usuario usuario) {
        return conteudoSensivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getConteudoSensivel() {
        return conteudoSensivel;
    }

    public void setConteudoSensivel(String conteudoSensivel) {
        this.conteudoSensivel = conteudoSensivel;
    }
}
