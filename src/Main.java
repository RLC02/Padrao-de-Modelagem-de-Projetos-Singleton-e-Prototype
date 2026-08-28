public class Main {

    public static void main(String[] args) {

        // 1. Preparação: solicitar a instância única da FilaDeImpressao
        System.out.println("=== 1. Obtendo instância da FilaDeImpressao ===");
        FilaDeImpressao fila = FilaDeImpressao.getInstance();

        // Prova do Singleton: segunda chamada deve retornar o mesmo objeto
        FilaDeImpressao fila2 = FilaDeImpressao.getInstance();
        System.out.println("fila == fila2 (Singleton): " + (fila == fila2));

        // 2. O Molde: criar o certificado original com new, nome do aluno em branco
        System.out.println("\n=== 2. Criando certificado original (molde) ===");
        Certificado original = new Certificado("Análise e Desenvolvimento de Sistemas");

        // 3. A Clonagem: gerar duas cópias do certificado original
        System.out.println("\n=== 3. Clonando o certificado ===");
        Certificado clone1 = original.clonar();
        Certificado clone2 = original.clonar();

        // 4. Personalização: definir um nome diferente em cada clone
        System.out.println("\n=== 4. Personalizando os clones ===");
        clone1.setNomeAluno("Ana Silva");
        clone2.setNomeAluno("Bruno Costa");

        // 5. Impressão: enviar os dados de cada clone para a fila
        System.out.println("\n=== 5. Enviando certificados para impressão ===");
        fila.imprimir(clone1.getDados());
        fila.imprimir(clone2.getDados());

        // 6. Validação obrigatória: teste de memória do Prototype
        System.out.println("\n=== 6. Teste de memória (Prototype) ===");
        System.out.println("clone1 == clone2: " + (clone1 == clone2));
    }
}
