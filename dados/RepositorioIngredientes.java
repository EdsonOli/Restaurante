package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import bases.Ingrediente;

public class RepositorioIngredientes implements Serializable {
	
	private static ArrayList<Ingrediente> repositorioIngrediente = new ArrayList<Ingrediente>();
	public RepositorioIngredientes() {};
	
	public ArrayList<Ingrediente> getRepositorioIngrediente()
	{
		return repositorioIngrediente;
	}
	
	public void adicionarIngrediente(Ingrediente a) 
	{		
		//ATUALIZAR LISTA
		lerLista();
		
		repositorioIngrediente.add(a);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
		
	}
	
	
	public void removerIngrediente(Ingrediente b)
	{
		//ATUALIZAR LISTA
		lerLista();
		
		repositorioIngrediente.remove(b);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
		
	}
	
	
	public void aumentarQuant(Ingrediente c, int qtd)
	{
		try {
			for(int i = 0; i<repositorioIngrediente.size(); i++)
			{
				if(repositorioIngrediente.get(i).equals(c))
				{
					repositorioIngrediente.get(i).setQuantidade(repositorioIngrediente.get(i).getQuantidade() + qtd);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void diminuirQuant(Ingrediente c, int qtd) 
	{
		try {
			for(int i = 0; i<repositorioIngrediente.size(); i++)
			{
				if(repositorioIngrediente.get(i).equals(c))
				{
					repositorioIngrediente.get(i).setQuantidade(repositorioIngrediente.get(i).getQuantidade() - qtd);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public String toString() 
	{
		String msg = null;
		msg = "*LISTA DE INGREDIENTES*\n\n";
		
		for(int i = 0; i<this.repositorioIngrediente.size(); i++) 
		{
			
			msg += "INGREDIENTE " + (i+1) + "\n";
			msg += "" + this.repositorioIngrediente.get(i) + "\n";
		}
		
		return msg;
	}
	
	
	//METODO PARA GRAVAR OBJETOS NO ARQUIVO
	public void gravaLista() 
	{
		try 
		{
				FileOutputStream arqG = new FileOutputStream("RepositorioIngrediente.dat");
				ObjectOutputStream objG = new ObjectOutputStream(arqG);
				objG.writeObject(repositorioIngrediente);
				objG.flush();
				objG.close();
				arqG.flush();
				arqG.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//METODO PARA LER OBJETOS NO ARQUIVO
	public void lerLista() 
	{
		try 
		{
			FileInputStream arqL = new FileInputStream("RepositorioIngrediente.dat");
			ObjectInputStream objL = new ObjectInputStream(arqL);
			repositorioIngrediente = (ArrayList<Ingrediente>) objL.readObject();
			objL.close();
			arqL.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();;
		}
	}
}
