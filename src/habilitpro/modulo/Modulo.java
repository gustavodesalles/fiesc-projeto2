package habilitpro.modulo;

import habilitpro.Trilha;

import java.time.LocalDate;

public class Modulo {
    private Trilha trilha;
    private String nome;
    private String habilidades;
    private String tarefa;
    private LocalDate dataFim;
    private int prazoLimite;
    private EnumStatus status;

    public Modulo(Trilha trilha, String nome, String habilidades, String tarefa, LocalDate dataFim) {
        this.trilha = trilha;

        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();

        this.habilidades = habilidades;
        this.tarefa = tarefa;
        this.dataFim = dataFim;
        this.prazoLimite = 14;
        this.status = EnumStatus.ANDAMENTO;
        trilha.addModulo(this);
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

    public LocalDate getDataFim() {
        return dataFim;
    }

    public int getPrazoLimite() {
        return prazoLimite;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public void setPrazoLimite(int prazoLimite) {
        this.prazoLimite = prazoLimite;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Modulo{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", habilidades='").append(habilidades).append('\'');
        sb.append(", tarefa='").append(tarefa).append('\'');
        sb.append(", dataFim=").append(dataFim);
        sb.append(", prazoLimite=").append(prazoLimite);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
