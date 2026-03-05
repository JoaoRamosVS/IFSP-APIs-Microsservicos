import java.util.LinkedList;

public class exercicio29 {
    public static class Historico {
        private LinkedList<String> listaHistorico;
        private Integer paginaAtual;

        public Historico(LinkedList<String> listaHistorico) {
            this.paginaAtual = null;
            this.listaHistorico = listaHistorico;
        }

        public LinkedList<String> getListaHistorico() {
            return listaHistorico;
        }

        public Integer getPaginaAtual() {
            return paginaAtual;
        }

        public void visitar(String url){
            listaHistorico.add(url);
            if (listaHistorico.size() == 1) {
                paginaAtual = 0; 
            }
            else {
                paginaAtual = listaHistorico.size() - 1;
            }
            exibirPaginaAtual();
        };

        public void voltar(){
            if (listaHistorico.size() == 1 || paginaAtual == 0) {
                paginaAtual = 0; 
            }
            else {
                System.out.println("Voltando página...");
                paginaAtual--;
            }
            exibirPaginaAtual();
        };

        public void avancar(){
            if (paginaAtual < listaHistorico.size() - 1) {
                System.out.println("Avançando página...");
                paginaAtual++;
            }
            else {
                System.out.println("Já está na última página.");
            }
            exibirPaginaAtual();
        };

        public void exibirHistorico(){
            for (String registro : listaHistorico) {
                System.out.println(listaHistorico.indexOf(registro) + " - Acessou " + registro);
            }
        }

        public void exibirPaginaAtual() {
            System.out.println("A página atual é: " + listaHistorico.get(paginaAtual));
        }
    }

    public static void main(String[] args) {
        Historico historicoUsuario = new Historico(new LinkedList<>());

        historicoUsuario.visitar("google.com");
        historicoUsuario.visitar("moodle.com.br");
        historicoUsuario.visitar("gru.ifsp.edu.br");
        historicoUsuario.visitar("youtube.com");
        historicoUsuario.visitar("stackoverflow.com");
        historicoUsuario.visitar("tudomateria.com");
        System.out.println("\n---");
        historicoUsuario.voltar();
        System.out.println("\n---");
        historicoUsuario.voltar();
        System.out.println("\n---");
        historicoUsuario.avancar();
        System.out.println("\n---");
        historicoUsuario.avancar();
        System.out.println("\n---");
        historicoUsuario.voltar();
        System.out.println("\n---");
        historicoUsuario.visitar("vcriquinho.com");

        System.out.println("\n-------\nHistórico final:");
        historicoUsuario.exibirHistorico();
    }
}