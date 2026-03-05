import java.util.HashSet;

public class exercicio14 {
    public static void main(String[] args) {
        HashSet<String> listaEmails = new HashSet<String>();
        listaEmails.add("joao@gmail.com");
        listaEmails.add("joao@gmail.com");
        listaEmails.add("ana@gmail.com");
        listaEmails.add("guilherme@gmail.com");
        listaEmails.add("isabela@gmail.com");
        listaEmails.add("brenda@gmail.com");
        listaEmails.add("cleia@gmail.com");
        System.out.print("Tamanho do Set: " + listaEmails.size() + "\n\n");
    }
}
