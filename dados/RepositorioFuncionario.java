package dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bases.Funcionario;
import bases.Cargo;
import negocio.Gestao;

public class RepositorioFuncionario 
{
	private static ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	//Gestao gerencia = new Gestao();
	
	public ArrayList<Funcionario> getFuncionarios()
	{
		return Funcionarios;
	}
	
	public void adicionarFuncionario(Funcionario novo) {
		Funcionarios.add(novo);
	}
	
	
	public void removerFuncionario(Funcionario funcionarioR)
	{
		/*boolean Cadastrado = false;
		Funcionario serRemovido = null;
		
		for(Funcionario a: Funcionarios)
		{
			if(funcionarioR.equals(a)) {
				Cadastrado = true;
				serRemovido = a;
			}
		}
		
		if(Cadastrado)
		{
			Funcionarios.remove(serRemovido);
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Funcionário não existe", "Error", JOptionPane.ERROR_MESSAGE);
		}*/
	}
	
	
	public String toString()
	{
		String text = "";
		
		for(Funcionario a: Funcionarios) {
			text += "\nNome: " + a.getNome();
			text += "\nRG: " + a.getID();
			text += "\nCargo: " + a.getCargo().getNome();
			text += "\nSalario: R$" + a.getSalario();
			text += "\n__________________________________________";
		}
		
		return text;
	}
	

}
