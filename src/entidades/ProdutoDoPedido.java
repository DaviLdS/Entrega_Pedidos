package entidades;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDoPedido {

	private Integer quantidade;
	private Double preco;
	private List<Produto> produtos = new ArrayList<>();

	public ProdutoDoPedido() {
	}

	public ProdutoDoPedido(Integer quantidade, Double preco) {
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public double subTotal() {
		return quantidade * preco;
	}

	public void adicionaProduto(Produto produto) {
		produtos.add(produto);
	}

	public void removeProduto(Produto produto) {
		produtos.remove(produto);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Produto c : produtos) {
			sb.append(c + "Quantidade: " + quantidade + ", SubTotal: R$" + String.format("%.2f%n", subTotal()));
		}
		return sb.toString();

	}
}
