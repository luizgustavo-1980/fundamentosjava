//LuizGustavoMirandaDosSantos TP1 - Fundamentos Java

package br.edu.infnet.app.tp1;

import java.util.Scanner;

public class TP1Java {

	private static String[] aluno;
//	private static int[] idades;
	private static float[] notaav1;
	private static float[] notaav2;
//	private static float[] descontos;

	private static final int TAMANHO = 2; 		

	private static void imprimir() {		
		for (int i = 0; i < TAMANHO; i++) {
			if(aluno[i] != null) {
				imprimir(i);
			}
		}
	}

	private static void imprimir(int indice) {
		float mediaFinal = calcularMediaFinal(indice);
		
		System.out.println("<"+indice+"> " + 
							aluno[indice] + " * " + 
							notaav1[indice] + " * " + 
							notaav2[indice] + " * " + 
							mediaFinal + " * " +
							obterSituacao(mediaFinal)
							);
	}
	
	private static float calcularMediaFinal(int indice){
		return notaav1[indice] + notaav2[indice];
	}
	
	private static String obterSituacao(float sl){		
		if(sl >= 100000) {
			return "Rico";
		}		
		return "Pobre";
	}

	public static void main(String[] args) {
		nomes = new String[TAMANHO];
		idades = new int[TAMANHO];
		salarios = new float[TAMANHO];
		bonus = new float[TAMANHO];
		descontos = new float[TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar um");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a op��o desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < TAMANHO) {
					System.out.print("Informe o seu nome: ");	
					nomes[pos] = in.next();
	
					System.out.print("Informe a sua idade: ");	
					idades[pos] = in.nextInt();
	
					System.out.print("Informe o seu sal�rio: ");	
					salarios[pos] = in.nextFloat();
					
					System.out.print("Informe o seu b�nus: ");	
					bonus[pos] = in.nextFloat();

					System.out.print("Informe o seu desconto: ");	
					descontos[pos] = in.nextFloat();
					
					imprimir(pos);

					pos++;
				} else {
					System.out.println("Imposs�vel realizar um novo cadastramento!");
				}
				break;

			case "2":
				System.out.print("Informe o funcion�rio para impress�o: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					imprimir(id);
				} else {
					System.out.println("O �ndice ["+id+"] � inv�lido!!!");
				}
				break;

			case "3":
				imprimir();
				break;

			case "4":
				System.out.println("Sa�da");
				break;

			default:
				System.out.println("A op��o ["+opcao+"] inv�lida");
				break;
			}
		} while (!"4".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!!!");
		
		in.close();
	}
	
	
}
