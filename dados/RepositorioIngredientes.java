package dados;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import bases.Ingrediente;

public class RepositorioIngrediente implements Serializable, Arquivos
{
	
	private static ArrayList<Ingrediente> repositorioIngrediente = new ArrayList<Ingrediente>();
	
	public RepositorioIngrediente()
	{
		lerLista();
	}
	
	
	public void adicionarIngrediente(Ingrediente a) 
	{
		
		//ATUALIZAR LISTA
		lerLista();
				
		repositorioIngrediente.add(a);
				
		//ATUALIZAR ARQUIVO
		gravaLista();
	}
	
	public void removerIngrediente(int index)
	{
		//ATUALIZAR LISTA
		lerLista();
				
		repositorioIngrediente.remove(index);
				
		//ATUALIZAR ARQUIVO
		gravaLista();
	}
	
	public void aumentarQuant(Ingrediente c, int qtd)
	{
		c.setQuantidade(c.getQuantidade() + qtd);
	}
	
	
	public void diminuirQuant(Ingrediente c, int qtd) 
	{
		c.setQuantidade(c.getQuantidade() - qtd);
	}
	
	
	public ArrayList<Ingrediente> lista()
	{
		return repositorioIngrediente;
	}
	
	public boolean usarIngrediente(String nome, int quantidade)
	{
		for(Ingrediente x: repositorioIngrediente)
		{
			if(x.getNome().toLowerCase().equals(nome.toLowerCase())) {
				x.setQuantidade(x.getQuantidade() - quantidade);
				gravaLista();
				return true;
			}
		}
		return false;
	}
	
	
	public String toString() 
	{
		String text = "";
		
		for(Ingrediente a: repositorioIngrediente) {
			text += "\nNome: " + a.getNome();
			text += "\nQunatidade: " + a.getQuantidade();
			text += "\nPreço Unitário: R$" + a.getPreco();
			text += "\n__________________________________________";
		}
		
		return text;
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
