package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class TelaCozinheiro implements Serializable, Arquivos{
	
	private static ArrayList<String> pedidos = new ArrayList<String>();

	public static ArrayList<String> getPedidos() {
		return pedidos;
	}
	
	public void addPedido(String prato, String num_mesa)
	{
		String text = "";
		text += "\nprato: " + prato;
		text += "\nmesa: " + num_mesa;
		
		pedidos.add(text);
		
		gravaLista();
	}
	
	public void encerrarPedido(String prato, String num_mesa)
	{
		String text = "";
		text += "\nprato: " + prato;
		text += "\nmesa: " + num_mesa;
		
		if(pedidos.contains(text))
			pedidos.remove(text);
		
		else
			System.out.println("pedido nao encontrado");
	}

	public void gravaLista(){
		try{
			FileOutputStream arqP = new FileOutputStream("Pedidos em andamento.dat");
			ObjectOutputStream objP = new ObjectOutputStream(arqP);
			objP.writeObject(pedidos);
			arqP.flush();
			objP.flush();
			arqP.close();
			objP.close();
		}

		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void lerLista(){		
		try {
			FileInputStream arqP2 = new FileInputStream("Pedidos em andamento.dat");
			ObjectInputStream objP2 = new ObjectInputStream(arqP2);
			pedidos = (ArrayList<String>) objP2.readObject();
			arqP2.close();
			objP2.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
