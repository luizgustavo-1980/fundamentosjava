//LuizGustavoMirandaDosSantos TP1 - Fundamentos Java

package br.edu.infnet.app.tp1;

import java.util.Scanner;

public class TP1Java {

	private static String[] aluno;
	private static float[] notaav1;
	private static float[] notaav2;

	private static final int TAMANHO = 10; 		

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
		return (notaav1[indice] + notaav2[indice]) /2;
	}
	
	private static String obterSituacao(float mf){		
		if(mf <= 4) {
			return "Reprovado";
		}
		else if(mf >= 4 && mf <= 7 ) {
			return "Prova Final";
		}
		
		else if(mf >= 7); {
			return "Aprovado";
	}
}
	
	public static void main(String[] args) {
		aluno = new String[TAMANHO];
		notaav1 = new float[TAMANHO];
		notaav2 = new float[TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Lancar Notas");
			System.out.println("[2] Consultar Aluno");
			System.out.println("[3] Consultar Todos");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a opcao desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < TAMANHO) {
					System.out.print("Digite o nome do aluno: ");	
					aluno[pos] = in.next();
		
					System.out.print("Nota da Prova 1: ");	
					notaav1[pos] = in.nextFloat();
					
					System.out.print("Nota da Prova 2: ");	
					notaav2[pos] = in.nextFloat();

					imprimir(pos);

					pos++;
				} else {
					System.out.println("Limite de cadastros atingido!");
				}
				break;

			case "2":
				System.out.print("Digite o código do aluno para pesquisa individual: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					imprimir(id);
				} else {
					System.out.println("O índice ["+id+"] é inválido!");
				}
				break;

			case "3":
				imprimir();
				break;

			case "4":
				System.out.println("Saída");
				break;

			default:
				System.out.println("A opção ["+opcao+"] é inválida");
				break;
			}
		} while (!"4".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!");
		
		in.close();
	}
	
	
}
