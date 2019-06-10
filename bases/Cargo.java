package bases;

public enum Cargo {
	GARCOM("Garçom", 1000),
	COZINHEIRO("Cozinheiro", 1000),
	GERENTE("Gerente", 1000),
	LIMPEZA("Limpeza", 1000);
	
	private String nome;
	private double salarioPadrao;
	
	private Cargo(String nome, double salarioPadrao) {
		this.nome = nome;
		this.salarioPadrao = salarioPadrao;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public double getSalarioPadrao()
	{
		return salarioPadrao;
	}
}
