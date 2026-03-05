import java.util.Iterator;
import java.util.TreeSet;

public class exercicio17 {
    
    public static class Produto implements Comparable<Produto> {
        private String nome;
        private double preco;

        public Produto(String nome, double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return this.nome;
        }
        
        public double getPreco() {
            return this.preco;
        }

        @Override
        public int compareTo(Produto outroProduto) {
            if (this.preco < outroProduto.getPreco()) {
                return -1;
            }
            if (this.preco > outroProduto.getPreco()) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Nome: " + getNome() + " | Preço: " + getPreco();
        }
    } 
    
    public static void main(String[] args) {
        TreeSet<Produto> setProdutos = new TreeSet<Produto>();
        setProdutos.add(new Produto("Teclado", 300));
        setProdutos.add(new Produto("Tupperware", 17));
        setProdutos.add(new Produto("Garrafa Térmica", 60));
        setProdutos.add(new Produto("Monitor", 700));
        setProdutos.add(new Produto("Mouse", 50));

        System.out.println("Lista de produtos ordenada por preço: ");
        Iterator<Produto> iterator = setProdutos.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println("\n\n");
    }    
}
