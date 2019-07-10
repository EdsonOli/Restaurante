package bases;

import java.util.ArrayList;

public class Bebida extends Prato{

	private int estoque;
	
	public Bebida(String nome, double preco, int quant) 
	{
		super(nome, preco);
		this.estoque = quant;
	}
	
	public int getEstoque() 
	{
		return this.estoque;
	}
	public void setEstoque(int quant) 
	{
		this.estoque = quant;
	}
	
	
	public void diminuirQtdIng(int qtd)
	{
		setEstoque(this.getEstoque() - qtd);
	}
	public void aumentarQtdIng(int qtd)
	{
		setEstoque(this.getEstoque() + qtd);
	}
	
	//@Override
	public String toString() 
	{
		ArrayList<String> nomesIng = new ArrayList<String>();
		String msg = null;
		
		msg = " Nome: " + this.getNome() + "\n Preço: " + this.getPreco() + "Estoque: " + this.getEstoque() + "\n";
		
		return msg;
	}
	

}
