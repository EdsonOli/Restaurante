package negocio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import dados.RepositorioFuncionario;
import bases.Cargo;
import bases.Funcionario;
import java.util.Scanner;

import javax.swing.JOptionPane;

import bases.Funcionario;


public class Gestao 
{ 
	/*os comentários sao um metodo alternativo de escrever no arquivo
	
	
	Scanner lerNome = new Scanner(System.in);
	Scanner lerSalario = new Scanner(System.in);
	Scanner lerID = new Scanner(System.in);
	*/
	RepositorioFuncionario repFunc;
	
	public Gestao() {
		repFunc = new RepositorioFuncionario();
	}
	
	public String ListaFuncionarios() {
		return repFunc.toString();
	}
	
	public void CadastrarFuncionario(String nome, int RG, Cargo cargo) 
	{
		Funcionario novoF = new Funcionario(nome, RG, cargo);
		boolean jaCadastrado = false;
		
		for(Funcionario a: repFunc.getFuncionarios())
		{
			if(novoF.equals(a))
				jaCadastrado = true;
		}
		
		if(!jaCadastrado)
		{
			try 
			{
				FileWriter dados = new FileWriter ("Dados dos funcionários.txt");
				PrintWriter registrar = new PrintWriter(dados);
				registrar.println(novoF.toString() + "\n\n");
				dados.close();
				
				repFunc.adicionarFuncionario(novoF);
				JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			}
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Funcionario já está cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public Funcionario buscaFuncionario(String nomeB)
	{
		for(int i = 0; i < repFunc.getFuncionarios().size(); i++)
		{
			if(repFunc.getFuncionarios().get(i).getNome() == nomeB)
			{
				return repFunc.getFuncionarios().get(i);
			}
		}
		
		return null;
	}
	
	public Funcionario buscaFuncionario(int RG)
	{
		for(Funcionario a: repFunc.getFuncionarios())
		{
			if(a.getID() == RG)
			{
				return a;
			}
		}
		
		return null;
	}
	
	public String FiltroSalarial(double min, double max)
	{
		String text = "";
		
		for(Funcionario x: repFunc.getFuncionarios())
		{
			if(x.getSalario() >= min && x.getSalario() <= max) 
			{
				text += "\nNome: " + x.getNome();
				text += "\nRG: " + x.getID();
				text += "\nCargo: " + x.getCargo().getNome();
				text += "\nSalario: R$" + x.getSalario();
				text += "\n__________________________________________";
			}
		}
		
		return text;
	}
	
	public String FiltroCargo(Cargo cargo) 
	{
		String text = "";
		
		for(Funcionario x: repFunc.getFuncionarios())
		{
			if(x.getCargo().getNome().equals(cargo.getNome())) 
			{
				text += "\nNome: " + x.getNome();
				text += "\nRG: " + x.getID();
				text += "\nCargo: " + x.getCargo().getNome();
				text += "\nSalario: R$" + x.getSalario();
				text += "\n__________________________________________";
			}
		}
		
		return text;
	}

}
