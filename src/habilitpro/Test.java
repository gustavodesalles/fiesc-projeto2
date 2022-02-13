package habilitpro;

import habilitpro.empresa.Empresa;
import habilitpro.empresa.EnumSegmento;
import habilitpro.empresa.EnumTipoEmpresa;
import habilitpro.modulo.Modulo;
import habilitpro.usuario.EnumPerfil;
import habilitpro.usuario.Usuario;

public class Test {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Outside Inc.", "88.024.482/0001-60", EnumTipoEmpresa.MATRIZ, EnumSegmento.TIC, "Belém", "PA", "Vale do Itajaí");
        Empresa empresa1 = new Empresa("Stone GmbH", "45.580.772/0001-88", EnumTipoEmpresa.FILIAL, "Brasil", EnumSegmento.ALIB, "São José", "SC", "Grande Florianópolis");

        Trilha trilha = new Trilha(empresa, "Japão, 1945-51", 4, "teste trilha 1");
        System.out.println(trilha.getNome());
        System.out.println(trilha.getApelido());
        Trilha trilha1 = new Trilha(empresa, "Japão, 1945-51", 3, "vamos ver se há diferença");
        System.out.println(trilha1.getNome());
        System.out.println(trilha1.getApelido());
        Trilha trilha2 = new Trilha(empresa, "Japão, 1945-51", 4, "do it again");
        System.out.println(trilha2.getNome());
        System.out.println(trilha2.getApelido());
        Trilha trilha3 = new Trilha(empresa, "Alemanha, 1945-49", 3, "yeah");
        System.out.println(trilha3.getNome());
        System.out.println(trilha3.getApelido());

        Trilha trilha4 = new Trilha(empresa1, "Japão, 1945-51", 5, "teste trilha 1");
        System.out.println(trilha4.getNome());
        System.out.println(trilha4.getApelido());

        System.out.println(empresa.getTrilhas());
        System.out.println(empresa.findTrilha("Japão, 1945-51 Outside Inc. 1 2022"));

        Modulo modulo = new Modulo(trilha1, "Módulo 1", "hgfdg", "jhgf");
        Modulo modulo1 = new Modulo(trilha4, "Teste 1", "gggg", "hfhfhfhf");
        Modulo modulo2 = new Modulo(trilha4, "Teste 2", "jjjj", "kn");
        System.out.println(trilha1.getModulos());
        System.out.println(trilha1.findModulo("Módulo 1"));
        System.out.println(trilha1.findModulo("Módulo 23"));
        modulo.setPrazoLimite(10);
        System.out.println(empresa.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").findModulo("Módulo 1").getPrazoLimite());
        modulo.iniciarModulo();
        System.out.println(modulo.getDataInicio());
        System.out.println(modulo.getStatus());

        Trabalhador trabalhador = new Trabalhador("Bob", "210.281.890-01", empresa, "Z", "destroy the meteor");
        System.out.println(trabalhador.getCpf());
        System.out.println(trabalhador.getDataUltimaAlter());
        trabalhador.alterarFuncao("save corneria");
        System.out.println(trabalhador.getFuncao());



        trabalhador.addTrilha(trilha1);
        trabalhador.addTrilha(trilha4);
//        System.out.println(trabalhador.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").getModulos());
        trabalhador.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").findModulo("Módulo 1").setHabilidades("Habilidade");

        trabalhador.setEmpresa(empresa1);
        trabalhador.addTrilha(trilha4);
        System.out.println(trabalhador.findTrilha("Japão, 1945-51 Stone GmbH Brasil 1 2022"));

        System.out.println(modulo.getHabilidades());
        System.out.println(trabalhador.getModulosComAv());
        trabalhador.avaliarModulo(modulo2, 5, "right on");
        trabalhador.avaliarModulo(modulo, 4, "oh");
        trabalhador.avaliarModulo(modulo1, 4, "yes");
        System.out.println(trabalhador.getModulosComAv());

        modulo.encerrarModulo();
        System.out.println(modulo.getDataFim());
        System.out.println(modulo.getStatus());
        System.out.println(trabalhador.findTrilha("Japão, 1945-51 Outside Inc. 2 2022").getModulos());
        System.out.println(trabalhador.getTrilhas());
        System.out.println(trabalhador.getModulosComAv());

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

        empresa.removeTrilha(trilha4);
        empresa1.removeTrilha(trilha4);
        System.out.println(empresa1.getTrilhas());

        trilha1.removeModulo(modulo);
        System.out.println(trabalhador.getTrilhas());
        trabalhador.removeTrilha(trilha1);
        System.out.println(trabalhador.getTrilhas());
    }
}
