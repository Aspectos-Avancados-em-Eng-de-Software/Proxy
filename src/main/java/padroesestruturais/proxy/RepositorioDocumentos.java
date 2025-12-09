package padroesestruturais.proxy;

import java.util.Arrays;
import java.util.List;

public class RepositorioDocumentos {

    private static RepositorioDocumentos instance = new RepositorioDocumentos();

    private RepositorioDocumentos() {
    }

    public static RepositorioDocumentos getInstance() {
        return instance;
    }

    public Documento getDocumento(int id) {
        if (id == 1) {
            return new Documento(1, "Relatório Confidencial Q3", "2025-09-30", "O lucro líquido no terceiro trimestre superou as expectativas em 15%.");
        }
        if (id == 2) {
            return new Documento(2, "Plano de Expansão 2026", "2025-11-15", "A expansão para o mercado asiático será iniciada no segundo semestre de 2026.");
        }
        return null;
    }
}