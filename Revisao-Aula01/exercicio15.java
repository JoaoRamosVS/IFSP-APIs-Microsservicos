import java.util.LinkedHashSet;

public class exercicio15 {
    public static void main(String[] args) {
        LinkedHashSet<String> diasDaSemana = new LinkedHashSet<String>();
        diasDaSemana.add("Quarta");
        diasDaSemana.add("Sexta");
        diasDaSemana.add("Terça");
        diasDaSemana.add("Domingo");
        diasDaSemana.add("Quinta");
        diasDaSemana.add("Segunda");
        diasDaSemana.add("Sábado");

        for (String dia : diasDaSemana) {
            System.out.println(dia);            
        }
    }
}
