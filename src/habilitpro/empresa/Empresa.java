package habilitpro.empresa;

import habilitpro.Trilha;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private String cnpj;
    private EnumTipoEmpresa tipoEmpresa;
    private String nomeFilial;
    private EnumSegmento segmento;
    private String cidade;
    private String estado;
    private String regionalSenai;
    private ArrayList<Trilha> trilhas;

    public Empresa(String nome, String cnpj, EnumTipoEmpresa tipoEmpresa, String nomeFilial, EnumSegmento segmento, String cidade, String estado, String regionalSenai) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();
        if (regexCnpj(cnpj)) {
            this.cnpj = cnpj;
        } else throw new IllegalArgumentException();
        this.tipoEmpresa = tipoEmpresa;
        this.nomeFilial = nomeFilial;
        this.segmento = segmento;
        if (!cidade.isBlank()) {
            this.cidade = cidade;
        } else throw new IllegalArgumentException();
        if (!cidade.isBlank()) {
            this.estado = estado;
        } else throw new IllegalArgumentException();
        this.regionalSenai = regionalSenai;
        this.trilhas = new ArrayList<>();
    }

    public Empresa(String nome, String cnpj, EnumTipoEmpresa tipoEmpresa, EnumSegmento segmento, String cidade, String estado, String regionalSenai) {
        this.nome = nome;
        if (regexCnpj(cnpj)) {
            this.cnpj = cnpj;
        } else throw new IllegalArgumentException();
        this.tipoEmpresa = tipoEmpresa;
        this.nomeFilial = "";
        this.segmento = segmento;
        this.cidade = cidade;
        this.estado = estado;
        this.regionalSenai = regionalSenai;
        this.trilhas = new ArrayList<>();
    }

    public static boolean regexCnpj(String cnpj) {
        String rePattern = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}";
        return cnpj.matches(rePattern);
    }

    public void addTrilha(Trilha trilha) {
        this.trilhas.add(trilha);
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

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public EnumTipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public EnumSegmento getSegmento() {
        return segmento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getRegionalSenai() {
        return regionalSenai;
    }

    public ArrayList<Trilha> getTrilhas() {
        return trilhas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setTipoEmpresa(EnumTipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public void setSegmento(EnumSegmento segmento) {
        this.segmento = segmento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRegionalSenai(String regionalSenai) {
        this.regionalSenai = regionalSenai;
    }

    public void setTrilhas(ArrayList<Trilha> trilhas) {
        this.trilhas = trilhas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", tipoEmpresa=" + tipoEmpresa +
                ", nomeFilial='" + nomeFilial + '\'' +
                ", segmento=" + segmento +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", regionalSenai='" + regionalSenai + '\'' +
                ", trilhas=" + trilhas +
                '}';
    }
}
