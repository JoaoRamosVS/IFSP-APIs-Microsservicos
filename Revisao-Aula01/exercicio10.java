import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exercicio10 {
    public static void main(String[] args) {
        ArrayList<Integer> listaInteiros = new ArrayList<Integer>(List.of(20,78,45,9,14,32,11,4,10,15));
        Collections.sort(listaInteiros);
        System.out.println(listaInteiros);
        
    }
}
