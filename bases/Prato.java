package bases;

import java.util.ArrayList;

public class Prato {
	private String nome;
	private double preco;
	private ArrayList<Ingrediente> ingredientesNecessarios;

	public Prato(String nome, double preco, ArrayList<Ingrediente> ingredientesNescessarios)
	{
		this.nome = nome;
		this.preco = preco;
		this.ingredientesNecessarios = ingredientesNescessarios;
	}

	public String getNome()
	{
		return nome;
	}

	public double getPreco()
	{
		return preco;
	}

	public void setPreco(int novoPreco)
	{
		preco = novoPreco;
	}
	
	private boolean ingredientesNecessarios(ArrayList<Ingrediente> ing) 
	{
		boolean achou;
		for(Ingrediente a: ingredientesNecessarios) 
		{
			achou = false;
			
			for(Ingrediente b: ing) 
			{
				if( a.getNome().equals(b.getNome()) ) 
				{
					if(a.getQuantidade() > b.getQuantidade()) {
						return false;
					} else {
						achou = true;
						break;
					}
				}
				
			}
			
			if(!achou) 
			{
				return false;
			}
			
		}
		return true;
	}
	
	
	public void fazerPrato(ArrayList<Ingrediente> ing) 
	{
		if(ingredientesNecessarios(ing))
		{
			for(Ingrediente a: ingredientesNecessarios) 
			{
				
				for(Ingrediente b: ing) 
				{
					if( a.getNome().equals(b.getNome()) ) 
					{
						b.usarIngrediente(a.getQuantidade());
						break;
					}
				}
				
			}
		}
		else
		{
			//Não há ingredientes suficientes
		}
	}
	
	public void diminuirQtdIng(String nome, int qtd) 
	{
		for(Ingrediente a: ingredientesNecessarios)
		{
			if(a.getNome().equals(nome))
			{
				if(a.getQuantidade() < qtd) {
					a.usarIngrediente(qtd);
				}
			}
		}
	}
	
	public void aumentarQtdIng(String nome, int qtd) 
	{
		for(Ingrediente a: ingredientesNecessarios)
		{
			if(a.getNome().equals(nome))
			{
				a.comprarPorQuantidade(999999999, qtd);
			}
		}
	}
	
	public void removerIngrediente(String nome) 
	{
		Ingrediente x = null;
		for(Ingrediente a: ingredientesNecessarios)
		{
			if(a.getNome().equals(nome))
			{
				x = a;
				break;
			}
		}
		
		if(x != null) 
		{
			ingredientesNecessarios.remove(x);
		}
		
	}
	
	public void adicionarIngrediente(String nome, ArrayList<Ingrediente> rep)
	{
		Ingrediente x = null;
		for(Ingrediente a: rep) 
		{
			if(a.getNome().equals(nome)) 
			{
				x = a;
				break;
			}
		}
		
		if(x != null)
		{
			boolean jaExiste = false;
			for(Ingrediente b: ingredientesNecessarios)
			{
				if(b.getNome().equals(nome))
				{
					jaExiste = true;
					break;
				}
			}
			
			if(!jaExiste) 
			{
				ingredientesNecessarios.add(x);
			}
			
		}
		
		
	}
	
	
}