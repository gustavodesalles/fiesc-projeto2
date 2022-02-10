package habilitpro.modulo;

public enum EnumStatus {
    NAO_INIC("Curso não iniciado"),
    ANDAMENTO("Curso em andamento"),
    FASE("Em fase de avaliação"),
    AV_FINALIZADA("Fase de avaliação finalizada");

    private String descricao;

    EnumStatus(String descricao) { this.descricao = descricao; }
}
