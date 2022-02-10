package habilitpro.usuario;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private ArrayList<EnumPerfil> perfis;

    public Usuario(String nome, String cpf, String email, String senha) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else throw new IllegalArgumentException();

        if (regexCpf(cpf)) {
            this.cpf = cpf;
        } else throw new IllegalArgumentException();

        if (regexEmail(email)) {
            this.email = email;
        } else throw new IllegalArgumentException();

        if (checkSenha(senha)) {
            this.senha = senha;
        } else throw new IllegalArgumentException();

        this.perfis = new ArrayList<>();
    }

    public static boolean regexCpf(String cpf) {
        String rePattern = "(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})";
        return cpf.matches(rePattern);
    }

    public static boolean regexEmail(String email) {
        String rePattern = "(.+)@(.+)\\.(.+)";
        return email.matches(rePattern);
    }

    public static boolean checkSenha(String senha) {
        return senha.length() >= 8 && senha.matches(".*\\d.*") && senha.matches(".*\\w.*");
    }

    public void addPerfil(EnumPerfil perfil) {
        if (!contains(perfil)) perfis.add(perfil);
    }

    public boolean contains(EnumPerfil perfil) {
        for (EnumPerfil p : perfis) {
            if (perfil.equals(p)) return true;
        }
        return false;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<EnumPerfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(ArrayList<EnumPerfil> perfis) {
        this.perfis = perfis;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", senha='").append(senha).append('\'');
        sb.append(", perfis=").append(perfis);
        sb.append('}');
        return sb.toString();
    }
}
