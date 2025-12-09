package padroesestruturais.proxy;

import java.util.List;

public interface IDocumento {
    List<String> obterMetadados();
    String obterConteudoCompleto(Usuario usuario);
}

