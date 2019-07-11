package negocio;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import dados.RepositorioFuncionario;
import dados.RepositorioIngrediente;
import dados.RepositorioPedido;
import dados.RepositorioPratos;
import bases.Bebida;
import bases.Cargo;
import bases.Funcionario;
import bases.Ingrediente;
import bases.Mesa;
import bases.Pedido;
import bases.Prato;
import bases.PratoPrincipal;
import bases.Sobremesa;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Gestao implements Serializable
{ 
	
	private double CapitalRestaurante = 7200;
	private RepositorioFuncionario repFunc;
	private RepositorioIngrediente repIng;
	private RepositorioPratos repPrat;
	private RepositorioPedido repPed;
	
	public Gestao() {
		repFunc = new RepositorioFuncionario();
		repIng = new RepositorioIngrediente();
		repPrat = new RepositorioPratos();
		repPed = new RepositorioPedido();
		lerLista();
	}
	
	public double getCapital()
	{
		return CapitalRestaurante;
	}
	
	public void diminuirCapital(double dim)
	{
		CapitalRestaurante -= dim;
	}
	
	public String ListaFuncionarios() {
		return repFunc.toString();
	}
	
	public String ListaIngredientes() {
		return repIng.toString();
	}
	
	public String ListaPratos() {
		return repPrat.toString();
	}
	
	public void CadastrarFuncionario(String nome, int RG, Cargo cargo) 
	{
		Funcionario novoF = new Funcionario(nome, RG, cargo);
		boolean jaCadastrado = false;
		
		for(Funcionario a: repFunc.getFuncionarios())
		{
			if(novoF.equals(a)) {
				jaCadastrado = true;
				break;
			}
		}
		
		if(!jaCadastrado)
		{
			try 
			{				
				repFunc.adicionarFuncionario(novoF);
				JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			}
			
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		}
		
		else
		{
			JOptionPane.showMessageDialog(null, "Funcionario já está cadastrado", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void RemoverFuncionario(String nome, int RG, Cargo cargo)
	{
		Funcionario rem = new Funcionario(nome, RG, cargo);
		int objeto = -1;
		
		for(Funcionario i: repFunc.getFuncionarios())
		{
			if(i.equals(rem)) 
			{
				objeto = repFunc.getFuncionarios().indexOf(i);
				break;
			}
		}
		
		if(objeto != -1)
		{
			repFunc.removerFuncionario(objeto);
			JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso", "Remoção concluída", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Funcionario não foi encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
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
	
	public void AumentarSalario(int RG, double qtd)
	{
		Funcionario encontrado = buscaFuncionario(RG);
		if(encontrado != null) {
			for(Funcionario x: repFunc.getFuncionarios())
			{
				if(x.equals(encontrado))
				{
					x.darAumento(qtd);
					repFunc.gravaLista();
					JOptionPane.showMessageDialog(null, "Aumento realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erro ao aumentar o salario", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void DiminuirSalario(int RG, double qtd)
	{
		Funcionario encontrado = buscaFuncionario(RG);
		if(encontrado != null) {
			for(Funcionario x: repFunc.getFuncionarios())
			{
				if(x.equals(encontrado))
				{
					if(x.diminuirSalario(qtd)) {
						repFunc.gravaLista();
						JOptionPane.showMessageDialog(null, "Redução realizada com sucesso!", "Sucesso para a empresa", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "O salario atual não pode ser menor que o inicial", "Erro ao diminuir o salario", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erro ao diminuir o salario", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void alterarCargo(int RG, Cargo novoCargo)
	{
		Funcionario encontrado = buscaFuncionario(RG);
		if(encontrado != null) {
			for(Funcionario x: repFunc.getFuncionarios())
			{
				if(x.equals(encontrado))
				{
					x.mudarCargo(novoCargo);
					repFunc.gravaLista();
					JOptionPane.showMessageDialog(null, "Cargo alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Erro ao alterar o cargo", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Prato buscaPrato(String nome)
	{
		for(Prato a: repPrat.listaPratos())
		{
			if(a.getNome().toLowerCase().equals(nome.toLowerCase()))
			{
				return a;
			}
		}
		
		return null;
	}
	
	public void alterarPrato(String nome, String tipo, double preco)
	{
		for(Prato a: repPrat.listaPratos())
		{
			if(a.getNome().toLowerCase().equals(nome.toLowerCase()))
			{
				switch(tipo) {
				case "Bebida":
					a = new Bebida(nome, preco, 10, "");
					JOptionPane.showMessageDialog(null, "Alteração Concluida!");
					break;
				case "Prato Principal":
					a = new PratoPrincipal(nome, preco, null);
					JOptionPane.showMessageDialog(null, "Alteração Concluida!");
					break;
				case "Sobremesa":
					a = new Sobremesa(nome, preco, null, null);
					JOptionPane.showMessageDialog(null, "Alteração Concluida!");
					break;
				}
				repPrat.gravaLista();
				break;
			}
		}
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
	
	public double todosOsSalarios()
	{
		double total = 0;
		
		for(Funcionario f: repFunc.getFuncionarios())
		{
			total += f.getSalario();
		}
		
		return total;
	}
	
	public void CadastrarIngrediente(String nomeIng, int qtdIng, double precoIng)
	{
		Ingrediente novoIng = new Ingrediente(nomeIng, qtdIng, precoIng);
		boolean jaCadastrado = false;
		
		for(Ingrediente i: repIng.lista())
		{
			if(i.equals(novoIng)) 
			{
				jaCadastrado = true;
				break;
			}
		}
		
		if(!jaCadastrado)
		{
			repIng.adicionarIngrediente(novoIng);
		} else {
			JOptionPane.showMessageDialog(null, "Este ingrediente já está cadastrado", "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void RemoverIngrediente(String nomeIng)
	{
		Ingrediente rem = new Ingrediente(nomeIng, 1, 1);
		int objeto = -1;
		
		for(Ingrediente i: repIng.lista())
		{
			if(i.equals(rem)) 
			{
				objeto = repIng.lista().indexOf(i);
				break;
			}
		}
		
		if(objeto != -1)
		{
			repIng.removerIngrediente(objeto);
			JOptionPane.showMessageDialog(null, "Ingrediente removido com sucesso", "Remoção concluída", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Ingrediente não foi encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void CadastrarPrato(String nome, double preco, ArrayList<Ingrediente> ingNec, String tipo)
	{
		boolean jaCadastrado = false;
		for(Prato p: repPrat.listaPratos())
		{
			if(nome.toLowerCase().equals(p.getNome().toLowerCase())) {
				jaCadastrado = true;
				break;
			}
		}
		
		if(!jaCadastrado)
		{
			switch(tipo)
			{
			case "Prato Principal":
				PratoPrincipal novo = new PratoPrincipal(nome, preco, ingNec);
				repPrat.adicionarPrato(novo);
				break;
			case "Bebida":
				Bebida novo1 = new Bebida(nome, preco, 0, "");
				repPrat.adicionarPrato(novo1);
				break;
			case "Sobremesa":
				Sobremesa novo2 = new Sobremesa(nome, preco, ingNec, "");
				repPrat.adicionarPrato(novo2);
				break;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Esse prato já está cadastrado", "Oh no", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void RemoverPrato(String nome, String type)
	{
		Prato plate = null;
		switch(type)
		{
		case "Prato Principal":
			plate = new PratoPrincipal(nome, 0, null);
			break;
		case "Sobremesa":
			plate = new Sobremesa(nome, 0, null, "");
			break;
		case "Bebida":
			plate = new Bebida(nome, 0, 0, "");
			break;
		}
		
		int objeto = -1;
		
		for(Prato i: repPrat.listaPratos())
		{
			if(i.equals(plate)) 
			{
				if(i instanceof Bebida && plate instanceof Bebida)
				{
					objeto = repPrat.listaPratos().indexOf(i);
					break;
				}
				else if(i instanceof PratoPrincipal && plate instanceof PratoPrincipal)
				{
					objeto = repPrat.listaPratos().indexOf(i);
					break;
				}
				else if(i instanceof Sobremesa && plate instanceof Sobremesa)
				{
					objeto = repPrat.listaPratos().indexOf(i);
					break;
				}
			}
		}
		
		if(objeto != -1)
		{
			repPrat.removerPrato(objeto);
			JOptionPane.showMessageDialog(null, "Prato removido com sucesso", "Remoção concluída", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Prato não foi encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Prato encontrarPrato(String nome)
	{
		ArrayList<Prato> total = repPrat.listaPratos();
		for(Prato p: total)
		{
			if(nome.toLowerCase().equals(p.getNome().toLowerCase()))
			{
				return p;
			}
		}
		return null;
	}
	
	public Ingrediente encontrarIngrediente(String nome)
	{
		ArrayList<Ingrediente> total = repIng.lista();
		for(Ingrediente i: total)
		{
			if(nome.toLowerCase().equals(i.getNome().toLowerCase()))
			{
				return i;
			}
		}
		return null;
	}
	
	public void fazerPedido(Mesa m, ArrayList<Prato> lista) {
		Pedido novo = new Pedido(m , lista);
		repPed.adicionarPedido(novo);
		
	}
	
	public void concluirPedido(Pedido p1)
	{
		ArrayList<Ingrediente> listaDoPedido = new ArrayList<Ingrediente>();
		for(Prato a: p1.getPedidos())
		{
			if(a instanceof Bebida){}
			else
			{
				listaDoPedido.addAll(a.getIngredientesNecessarios());
			}
		}
		
		Prato novo = new PratoPrincipal("Random", 0, listaDoPedido);
		
		if(novo.ingredientesNecessarios(repIng.lista()))
		{
			for(Ingrediente a: novo.getIngredientesNecessarios())
			{
				repIng.usarIngrediente(a.getNome(), a.getQuantidade());
			}
			CapitalRestaurante += p1.getLucro();
			gravaLista();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Não há ingredientes suficientes", "Oh no", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cancelarPedido(int index)
	{
		repPed.removerPedido(index);
	}
	
	public ArrayList<Pedido> pegarPedidos()
	{
		return repPed.getPedidos();
	}
	
	//METODO PARA GRAVAR OBJETOS NO ARQUIVO
		public void gravaLista() 
		{
			try 
			{
					FileWriter arqG = new FileWriter("Capital.txt");
					PrintWriter objG = new PrintWriter(arqG);
					objG.print("" + CapitalRestaurante);
					objG.flush();
					objG.close();
					arqG.flush();
					arqG.close();
				
				System.out.println("LIDO");
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		
		//METODO PARA LER OBJETOS NO ARQUIVO
		public void lerLista() 
		{
			try 
			{
				FileInputStream arqL = new FileInputStream("Capital.txt");
				InputStreamReader objL = new InputStreamReader(arqL);
				BufferedReader BR = new BufferedReader(objL);
				CapitalRestaurante = Double.parseDouble(BR.readLine());
				objL.close();
				arqL.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();;
			}
		}

}
