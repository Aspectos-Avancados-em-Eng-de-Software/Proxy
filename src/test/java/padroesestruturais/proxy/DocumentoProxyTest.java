package padroesestruturais.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentoProxyTest {

    private IDocumento documentoProxy;
    private Usuario admin;
    private Usuario naoAdmin;

    @BeforeEach
    void setUp() {
        // O Documento ID 1 existe no RepositorioDocumentos
        documentoProxy = new DocumentoProxy(1);
        admin = new Usuario("Alice Admin", true);
        naoAdmin = new Usuario("Bob User", false);
    }

    @Test
    void testObterMetadados_LazyLoading() {
        List<String> metadados = documentoProxy.obterMetadados();

        assertNotNull(metadados);
        assertEquals(2, metadados.size());
        assertEquals("Relatório Confidencial Q3", metadados.get(0));
        assertEquals("2025-09-30", metadados.get(1));
    }

    @Test
    void testObterConteudoCompleto_AdminAccess() {
        String conteudo = documentoProxy.obterConteudoCompleto(admin);

        assertNotNull(conteudo);
        assertTrue(conteudo.contains("O lucro líquido no terceiro trimestre superou as expectativas em 15%."));
    }

    @Test
    void testObterConteudoCompleto_NonAdminAccessDenied() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            documentoProxy.obterConteudoCompleto(naoAdmin);
        });

        String expectedMessage = "Usuário Bob User não autorizado a visualizar o conteúdo completo.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void testObterConteudoCompleto_DocumentoInexistente() {
        IDocumento documentoInexistenteProxy = new DocumentoProxy(99);

        assertThrows(NullPointerException.class, () -> {
            documentoInexistenteProxy.obterConteudoCompleto(admin);
        });
    }
}
