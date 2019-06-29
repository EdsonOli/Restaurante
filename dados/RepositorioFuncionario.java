package dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import bases.Funcionario;
import bases.Cargo;
import negocio.Gestao;

public class RepositorioFuncionario 
{
	private static ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	Gestao gerencia = new Gestao();
	
	public void adicionarFuncionario(String nome, int RG, Cargo cargo)
	{
		Funcionario novoF = new Funcionario(nome, RG, cargo);
		boolean jaCadastrado = false;
		
		for(Funcionario a: Funcionarios)
		{
			if(novoF.equals(a))
				jaCadastrado = true;
		}
		
		if(!jaCadastrado)
		{
			Funcionarios.add(novoF);
			gerencia.CadastrarFuncionario(novoF);
			JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Funcionario já está cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void removerFuncionario(Funcionario funcionarioR)
	{
		boolean Cadastrado = false;
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
		}
	}
	
	public Funcionario bucasFuncionario(String nomeB)
	{
		for(int i = 0; i < Funcionarios.size(); i++)
		{
			if(Funcionarios.get(i).getNome() == nomeB)
			{
				return Funcionarios.get(i);
			}
		}
		
		return null;
	}
	
	public Funcionario buscaFuncionario(int RG)
	{
		for(Funcionario a: Funcionarios)
		{
			if(a.getID() == RG)
			{
				return a;
			}
		}
		
		return null;
	}
	
	public String toString()
	{
		String text = "-------------------------------------------------------------";
		
		for(Funcionario a: Funcionarios) {
			text += "\nNome: " + a.getNome();
			text += "\nRG: " + a.getID();
			text += "\nCargo: " + a.getCargo().getNome();
			text += "\n-------------------------------------------------------------";
		}
		
		return text;
	}
	

}
