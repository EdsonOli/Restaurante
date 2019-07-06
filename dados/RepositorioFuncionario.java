package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import bases.Cargo;
import bases.Funcionario;

public class RepositorioFuncionario implements Serializable, Arquivos
{
	private static ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	//Gestao gerencia = new Gestao();
	
	public ArrayList<Funcionario> getFuncionarios()
	{
		return Funcionarios;
	}
	
	public void adicionarFuncionario(Funcionario f1) {
		//ATUALIZAR LISTA
		lerLista();
		
		Funcionarios.add(f1);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
	}

	public void removerFuncionario(Funcionario f2)
	{
		//ATUALIZAR LISTA
		lerLista();
		
		Funcionarios.remove(f2);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
	}
	
	//METODO PARA GRAVAR FUNCIONARIOS NO ARQUIVO
	public void gravaLista(){
		try{
			FileOutputStream arqG2 = new FileOutputStream("RepositorioFuncionario.dat");
			ObjectOutputStream objG2 = new ObjectOutputStream(arqG2);
			objG2.writeObject(Funcionarios);
			arqG2.flush();
			objG2.flush();
			arqG2.close();
			objG2.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//METODO PARA LER O ARQUIVO DOS FUNCIONARIOS
	public void lerLista(){		
		try {
			FileInputStream arqL2 = new FileInputStream("RepositorioFuncionario.dat");
			ObjectInputStream objL2 = new ObjectInputStream(arqL2);
			Funcionarios = (ArrayList<Funcionario>) objL2.readObject();
			arqL2.close();
			objL2.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
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
