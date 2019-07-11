package bases;

import java.io.Serializable;
import java.util.ArrayList;

public class PratoPrincipal extends Prato implements Serializable{

	
	private static final long serialVersionUID = 3027438607210816376L;

	public PratoPrincipal(String nome, double preco, ArrayList<Ingrediente> ingredientes) {
		super(nome, preco, ingredientes);
	}
	
	
	//TODOS OS METODOS SERÃO IGUAS AOS DA SUPER CLASSE//
	
	
	
	
}
