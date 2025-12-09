package padroesestruturais.proxy;

import java.util.List;

public class DocumentoProxy implements IDocumento {
    private Documento documento;
    private Integer id;

    public DocumentoProxy(Integer id) {
        this.id = id;
        this.documento = null;
    }

    private void carregarDocumento() {
        if (this.documento == null) {
            this.documento = RepositorioDocumentos.getInstance().getDocumento(this.id);
        }
    }

    @Override
    public List<String> obterMetadados() {
        carregarDocumento();
        return this.documento.obterMetadados();
    }

    @Override
    public String obterConteudoCompleto(Usuario usuario) {
        if (!usuario.isAdministrador()) {
            throw new IllegalArgumentException("Usuário " + usuario.getNome() + " não autorizado a visualizar o conteúdo completo.");
        }

        carregarDocumento();
        return this.documento.obterConteudoCompleto(usuario);
    }
}
