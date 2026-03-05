import java.util.Iterator;
import java.util.TreeSet;

public class exercicio16 {
    public static void main(String[] args) {
        TreeSet<String> listaNomes = new TreeSet<String>();
        listaNomes.add("João");
        listaNomes.add("Cibele");
        listaNomes.add("Talita");
        listaNomes.add("Otavio");
        listaNomes.add("Isabela");
        Iterator<String> iterator = listaNomes.iterator();
        System.out.println("Lista de nomes:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n\n");
    }    
}
