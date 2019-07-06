package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import bases.Ingrediente;
import bases.Prato;

public class RepositorioPratos implements Serializable, Arquivos{
	
	private static ArrayList<Prato> repositorioPrato = new ArrayList<Prato>();
	
	public RepositorioPratos() {}
	
	
	public void adicionarPrato(Prato p1) {
		
		//ATUALIZAR LISTA
		lerLista();
		
		repositorioPrato.add(p1);
		
		//ATUALIZAR AQUIVO
		gravaLista();
	}
	
	public void removerPrato(Prato p1) {
		
		//ATUALIZAR LISTA
		lerLista();
		
		repositorioPrato.remove(p1);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
	}
	
	//METODO PARA GRAVAR PRATOS NO ARQUIVO
		public void gravaLista() 
		{
			try 
			{
					FileOutputStream arqG = new FileOutputStream("RepositorioPratos.dat");
					ObjectOutputStream objG = new ObjectOutputStream(arqG);
					objG.writeObject(repositorioPrato);
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
		
		
		//METODO PARA LER PRATOS DO ARQUIVO
		public void lerLista() 
		{
			try 
			{
				FileInputStream arqL = new FileInputStream("RepositorioPratos.dat");
				ObjectInputStream objL = new ObjectInputStream(arqL);
				repositorioPrato = (ArrayList<Prato>) objL.readObject();
				objL.close();
				arqL.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();;
			}
		}
		
		public String toString() {
			
			String msg = null;
			msg = "*LISTA DE PRATOS*\n\n";
			
			for(int i = 0; i<repositorioPrato.size(); i++) 
			{
				msg += "PRATO " + (i+1) + "\n";
				msg += "" + this.repositorioPrato.get(i) + "\n";
			}
			
			return msg;
		}
}