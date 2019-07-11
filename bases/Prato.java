package bases;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Prato implements Serializable{
	
	private static final long serialVersionUID = -9186525899934373880L;
	private String nome;
	private double preco;
	private ArrayList<Ingrediente> ingredientesNecessarios;

	public Prato(String nome, double preco, ArrayList<Ingrediente> ingredientesNescessarios)
	{
		this.nome = nome;
		this.preco = preco;
		this.ingredientesNecessarios = ingredientesNescessarios;
	}
	public Prato(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	

	public String getNome()
	{
		return nome;
	}

	public double getPreco()
	{
		return preco;
	}

	public ArrayList<Ingrediente> getIngredientesNecessarios()
	{
		return ingredientesNecessarios;
	}
	
	public void setPreco(int novoPreco)
	{
		preco = novoPreco;
	}
	
	
	public boolean ingredientesNecessarios(ArrayList<Ingrediente> ing) 
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
			JOptionPane.showMessageDialog(null, "Não há ingredientes suficientes para fazer a receita!", "Oh no", JOptionPane.ERROR_MESSAGE);
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
				a.comprar(999999999, qtd);
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
	
	public String toString () 
	{
		ArrayList<String> nomesIng = new ArrayList<String>();
		String msg = null;
		
		for(int i = 0; i<this.ingredientesNecessarios.size(); i++) 
		{
			String lala = this.ingredientesNecessarios.get(i).getNome();
			
			nomesIng.add(lala);
		}
		
		msg = " Nome: " + this.getNome() + "\n Preço: " + this.getPreco() + "\n Ingredientes: " + nomesIng + "\n";
		
		return msg;
	}
	
	public boolean equals(Prato p)
	{
		if(nome.toLowerCase().equals(p.getNome().toLowerCase()))
		{
			return true;
		}
		
		return false;
	}
	
}
