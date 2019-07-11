package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import bases.Pedido;

public class RepositorioPedido implements Serializable, Arquivos {

private static ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
	
	public RepositorioPedido() {
		lerLista();
	}
	
	public ArrayList<Pedido> getPedidos()
	{
		return Pedidos;
	}
	
	
	public void adicionarPedido(Pedido p1) {
		
		//ATUALIZAR LISTA
		lerLista();
		
		Pedidos.add(p1);
		
		//ATUALIZAR AQUIVO
		gravaLista();
	}
	
	public void removerPedido(int p1) {
		
		//ATUALIZAR LISTA
		lerLista();
		
		Pedidos.remove(p1);
		
		//ATUALIZAR ARQUIVO
		gravaLista();
	}
	
	//METODO PARA GRAVAR PRATOS NO ARQUIVO
		public void gravaLista() 
		{
			try 
			{
					FileOutputStream arqG = new FileOutputStream("Pedidos.dat");
					ObjectOutputStream objG = new ObjectOutputStream(arqG);
					objG.writeObject(Pedidos);
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
				FileInputStream arqL = new FileInputStream("Pedidos.dat");
				ObjectInputStream objL = new ObjectInputStream(arqL);
				Pedidos = (ArrayList<Pedido>) objL.readObject();
				objL.close();
				arqL.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();;
			}
		}
		

}
