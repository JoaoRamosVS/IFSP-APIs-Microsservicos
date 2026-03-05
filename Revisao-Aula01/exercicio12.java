import java.util.ArrayList;
import java.util.Scanner;

public class exercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cidades = new ArrayList<String>();
        cidades.add("Sao Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Belo Horizonte");
        cidades.add("Curitiba");

        System.out.println("Digite o nome de uma cidade para encontrá-la na lista: ");
        String buscaCidade = sc.nextLine();

        if (cidades.contains(buscaCidade)) {
            System.out.println("\nO índice da cidade na lista é " + cidades.indexOf(buscaCidade) + "\n\n");
        }
        else {
            System.out.println("\nA cidade informada não está presente na lista dessa base.\n\n");
        }
        sc.close();
    }
}