package bases;

import java.util.ArrayList;

public class Sobremesa extends Prato{

	private int porcao;
	
	public Sobremesa(String nome, double preco, ArrayList<Ingrediente> ingredientes, int porcao) {
		super(nome, preco, ingredientes);
		this.porcao = porcao;
	}
	
	
	public int getPorcao(){
		return this.porcao;
	}
	public void setPorcao(int quant) {
		this.porcao = quant;
	}
	
	//TODOS OS METODOS IGUAIS AOS DA SUPER CLASSE//
	
	public void aumentarPorcao(int quant) {
		setPorcao(this.getPorcao() + quant);
	}
	public void diminuirPorcao(int quant) {
		setPorcao(this.getPorcao() - quant);
	}
	
	
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
