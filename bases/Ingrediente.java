package bases;

import java.io.Serializable;

public class Ingrediente implements Serializable
{
	
	private static final long serialVersionUID = -829980167655529991L;
	private String nome;
	private int quantidade;
	private double preco;

	public Ingrediente(String nome, int quantidade, double preco)
	{
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getNome()
	{
		return nome;
	}

	public int getQuantidade()
	{
		return quantidade;
	}
	
	public void setQuantidade(int quantidade)
	{
		if(quantidade >= 0)
			this.quantidade = quantidade;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(double novoPreco)
	{
		preco = novoPreco;
	}

	public void comprar(double dinheiro, int qtd)
	{
		if(qtd >= 1 && dinheiro >= preco)
		{
			for(int i = 0; i < qtd; i++)
			{
				if(dinheiro >= preco)
				{
					dinheiro -= preco;
					quantidade++;
				}
				else{
					System.out.printf("Dinheiro insuficiente! Só foram comprados %d ingredientes", i);
					break;
				}
			}
		}
		else
			System.out.print("\nError");
	}

	public void comprar(double dinheiro, double gasto)
	{
		if(gasto >= preco && dinheiro >= preco)
		{
			while(gasto >= preco && dinheiro >= preco)
			{
				quantidade++;
				gasto -= preco;
				dinheiro -= preco;
			}
		}
		else
			System.out.print("\nErro, dinheiro insuficiente!");
	}

	public boolean usarIngrediente(int quantidade)
	{
		if(quantidade > this.quantidade)
		{
			return false;
		} 
		else
		{
			this.quantidade -= quantidade;
			return true;
		}
	}
	
	public String toString()
	{
		String msg = null;

		msg = "Nome: " + this.nome + "\nQuantidade: " 
		+ this.quantidade + "\nPreço: R$ " + this.preco + "\n\n";

		return msg;

	}
	
	public boolean equals(Ingrediente i)
	{
		if(i.getNome().toLowerCase().equals(nome.toLowerCase()))
		{
			return true;
		}
		
		return false;
	}


}
