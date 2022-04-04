package jogoExemplo;

public class ComputadorA extends Computador {
	public ComputadorA(int jogador) { //metodo que cria um jogador computador
        super(jogador);
    }

	@Override
	public void jogar(Tabuleiro tabuleiro){
	    tentativa(tabuleiro);
	    tabuleiro.setPosicao(tentativa, jogador);
	}

	@Override
	public void tentativa(Tabuleiro tabuleiro){  //metodo herdado da classe jogador
	
		do {
            tentativa[0] =(int)(Math.random()*3); //armazena linha de forma randonica
            tentativa[1] = (int)(Math.random()*3);
            
		} while (!posicaoEstahLivre(tentativa, tabuleiro) );
	}
}
