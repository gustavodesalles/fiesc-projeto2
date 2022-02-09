package habilitpro.modulo;

public enum EnumStatus {
    ANDAMENTO("Curso em andamento"),
    FASE("Em fase de avaliação"),
    FINALIZADA("Fase de avaliação finalizada");

    private String descricao;

    EnumStatus(String descricao) { this.descricao = descricao; }
}
