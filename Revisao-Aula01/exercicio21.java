import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class exercicio21 {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> produtos = new LinkedHashMap<>();
        produtos.put(12000, "Monitor");
        produtos.put(12012, "Teclado");
        produtos.put(12014, "Mouse");
        produtos.put(12015, "Adaptador Ethernet");
        produtos.put(12018, "Webcam");

        Set<Entry<Integer,String>> keys = produtos.entrySet();
        System.out.println("PRODUTOS:");
        for (Entry<Integer,String> entry : keys) {
            System.out.println("- CÓD: " + entry.getKey() + " | NOME: " + entry.getValue());
        }
        System.out.println("\n");
    }
}
