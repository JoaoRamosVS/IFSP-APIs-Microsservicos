import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExercicioProduto {
    public static void main(String[] args) {
        List<Produto> catalogoProdutos = new ArrayList<>();
        
        catalogoProdutos.add(new Produto("Java Programming", 89.90, "Livros"));
        catalogoProdutos.add(new Produto("Clean Code", 79.50, "Livros"));
        catalogoProdutos.add(new Produto("Design Patterns", 95.00, "Livros"));
        catalogoProdutos.add(new Produto("The Pragmatic Programmer", 85.00, "Livros"));
        catalogoProdutos.add(new Produto("Laptop Dell", 3500.00, "Eletronicos"));
        catalogoProdutos.add(new Produto("Mouse Logitech", 150.00, "Eletronicos"));
        catalogoProdutos.add(new Produto("Teclado Mecânico", 450.00, "Eletronicos"));
        catalogoProdutos.add(new Produto("Monitor LG 27\"", 1200.00, "Eletronicos"));
    
        // Exercício A
        /*
        Use forEach e uma estrutura if tradicional para imprimir o nome de todos os produtos da categoria “Eletrônicos”. 
        Em seguida, refaça o mesmo exercício usando stream() e a operação filter().
         */
        System.out.println("Produtos da categoria Eletrônicos:");
        // for (Produto produto : catalogoProdutos) {
        //    if (produto.getCategoria() == "Eletronicos") {
        //     System.out.println("- Nome: " + produto.getNome() + " | Preço: " + produto.getPreco());
        //    } 
        // }
        for (Produto produto : catalogoProdutos
            .stream()
            .filter(p -> p.getCategoria() == "Eletronicos")
            .collect(Collectors.toList())) {
            System.out.println("- Nome: " + produto.getNome() + " | Preço: " + produto.getPreco());
        }
        System.out.println("\n");

        // Exercício B
        /*
        Crie uma nova lista contendo apenas os preços de todos os produtos cujo preço seja maior que 500.0. 
        Use as operações filter() e map(). Imprima a lista de preços.
         */
        List<Double> precos = new ArrayList<>();
        precos = catalogoProdutos.stream()
                                 .filter(p -> p.getPreco() > 500.0)
                                 .map(p -> p.getPreco())
                                 .collect(Collectors.toList());
        System.out.println("Preços maiores que 500 na loja: ");
        for (int i = 0; i < precos.size(); i++) {
            System.out.printf("Preço %d: %.2f\n", i+1, precos.get(i));
        }
        System.out.println("\n");

        // Exercício C
        /*
        Calcule o valor total do estoque de produtos da categoria “Livros”. 
        Use filter() para selecionar os produtos da categoria correta e, 
        em seguida, use mapToDouble() e sum() para calcular o total.
         */
        System.out.println("Valor total do estoque de produtos da categoria Livros:");
        Double precoTotalLivros = catalogoProdutos.stream()
                                                  .filter(p -> p.getCategoria() == "Livros")
                                                  .mapToDouble(p -> p.getPreco())
                                                  .sum();
        System.out.printf("Preço total: %.2f\n", precoTotalLivros);
        System.out.println("\n");

        // Exercício D
        /*
        Escreva um método buscarProdutoPorNome(List<Produto> produtos, String nome) 
        que retorna um Optional<Produto>. Use a Stream API (filter e findFirst).
         */
        // Escrito abaixo da classe produto
        
        // Exercício E
        /*
        No seu método main, chame o buscarProdutoPorNome: Primeiro, com um nome de produto que existe. 
        Use ifPresent() para imprimir os detalhes do produto; Depois, com um nome que não existe. 
        Use orElseThrow() para lançar uma RuntimeException com a mensagem “Produto não encontrado!”.
         */
        buscarProdutoPorNome(catalogoProdutos, "Laptop Dell")
                            .ifPresent(p -> System.out.println(p.toString()));

        System.out.println("\n");
        
        // Produto buscaLivro = buscarProdutoPorNome(catalogoProdutos, "Java para Iniciantes")
        // .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        
        // System.out.println("\n\n");

        // Exercício F
        /*
         Crie um stream a partir da sua lista de produtos e use .map() para obter uma List<String>
         contendo apenas os nomes dos produtos. Primeiro, faça isso com uma expressão lambda (p -> 
         p.getNome()) e depois refatore para usar uma referência de método (Produto::getNome).
         */
        // List<String> nomeProdutos = catalogoProdutos.stream()
        //                                             .map(p -> p.getNome())
        //                                             .toList();
        List<String> nomeProdutos = catalogoProdutos.stream()
                                                    .map(Produto::getNome)
                                                    .toList();
        System.out.println("Nome de todos os produtos: ");
        for (String string : nomeProdutos) {
            System.out.println(string);
        }
        System.out.println("\n\n");
    }

     public static class Produto {
        private String nome;
        private Double preco;
        private String categoria;

        public Produto(String nome, Double preco, String categoria) {
            this.nome = nome;
            this.preco = preco;
            this.categoria = categoria;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public Double getPreco() {
            return preco;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        @Override
        public String toString() {
            return "Nome: " 
                   + getNome() 
                   + "\nPreço: " 
                   + getPreco() 
                   + "\nCategoria: " 
                   + getCategoria();
        }
    }

    public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
            return produtos.stream()
                           .filter(p -> p.getNome() == nome)
                           .findFirst();
    }
}