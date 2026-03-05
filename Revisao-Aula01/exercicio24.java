import java.util.LinkedList;
import java.util.Queue;

public class exercicio24 {
    public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();
        filaImpressao.add("Documento1.pdf");
        filaImpressao.add("Logo.svg");
        filaImpressao.add("FotoPerfil.jpg");
        filaImpressao.add("ArrowLeft.svg");
        filaImpressao.add("ArteFinal.png");

        Integer tamanhoFila = filaImpressao.size();
        System.out.println("---- FILA DE IMPRESSÃO ----");
        for (int i = 0; i < tamanhoFila; i++) {
            System.out.println("Imprimindo " + filaImpressao.poll());
        }
        System.out.println("\n");
    }
}
