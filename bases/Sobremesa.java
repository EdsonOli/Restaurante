package bases;

import java.util.ArrayList;

public class Sobremesa extends Prato{

	private String porcao;
	
	public Sobremesa(String nome, double preco, ArrayList<Ingrediente> ingredientes, String porcao) {
		super(nome, preco, ingredientes);
		this.porcao = porcao;
	}
	
	
	public String getPorcao(){
		return this.porcao;
	}
	public void setPorcao(String porcao) {
		this.porcao = porcao;
	}
	
	//TODOS OS METODOS IGUAIS AOS DA SUPER CLASSE//
	
	//@override
	public String toString() {
		
		ArrayList<String> nomesIng = new ArrayList<String>();
		String msg = null;
		
		for(int i = 0; i<this.getIngredientesNecessarios().size(); i++) 
		{
			String lala = this.getIngredientesNecessarios().get(i).getNome();
			
			nomesIng.add(lala);
		}
		
		msg = " Nome: " + this.getNome() + "\n Preço: " + this.getPreco() + "\n Ingredientes: "
				+ nomesIng + "\n Porção: " + this.getPorcao() + "\n";
		
		return msg;
	}
}
