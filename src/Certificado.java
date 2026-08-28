public class Certificado {

    private String nomeCurso;
    private String nomeAluno;

    public Certificado(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        this.nomeAluno = "";
        System.out.println("[Certificado] Certificado padrão criado para o curso: " + nomeCurso);
    }

    // Construtor de cópia — usado pelo clonar()
    private Certificado(Certificado original) {
        this.nomeCurso = original.nomeCurso;
        this.nomeAluno = original.nomeAluno;
    }

    public Certificado clonar() {
        return new Certificado(this);
    }

    public void setNomeAluno(String nome) {
        this.nomeAluno = nome;
    }

    public String getDados() {
        return "Curso: " + nomeCurso + " | Aluno: " + nomeAluno;
    }
}
