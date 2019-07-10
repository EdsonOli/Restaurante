package bases;

import java.util.ArrayList;

public class Bebida extends Prato{

	private int estoque;
	private String descr;
	
	public Bebida(String nome, double preco, int quant, String descr) 
	{
		super(nome, preco);
		this.estoque = quant;
		this.descr = descr;
	}
	
	public int getEstoque() 
	{
		return this.estoque;
	}
	public String getDescr() 
	{
		return this.descr;
	}
	public void setEstoque(int quant) 
	{
		this.estoque = quant;
	}
	public void setDescr(String descr) 
	{
		this.descr = descr;
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
		
		msg = " Nome: " + this.getNome() + "\n Preço: " + this.getPreco() + "\n Estoque: " + this.getEstoque()
			+ "\n Porção: " + this.getDescr() + "\n";
		
		return msg;
	}
	

}
