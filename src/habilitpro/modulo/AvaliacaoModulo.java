package habilitpro.modulo;

public class AvaliacaoModulo {
    public int notaAvaliacao;
    public String anotacoes;

    public AvaliacaoModulo() {
        this.notaAvaliacao = 0;
        this.anotacoes = null;
    }

    public int getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(int notaAvaliacao) {
        if (notaAvaliacao >= 1 && notaAvaliacao <= 5) {
            this.notaAvaliacao = notaAvaliacao;
        }
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    @Override
    public String toString() {
        return "AvaliacaoModulo{" +
                "notaAvaliacao=" + notaAvaliacao +
                ", anotacoes='" + anotacoes + '\'' +
                '}';
    }
}
