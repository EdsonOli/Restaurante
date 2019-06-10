package bases;

public class Funcionario
{
	private String nome;
	private int ID;
	private double salario;
	private Cargo cargo;
	
	public Funcionario(String nome, int ID, Cargo cargo) {
		super();
		this.nome = nome;
		this.ID = ID;
		this.salario = cargo.getSalarioPadrao();
		this.cargo = cargo;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getSalario() {
		return salario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void darAumento(double prom)
	{
		salario += prom;
	}
	
	public void diminuirSalario(double menos) 
	{
		if(menos > 0 && salario - menos >= cargo.getSalarioPadrao())
		{
			salario -= menos;
		}
	}
	
	public void mudarCargo(Cargo nCargo) {
		if(cargo.getNome().equals(nCargo.getNome()))
		{
			cargo = nCargo;
			salario = nCargo.getSalarioPadrao();
		}
	}
	
	public String toString()
	{
		String text = "";
		text += "\nNome: " + nome;
		text += "\nID: " + ID;
		text += "\nSalario: R$" + salario;
		text += "\nCargo: " + cargo.getNome();
		
		return text;
	}
	
	
	
}