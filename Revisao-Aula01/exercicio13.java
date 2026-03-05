import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class exercicio13 {
    public static void main(String[] args) {
        ArrayList<Integer> listaDuplicadas = new ArrayList<Integer>(List.of(2,2,4,4,6,6));
        System.out.println("Array com números duplicados: ");
        for (int i = 0; i < listaDuplicadas.size(); i++) {
            System.out.print(listaDuplicadas.get(i) + " ");
        }

        System.out.println("\n\nLimpando duplicatas.\nNova lista: ");
        HashSet<Integer> novaLista = new HashSet<Integer>(listaDuplicadas);
        System.out.println(novaLista.toString());
    }
}
