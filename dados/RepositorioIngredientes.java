package dados;
import java.util.ArrayList;
import bases.Ingrediente;

public class RepositorioIngredientes {
	
	private static ArrayList<Ingrediente> repositorioIngrediente = new ArrayList<Ingrediente>();
	
	
	public void adicionarIngrediente(Ingrediente a) 
	{
		repositorioIngrediente.add(a);
	}
	
	public void removerIngrediente(String nome)
	{
		for(Ingrediente i: repositorioIngrediente)
		{
			if(i.getNome().equals(nome)) 
			{
				repositorioIngrediente.remove(i);
				break;
			}
		}
	}
	
	public ArrayList<Ingrediente> lista()
	{
		return repositorioIngrediente;
	}
}
