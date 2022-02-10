package habilitpro;

import habilitpro.empresa.Empresa;
import habilitpro.empresa.EnumSegmento;
import habilitpro.empresa.EnumTipoEmpresa;
import habilitpro.modulo.Modulo;
import habilitpro.usuario.EnumPerfil;
import habilitpro.usuario.Usuario;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Outside Inc.", "88.024.482/0001-60", EnumTipoEmpresa.MATRIZ, EnumSegmento.TIC, "Belém", "PA", "Vale do Itajaí");

        Trilha trilha = new Trilha(empresa, "Japão, 1945-51", 4, "teste trilha 1");
        System.out.println(trilha.getNome());
        System.out.println(trilha.getApelido());
        Trilha trilha1 = new Trilha(empresa, "Japão, 1945-51", 3, "vamos ver se há diferença");
        System.out.println(trilha1.getNome());
        System.out.println(trilha1.getApelido());

        System.out.println(empresa.getTrilhas());
        System.out.println(empresa.findTrilha("Japão, 1945-51 Outside Inc. 1 2022"));

        Modulo modulo = new Modulo(trilha1, "Módulo 1", "hgfdg", "jhgf", LocalDate.of(2022, 2, 28));
        System.out.println(trilha1.getModulos());
        System.out.println(trilha1.findModulo("Módulo 1"));
        System.out.println(trilha1.findModulo("Módulo 23"));
        modulo.setPrazoLimite(10);
        System.out.println(empresa.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").findModulo("Módulo 1").getPrazoLimite());

        Trabalhador trabalhador = new Trabalhador("Bob", "210.281.890-01", empresa, "Z", "destroy the meteor");
        System.out.println(trabalhador.getCpf());
        System.out.println(trabalhador.getDataUltimaAlter());
        trabalhador.alterarFuncao("save corneria");
        System.out.println(trabalhador.getFuncao());

        trabalhador.addTrilha(trilha1);
        System.out.println(trabalhador.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").getModulos());
        trabalhador.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").findModulo("Módulo 1").setHabilidades("Habilidade");
        System.out.println(trabalhador.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").getModulos());
        System.out.println(modulo.getHabilidades());

//        Usuario usuario = new Usuario("Alice", "01073351076", "alice@example.com", "yabbadabba2"); exceção devido ao formato do CPF
//        Usuario usuario = new Usuario("Alice", "010.733.510-76", "alice@examplecom", "yabbadabba2"); formato do email
//        Usuario usuario = new Usuario("Alice", "01073351076", "alice@example.com", "yabbadabba"); formato da senha
        Usuario usuario = new Usuario("Alice", "010.733.510-76", "alice@example.com", "yabbadabba2");
        usuario.addPerfil(EnumPerfil.RH);
        usuario.addPerfil(EnumPerfil.RH);
        usuario.addPerfil(EnumPerfil.ADMIN);
        usuario.addPerfil(EnumPerfil.OPERA);
        usuario.addPerfil(EnumPerfil.ADMIN);
        System.out.println(usuario);
    }
}
