package jogoExemplo;

import java.util.Scanner;

public class Computador extends Jogador{ 
	public static Scanner entrada; 
	public Computador(int jogador){ //metodo que cria um jogador computador
		super(jogador); 
		
		System.out.println("Jogador 'Computador' criado!"); }

	@Override
	public void jogar(Tabuleiro tabuleiro){
	Tentativa(tabuleiro); tabuleiro.setPosicao(tentativa, jogador); 
	}

	@Override
	public void Tentativa(Tabuleiro tabuleiro){  //metodo herdado da classe jogador
	
		do{ 
			do{ 
				tentativa[0] =(int)(Math.random()*9); //armazena linha de forma randonica
		
				if(tentativa[0] > 3 || tentativa[0] < 1) //verifica se a linha gerada está dentro do intervalo disponível de 1 a 3
					System.out.print("opcao linha invalida ");
			}
			
			while(tentativa[0] > 3 || tentativa[0] < 1) ; //executa a geração randonica de linha enquanto estiver dentro dos valores 1 e 3
				do{ 
					tentativa[1] = (int)(Math.random()*9);
					if(tentativa[1] > 4 || tentativa[1] < 1)  //verifica se a coluna gerada está dentro do intervalo disponível de 1 a 3
						System.out.print("opcao coluna invalida ");
				}
			
			while(tentativa[1] > 3 || tentativa[1] < 1); //executa a geração randonica de coluna enquanto estiver dentro dos valores 1 e 3

				tentativa[0]--;
				tentativa[1]--;

				if(checaTentativa(tentativa, tabuleiro)) //se a opção informada já foi marcada
					System.out.print("aqui ");
		}
		
		while(!checaTentativa(tentativa, tabuleiro) ); 
	}

}
