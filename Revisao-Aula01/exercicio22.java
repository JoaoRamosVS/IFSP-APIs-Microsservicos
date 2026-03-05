import java.util.TreeMap;
import java.util.Map.Entry;

public class exercicio22 {
    public static void main(String[] args) {
        TreeMap<String,Double> notasProva = new TreeMap<>();
        notasProva.put("Joao", 8.0);
        notasProva.put("Ana", 9.3);
        notasProva.put("Isabela", 10.0);
        notasProva.put("Eduardo", 8.9);
        notasProva.put("Bruna", 5.0);

        System.out.println("---- NOTAS DA PROVA DE ENGSFW ----");
        for (Entry<String,Double> nota : notasProva.entrySet()) {
            System.out.println("- NOME: " + nota.getKey() + " | NOTA: " + nota.getValue());
        }
        System.out.println("\n\n");
    }
}
