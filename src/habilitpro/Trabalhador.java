package habilitpro;

import habilitpro.empresa.Empresa;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trabalhador {
    private String nome;
    private String cpf;
    private Empresa empresa;
    private String setor;
    private String funcao;
    private LocalDate dataUltimaAlter;
    private ArrayList<Trilha> trilhas;

    public Trabalhador(String nome, String cpf, Empresa empresa, String setor, String funcao) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();

        if (regexCpf(cpf)) {
            this.cpf = cpf;
        } else throw new IllegalArgumentException();

        this.empresa = empresa;

        if (!setor.isBlank()) {
            this.setor = setor;
        } else throw new IllegalArgumentException();

        if (!funcao.isBlank()) {
            this.funcao = funcao;
        } else throw new IllegalArgumentException();

        this.dataUltimaAlter = LocalDate.now();

        this.trilhas = new ArrayList<>();
    }

    public static boolean regexCpf(String cpf) {
        String rePattern = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
        return cpf.matches(rePattern);
    }

    public void addTrilha(Trilha trilha) {
        if (trilha.getEmpresa().equals(empresa)) this.trilhas.add(trilha);
    }

    public void removeTrilha(Trilha trilha) {
        this.trilhas.remove(trilha);
    }

    public Trilha findTrilha(String nomeTrilha) {
        for (Trilha t : trilhas) {
            if (nomeTrilha.equals(t.getNome())) {
                return t;
            }
        }
        return null;
    }

    public void alterarFuncao(String funcao) {
        this.setFuncao(funcao);
        this.setDataUltimaAlter(LocalDate.now());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public LocalDate getDataUltimaAlter() {
        return dataUltimaAlter;
    }

    public ArrayList<Trilha> getTrilhas() {
        return trilhas;
    }

    public void setTrilhas(ArrayList<Trilha> trilhas) {
        this.trilhas = trilhas;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setDataUltimaAlter(LocalDate dataUltimaAlter) {
        this.dataUltimaAlter = dataUltimaAlter;
    }

    @Override
    public String toString() {
        return "Trabalhador{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", empresa=" + empresa +
                ", setor='" + setor + '\'' +
                ", funcao='" + funcao + '\'' +
                ", dataUltimaAlter=" + dataUltimaAlter +
                ", trilhas=" + trilhas +
                '}';
    }
}
