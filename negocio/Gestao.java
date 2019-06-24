package negocio;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import bases.Funcionario;


public class Gestao 
{ 
	/*os comentários sao um metodo alternativo de escrever no arquivo
	
	
	Scanner lerNome = new Scanner(System.in);
	Scanner lerSalario = new Scanner(System.in);
	Scanner lerID = new Scanner(System.in);
	*/
	
	public void CadastrarFuncionario(Funcionario fCadastrar) 
	{
		/*String nomeFuncionarioNovo = lerNome.nextLine();
		double salarioFuncionarioNovo = lerSalario.nextDouble();		
		int idFuncionarioNovo = lerID.nextInt();	*/	
		
		try 
		{
			FileWriter dados = new FileWriter ("Dados dos funcionários.txt");
			PrintWriter registrar = new PrintWriter(dados);
			registrar.println(fCadastrar.toString() + "\n\n");

			dados.close();			
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}
