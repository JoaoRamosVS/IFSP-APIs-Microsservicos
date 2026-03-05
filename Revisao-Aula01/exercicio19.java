import java.util.HashMap;

public class exercicio19 {
    public static void main(String[] args) {
        HashMap<String, Integer> contadorPalavras = new HashMap<>();
        String paragrafo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas tristique neque id ex pellentesque, sit amet semper ex venenatis. Nam vulputate lobortis risus non auctor. Vestibulum molestie, neque quis tempor euismod, dolor lacus viverra erat, eget hendrerit ante nisi et nisi. In dignissim arcu erat, in imperdiet ex blandit sed. Mauris congue eros at lacinia tempus. Aliquam fringilla risus sed orci dignissim, ut varius tellus vulputate. Nulla gravida nulla eu blandit imperdiet. Mauris ut quam a ligula sagittis feugiat dictum sed ipsum. Aenean ultricies gravida nisi, et volutpat tortor fermentum sit amet. Suspendisse potenti. Phasellus risus ipsum, porta sit amet porttitor vel, semper sit amet massa. Nullam porttitor erat lectus, vitae condimentum sem sagittis non.";

        paragrafo = paragrafo.replace(',', ' ');
        paragrafo = paragrafo.replace('.', ' ');
        paragrafo = paragrafo.trim();
        String[] partsParagrafo = paragrafo.split(" ");

        for (String string : partsParagrafo) {
            Integer busca = contadorPalavras.get(string.toLowerCase());
            if(busca != null) {
                contadorPalavras.put(string.toLowerCase(), busca+1);
            }
            else {
                contadorPalavras.put(string.toLowerCase(), 1);
            }
        }

        System.out.println(contadorPalavras.toString());
    }
}
