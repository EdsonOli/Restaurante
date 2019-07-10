package dados;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import bases.Mesa;
import bases.Prato;

public class RepositorioMesas implements Arquivos, Serializable
{
	private static ArrayList<Mesa> mesas = new ArrayList<Mesa>();

	public static ArrayList<Mesa> getMesas() {
		return mesas;
	}

	//METODO PARA GRAVAR PRATOS NO ARQUIVO
	public void gravaLista() 
	{
		try 
		{
				FileOutputStream arqS = new FileOutputStream("RepositorioMesas.dat");
				ObjectOutputStream objS = new ObjectOutputStream(arqS);
				objS.writeObject(mesas);
				objS.flush();
				objS.close();
				arqS.flush();
				arqS.close();
			
			System.out.println("LIDO");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void lerLista() 
	{
		try 
		{
			FileInputStream arqS = new FileInputStream("RepositorioMesas.dat");
			ObjectInputStream objS = new ObjectInputStream(arqS);
			mesas = (ArrayList<Mesa>) objS.readObject();
			objS.close();
			arqS.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();;
		}
	}
	
	public void addMesa(int numb)
	{
		this.lerLista();
		boolean existe = false;
		for(int i = 0; i < mesas.size(); i++)
		{
			if(mesas.get(i).getNum() == numb)
			{
				System.out.println("mesa ja existe");
				existe = true;
			}
		}
		
		if(existe == false)
		{
			mesas.add(new Mesa(numb));
		}
			
		this.gravaLista();
	}
	
	public void removerMesa(int numb)
	{
		this.lerLista();
		boolean existe = false;
		for(int i = 0; i < mesas.size(); i++)
		{
			if(mesas.get(i).getNum() == numb)
			{
				existe = true;
				mesas.remove(i);
			}
		}
		
		if(existe == false)
		{
			System.out.println("mesa nao existe");
		}
			
		this.gravaLista();
	}

	
	
	
	

}
