package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entidades.enums.StatusPedido;

public class Pedido {

	private Date instante;
	private StatusPedido status;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private List<ProdutoDoPedido> pedidosProdutos = new ArrayList<>();
	private List<Produto> produtos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	
	public Pedido() {
		
	}

	public Pedido(Date instante, StatusPedido status) {
		this.instante = instante;
		this.status = status;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public void adicionaProdutoDoPedido(ProdutoDoPedido pedidoDoProduto) {
		pedidosProdutos.add(pedidoDoProduto);
	}

	public void removeProdutoDoPedido(ProdutoDoPedido pedidoDoProduto) {
		pedidosProdutos.remove(pedidoDoProduto);
	}
	
	public void adicionaProduto(Produto produto) {
		produtos.add(produto);
	}

	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	public void adicionaCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void removeCliente(Cliente cliente) {
		clientes.remove(cliente);
	}
	
	public double total() {
		double soma = 0;
		for(ProdutoDoPedido c : pedidosProdutos) {
			soma = soma + c.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Resumo do Pedido:\n");
		sb.append("Momento do Pedido: "+ sdf.format(instante) +"\n");
		sb.append("Status do Pedido: " + status +"\n");
		for(Cliente c : clientes) {
			sb.append(c+"\n");
		}
		sb.append("Itens do Pedido: \n");
		for(ProdutoDoPedido c : pedidosProdutos) {
			sb.append(c);
		}
		sb.append("Preço Total: R$"+ String.format("%.2f",total()));
		return sb.toString();
	}

	
}
