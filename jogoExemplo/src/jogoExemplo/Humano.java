package jogoExemplo;

import java.util.Scanner;

public class Humano extends Jogador{
    public Scanner entrada = new Scanner(System.in);
    
    public Humano(int jogador){ //metodo que cria um jogador humano
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Humano' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){ //metodo herdado da classe jogador
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador); //seta a posicao no tabuleiro passando o numero da tentativa e qual jogador a fez
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){ //metodo herdado da classe jogador
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = entrada.nextInt(); //armazena linha informada na tentativa da rodada
                
                if(tentativa[0] > 3 || tentativa[0] < 1) //retorna mensagem de erro caso informe uma linha invalida
                    System.out.println("Linha inválida. ? 1, 2 ou 3");
                 
            } while(tentativa[0] > 3 || tentativa[0] < 1); //executa a repetição de informa linha enquanto estiver dentro dos valores 1 e 3
            
	        do{
	        	System.out.print("Coluna: ");
	            tentativa[1] = entrada.nextInt(); //armazena coluna informada na tentativa da rodada
	                
	            if(tentativa[1] > 3 || tentativa[1] < 1)
	            	System.out.println("Coluna invalida. ? 1, 2 ou 3"); //retorna mensagem de erro caso informe uma coluna invalida
                
            } while(tentativa[1] > 3 || tentativa[1] < 1);  //executa a repeticao de informa coluna enquanto estiver dentro dos valores 1 e 3
            
            tentativa[0]--;
            tentativa[1]--;

            if(!checaTentativa(tentativa, tabuleiro)) //se a tentativa de jogada ja foi utilizada retorna mensagem informtiva
                System.out.println("Esse local j? foi marcado. Tente outro.");
        }
        while(!checaTentativa(tentativa, tabuleiro) );//executa enquanto a tentativa informada for valida
    }
}
