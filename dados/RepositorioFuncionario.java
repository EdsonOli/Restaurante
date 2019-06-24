package dados;

import java.util.ArrayList;
import bases.Funcionario;
import negocio.Gestao;

public class RepositorioFuncionario 
{
	ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	
	public void adicionarFuncionario(Funcionario novoF)
	{
		if(Funcionarios.contains(novoF) == false)
		{
			Funcionarios.add(novoF);
			Gestao gerencia = new Gestao();
			gerencia.CadastrarFuncionario(novoF);
			
		}
		
		else
		{
			//essa parte eh gui tb
			System.out.println("O Fucionario ja existe");
		}
	}
	
	public void removerFuncionario(Funcionario funcionarioR)
	{
		if(Funcionarios.contains(funcionarioR))
		{
			Funcionarios.remove(funcionarioR);
		}
		
		else
		{
			//essa parte eh gui tb
			System.out.println("O Fucionario nao existe");
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
	
	

}
