package bases;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
	
	
	private static final long serialVersionUID = -3484117317743927498L;
	Mesa mesaPedinte;
	ArrayList<Prato> pedido;
	
	public Pedido(Mesa mesaPedinte, ArrayList<Prato> pedido)
	{
		this.mesaPedinte = mesaPedinte;
		this.pedido = pedido;
	}
	
	public Mesa getMesa()
	{
		return mesaPedinte;
	}
	
	public ArrayList<Prato> getPedidos()
	{
		return pedido;
	}
	
	public double getLucro()
	{
		double lucro = 0;
		
		for(Prato a: pedido)
		{
			lucro += a.getPreco();
		}
		
		return lucro;
	}
	
	public String toString()
	{
		String msg = "";

		for(Prato p: pedido)
			msg += p.getNome() + "\n";
		
		return msg;

	}

}
