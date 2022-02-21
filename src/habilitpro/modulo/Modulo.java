package habilitpro.modulo;

import habilitpro.Trilha;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;

public class Modulo {
    private Trilha trilha;
    private String nome;
    private String habilidades;
    private String tarefa;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFim;
    private OffsetDateTime dataPrazo;
    private int prazoLimite;
    private EnumStatus status;

    public Modulo(Trilha trilha, String nome, String habilidades, String tarefa) {
        this.trilha = trilha;

        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();

        this.habilidades = habilidades;
        this.tarefa = tarefa;
        this.dataInicio = null;
        this.dataFim = null;
        this.dataPrazo = null;
        this.prazoLimite = 10;
        this.status = EnumStatus.NAO_INIC;
        trilha.addModulo(this);
    }

    public void iniciarModulo(OffsetDateTime time) {
        if (getStatus().equals(EnumStatus.NAO_INIC)) {
            setStatus(EnumStatus.ANDAMENTO);
            setDataInicio(time);
            setDataPrazo(calcularDataPrazo());
        }
    }

    public void encerrarModulo() {
        if (getStatus().equals(EnumStatus.ANDAMENTO)) {
            setStatus(EnumStatus.FASE);
            setDataFim(OffsetDateTime.now());
        }
    }

    public void finalizarAvaliacao() {
        if ((getStatus().equals(EnumStatus.ANDAMENTO) || getStatus().equals(EnumStatus.FASE)) && OffsetDateTime.now().isAfter(getDataPrazo())) {
            setStatus(EnumStatus.AV_FINALIZADA);
        }
    }

    public OffsetDateTime calcularDataPrazo() {
        OffsetDateTime auxData = getDataInicio().withHour(23).withMinute(55).withSecond(0).withNano(0);
        int i = prazoLimite;
        if (auxData.getDayOfWeek() != DayOfWeek.SATURDAY && auxData.getDayOfWeek() != DayOfWeek.SUNDAY) i--;
        for (int j = i; j > 0; j--) {
            auxData = auxData.plusDays(1);
            if (auxData.getDayOfWeek() == DayOfWeek.SATURDAY || auxData.getDayOfWeek() == DayOfWeek.SUNDAY) j++;
        }
        return auxData;
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

    public OffsetDateTime getDataFim() {
        return dataFim;
    }

    public int getPrazoLimite() {
        return prazoLimite;
    }

    public OffsetDateTime getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(OffsetDateTime dataPrazo) {
        this.dataPrazo = dataPrazo;
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

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(OffsetDateTime dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "nome='" + nome + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", tarefa='" + tarefa + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", dataPrazo=" + dataPrazo +
                ", prazoLimite=" + prazoLimite +
                ", status=" + status +
                '}';
    }
}
