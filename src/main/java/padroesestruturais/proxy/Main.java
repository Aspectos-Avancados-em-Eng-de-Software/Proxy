package padroesestruturais.proxy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario admin = new Usuario("Alice Admin", true);
        Usuario user = new Usuario("Bob User", false);

        IDocumento documentoProxy = new DocumentoProxy(1);

        System.out.println("--- Teste de Metadados (Lazy Loading) ---");

        List<String> metadados = documentoProxy.obterMetadados();
        System.out.println("Metadados do Documento ID 1: " + metadados);

        System.out.println("\n--- Teste de Conteúdo Completo (Controle de Acesso) ---");

        try {
            System.out.println("Tentando acesso com Usuário Comum...");
            documentoProxy.obterConteudoCompleto(user);
        } catch (IllegalArgumentException e) {
            System.out.println("Acesso Negado: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando acesso com Administrador...");
            String conteudo = documentoProxy.obterConteudoCompleto(admin);
            System.out.println("Conteúdo Completo do Documento ID 1: " + conteudo);
        } catch (IllegalArgumentException e) {
            System.out.println("Acesso Negado: " + e.getMessage());
        }
    }
}