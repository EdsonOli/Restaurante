package dados;
import java.io.File;
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
	
	
	public void adicionarIngrediente(Ingrediente a) 
	{
		repositorioIngrediente.add(a);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
		lerLista();
	}
	
	
	public void removerIngrediente(Ingrediente b)
	{
		repositorioIngrediente.remove(b);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
		lerLista();
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
