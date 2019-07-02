package dados;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class RepositorioFuncionario implements Serializable, Arquivos
{
	private static ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
	//Gestao gerencia = new Gestao();
	
	public ArrayList<Funcionario> getFuncionarios()
	{
		return Funcionarios;
	}
	
	public void adicionarFuncionario(String nome, int rg, Cargo cargo) {
		Funcionarios.add(new Funcionario(nome, rg, cargo));
	}

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

		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void lerLista(){		
		try {
			FileInputStream arqL2 = new FileInputStream("RepositorioFuncionario.dat");
			ObjectInputStream objL2 = new ObjectInputStream(arqL2);
			Funcionarios = (ArrayList<Funcionario>) objL2.readObject();
			arqL2.close();
			objL2.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	//marco: nao vi essa parte aq pq for each n eh cmg
	
	/*public void removerFuncionario(Funcionario funcionarioR)
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
	}*/
	
	
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
