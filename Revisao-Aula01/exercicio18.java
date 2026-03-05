import java.util.HashMap;
import java.util.Scanner;

public class exercicio18 {
    public static void main(String[] args) {
        HashMap<String, String> dicIngles = new HashMap<>();
        dicIngles.put("batata", "potato");
        dicIngles.put("computador", "computer");
        dicIngles.put("caderno", "notebook");
        dicIngles.put("celular", "smartphone");
        dicIngles.put("dedo", "finger");

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma palavra em português para traduzi-la para inglês: ");
        String palavraDigitada = sc.nextLine();
        String palavraEmIngles = dicIngles.get(palavraDigitada);

        if(palavraEmIngles != null) {
            System.out.println("\nPalavra em inglês: " + palavraEmIngles + "\n\n");
        }
        else {
            System.out.println("\nPalavra não encontrada no dicionário.\n\n");
        }

        sc.close();
    }    
}
