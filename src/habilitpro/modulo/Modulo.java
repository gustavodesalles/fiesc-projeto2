package habilitpro.modulo;

import habilitpro.Trilha;

import java.time.LocalDate;

public class Modulo {
    private Trilha trilha;
    private String nome;
    private String habilidades;
    private String tarefa;
    private LocalDate prazoLimite;
    private EnumStatus status;

    public Modulo(Trilha trilha, String nome, String habilidades, String tarefa, EnumStatus status) {
        this.trilha = trilha;

        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();

        this.habilidades = habilidades;
        this.tarefa = tarefa;
        this.prazoLimite = LocalDate.now().plusDays(14);
        this.status = status;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public String getNome() {
        return nome;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public String getTarefa() {
        return tarefa;
    }

    public LocalDate getPrazoLimite() {
        return prazoLimite;
    }

    public EnumStatus getStatus() {
        return status;
    }
}
