public class FilaDeImpressao {

    private static FilaDeImpressao instance;

    private FilaDeImpressao() {
        System.out.println("[FilaDeImpressao] Conexão com a impressora central estabelecida.");
    }

    public static FilaDeImpressao getInstance() {
        if (instance == null) {
            instance = new FilaDeImpressao();
        }
        return instance;
    }

    public void imprimir(String documento) {
        System.out.println("[FilaDeImpressao] Imprimindo: " + documento);
    }
}
