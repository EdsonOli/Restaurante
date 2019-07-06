package bases;

import java.util.ArrayList;

import dados.TelaCozinheiro;

public class Mesa
{
	private int num;
	private double conta;
	private ArrayList<Integer> diaMes;
	private ArrayList<Integer> horasIni;
	private ArrayList<Integer> horasF;
	private ArrayList<String> nomes;
	
	public Mesa(int num)
	{
		conta = 0;
		nomes = new ArrayList<String>();
		horasIni = new ArrayList<Integer>();
		horasF = new ArrayList<Integer>();
		diaMes = new ArrayList<Integer>();		
	}
	
	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public double getConta() {
		return conta;
	}



	public void setConta(double conta) {
		this.conta = conta;
	}



	public ArrayList<Integer> getDiaMes() {
		return diaMes;
	}



	public void setDiaMes(ArrayList<Integer> diaMes) {
		this.diaMes = diaMes;
	}



	public ArrayList<Integer> getHorasIni() {
		return horasIni;
	}



	public void setHorasIni(ArrayList<Integer> horasIni) {
		this.horasIni = horasIni;
	}



	public ArrayList<Integer> getHorasF() {
		return horasF;
	}



	public void setHorasF(ArrayList<Integer> horasF) {
		this.horasF = horasF;
	}



	public ArrayList<String> getNomes() {
		return nomes;
	}



	public void setNomes(ArrayList<String> nomes) {
		this.nomes = nomes;
	}



	public boolean reservarMesa(int diaR, int horaR, String nomeR)
	{
		if(this.mesaReservada(diaR, horaR))
		{
			System.out.println("nao eh possivel reservar");
			return false;
		}
		
		if(diaR > 30 || horaR > 21)
		{
			System.out.println("o restaurante fecha às 23h, e o tempo de reserva minimo eh de 2h");
			return false; //pois suponhamos q feche às 23h e os meses tenham 30 dias.
		}
		 
		this.diaMes.add(diaR);
		this.horasIni.add(horaR);
		this.horasF.add(horaR+2);
		this.nomes.add(nomeR);
		
		return true;
	}
	
	public boolean mesaReservada(int diaR, int horaR)
	{		
		if(this.horasIni.contains(horaR) && diaMes.get(horasIni.indexOf(horaR)) == diaR)
			return true;
		
		for(int i = 0; i < horasIni.size(); i++)
		{
			if(horaR > horasIni.get(i) && horaR < horasF.get(i) && diaR == diaMes.get(i))
			{
				return true;
			}
		}
		
		
		return false;
	}
	
	public void aumentarTempoReserva(int tempo, String nome)
	{
		boolean teste = false;
		if(nomes.contains(nome))
		{
			int indice = nomes.indexOf(nome);
			if(horasF.get(indice) + tempo <= 23)
			{
				 int t = horasF.get(indice);
				 
				 for(int i = 0; i < tempo; i++)
				 {
					if(horasIni.contains(t + tempo))
						teste = true;
				 }
				 
				 if(teste == false)
				 {
					 horasF.add(indice, t + tempo);
					 System.out.println("tempo aumentado");
				 }
			}
			else
				System.out.println("sem tempo irmao");
		}
		else	
		{
			System.out.println("nao existe reserva nesse nome");
		}
	}
	
	public void pedirPrato(Prato p)
	{
		conta += p.getPreco();
		TelaCozinheiro tela = new TelaCozinheiro();
		tela.addPedido(p.getNome(), "" + this.num);		
	}
	
	public double pedirConta()
	{
		double aux = this.conta;
		this.conta = 0;
		return aux;
	}
	
	

}
