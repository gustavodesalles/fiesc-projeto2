package habilitpro;

import habilitpro.empresa.Empresa;
import habilitpro.modulo.Modulo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trilha {
    private Empresa empresa;
    private String ocupacao;
    private String nome;
    private String apelido;
    private ArrayList<Modulo> modulos;
    private int nivelSatisfacao;
    private String anotacoes;

    public Trilha(Empresa empresa, String ocupacao, int nivelSatisfacao, String anotacoes) {
        this.empresa = empresa;

        if (!ocupacao.isBlank()) {
            this.ocupacao = ocupacao;
        } else throw new IllegalArgumentException();

        this.modulos = new ArrayList<>();

        if (nivelSatisfacao <= 5 && nivelSatisfacao >= 1) {
            this.nivelSatisfacao = nivelSatisfacao;
        } else throw new IllegalArgumentException();

        this.anotacoes = anotacoes;
        this.nome = criarNome(empresa, ocupacao);
        this.apelido = criarApelido(empresa, ocupacao);
        empresa.addTrilha(this);
    }

    public static String criarNome(Empresa empresa, String ocupacao) {
        int numSeq = 1;
        for (Trilha t : empresa.getTrilhas()) {
            if (t.getOcupacao().equals(ocupacao)) {
                numSeq++;
            }
        }
        return ocupacao + " " + empresa.getNome() + " " + numSeq + " " + LocalDate.now().getYear();
    }

    public static String criarApelido(Empresa empresa, String ocupacao) {
        int numSeq = 1;
        for (Trilha t : empresa.getTrilhas()) {
            if (t.getOcupacao().equals(ocupacao)) {
                numSeq++;
            }
        }
        return ocupacao + " " + numSeq;
    }

    public void addModulo(Modulo modulo) {
        this.modulos.add(modulo);
    }

    public Modulo findModulo(String nomeModulo) {
        for (Modulo m : modulos) {
            if (nomeModulo.equals(m.getNome())) {
                return m;
            }
        }
        return null;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public int getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Trilha{");
        sb.append("empresa=").append(empresa);
        sb.append(", ocupacao='").append(ocupacao).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", apelido='").append(apelido).append('\'');
        sb.append(", modulos=").append(modulos);
        sb.append(", nivelSatisfacao=").append(nivelSatisfacao);
        sb.append(", anotacoes='").append(anotacoes).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
