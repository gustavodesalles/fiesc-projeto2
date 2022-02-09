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

    public void alterarFuncao(String funcao) {
        this.setFuncao(funcao);
        this.setDataUltimaAlter(LocalDate.now());
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setDataUltimaAlter(LocalDate dataUltimaAlter) {
        this.dataUltimaAlter = dataUltimaAlter;
    }
}
