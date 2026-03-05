import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class exercicio26 {

    public static class Produto {
        private Integer codigo;
        private String nome;

        public Produto(Integer codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

    public static void main(String[] args) {
        Map<String, List<Produto>> catalogoProdutos = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        List<Produto> eletronicos = new java.util.ArrayList<>();
        eletronicos.add(new Produto(1, "Smartphone"));
        eletronicos.add(new Produto(2, "Notebook"));
        eletronicos.add(new Produto(3, "Fone de Ouvido"));
        catalogoProdutos.put("eletronicos", eletronicos);
        
        List<Produto> limpeza = new java.util.ArrayList<>();
        limpeza.add(new Produto(4, "Detergente"));
        limpeza.add(new Produto(5, "Sabão em Pó"));
        limpeza.add(new Produto(6, "Desinfetante"));
        catalogoProdutos.put("limpeza", limpeza);
        
        List<Produto> vestuario = new java.util.ArrayList<>();
        vestuario.add(new Produto(7, "Camiseta"));
        vestuario.add(new Produto(8, "Calça Jeans"));
        vestuario.add(new Produto(9, "Tênis"));
        catalogoProdutos.put("vestuario", vestuario);
        
        System.out.println("---- CATÁLOGO DE PRODUTOS ----");
        System.out.println("-- Escolha uma categoria:");
        System.out.println("- 1-ELETRONICOS");
        System.out.println("- 2-LIMPEZA");
        System.out.println("- 3-VESTUARIO");
        System.out.print("- ->: ");
        Integer opcaoCategoria = sc.nextInt();

        System.out.println("---- ---- ---- ----");
        switch (opcaoCategoria) {
            case 1:
                System.out.println("---- ELETRÔNICOS ----");
                for (Produto produto : catalogoProdutos.get("eletronicos")) {
                    System.out.println("- CÓD: " + produto.getCodigo() + " | NOME: " + produto.getNome());
                }
                System.out.println("\n");
                break;
        
            case 2:
                System.out.println("---- LIMPEZA ----");
                for (Produto produto : catalogoProdutos.get("limpeza")) {
                    System.out.println("- CÓD: " + produto.getCodigo() + " | NOME: " + produto.getNome());
                }
                System.out.println("\n");
                break;
        
            case 3:
                System.out.println("---- VESTUÁRIO ----");
                for (Produto produto : catalogoProdutos.get("vestuario")) {
                    System.out.println("- CÓD: " + produto.getCodigo() + " | NOME: " + produto.getNome());
                }
                System.out.println("\n");
                break;
        
            default:
                System.out.println("- Não existem produtos para esta categoria.\n");
                break;
        }
        sc.close();
    }   
}
