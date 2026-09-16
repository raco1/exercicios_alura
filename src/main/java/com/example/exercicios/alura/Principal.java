package com.example.exercicios.alura;

import com.example.exercicios.alura.repository.CategoriaRepository;
import com.example.exercicios.alura.repository.PedidoRepository;
import com.example.exercicios.alura.repository.ProdutoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private ProdutoRepository produtoRepo;
    private PedidoRepository pedidoRepo;
    private CategoriaRepository categoriaRepo;

    public Principal(ProdutoRepository produtoRepo, PedidoRepository pedidoRepo, CategoriaRepository categoriaRepo) {
        this.produtoRepo = produtoRepo;
        this.pedidoRepo = pedidoRepo;
        this.categoriaRepo = categoriaRepo;
    }

    public void getMenu(){
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Criar Produto
                    2 - Criar Pedido
                    3 - Criar Categoria
                    4 - Listar Títulos criados
                    0 - Sair
                    """;

            System.out.println("\n" + menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    postProduto();
                    break;
                case 2:
                    postPedido();
                    break;
                case 3:
                    postCategoria();
                    break;
                case 4:
                    getList();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public void postProduto(){
        System.out.println("Digite o nome do produto para criá-lo:");
        String nomeProduto = scanner.nextLine();
        System.out.println("Digite o nome do produto para criá-lo:");
        Double valor = scanner.nextDouble();
        Produto produto = new Produto(nomeProduto, valor);
        produtoRepo.save(produto);
    }

    public void postPedido(){
        System.out.println("Digite a data do pedido para criá-lo:");
        String dataString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataString, formatter);

        Pedido pedido = new Pedido(data);
        pedidoRepo.save(pedido);
    }

    public void postCategoria(){
        System.out.println("Digite o nome da categoria para criá-lo:");
        String nomeCategoria = scanner.nextLine();

        Categoria categoria = new Categoria(nomeCategoria);
        categoriaRepo.save(categoria);
    }

    public void getList(){
        System.out.println("\nProdutos criados nessa sessão: ");
        List<Produto> produtos = produtoRepo.findAll();
        if(produtos.isEmpty()){
            System.out.println("\nNão foram criados produtos nessa sessão.");
        }else {
            produtos.stream()
                    .sorted(Comparator.comparing(Produto::getNome))
                    .forEach(System.out::println);
        }

        System.out.println("\nPedidos criados nessa sessão: ");
        List<Pedido> pedidos = pedidoRepo.findAll();
        if (pedidos.isEmpty()){
            System.out.println("\nNão foram criados pedidos nessa sessão.");
        } else {
            pedidos.stream()
                    .sorted(Comparator.comparing(Pedido::getData))
                    .forEach(System.out::println);
        }

        System.out.println("\nCategorias criados nessa sessão: ");
        List<Categoria> categorias = categoriaRepo.findAll();
        if(categorias.isEmpty()){
            System.out.println("\nNão foram criadas categorias nessa sessão.");
        } else{
            categorias.stream()
                    .sorted(Comparator.comparing(Categoria::getNome))
                    .forEach(System.out::println);
        }
    }

}
