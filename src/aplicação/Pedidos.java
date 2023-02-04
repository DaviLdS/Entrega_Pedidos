package aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entidades.Cliente;
import entidades.Pedido;
import entidades.Produto;
import entidades.ProdutoDoPedido;
import entidades.enums.StatusPedido;

public class Pedidos {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		System.out.println("Digite as informações do Cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Aniversario (DD/MM/AAAA): ");
		Date aniversario = sdf.parse(sc.next());
		sc.nextLine();
		System.out.println("Digite as informações do Pedido: ");
		System.out.print("Status do Pedido: ");
		String status = sc.nextLine();
		System.out.print("Quando itens terão no pedido? ");
		int n = sc.nextInt();
		sc.nextLine();
		Pedido pedido = new Pedido(data, StatusPedido.valueOf(status));
		Cliente cliente = new Cliente(nome,email,aniversario);
		pedido.adicionaCliente(cliente);
		for (int i = 1; i<= n;i++ ) {
			System.out.println("Digite os dados do "+i+"° item:");
			System.out.print("Nome do produto: ");
			String nomeP = sc.nextLine();
			System.out.print("Valor do Produto: ");
			double valorP = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			sc.nextLine();
			ProdutoDoPedido pedidosProdutos = new ProdutoDoPedido(quantidade,valorP);
			pedido.adicionaProdutoDoPedido(pedidosProdutos);
			Produto produto = new Produto (nomeP,valorP);
			pedidosProdutos.adicionaProduto(produto);
		}
		System.out.println();
		System.out.println(pedido);
		sc.close();
	}
}
