package jogoExemplo;

public class ComputadorC extends Computador {
	public ComputadorC(int jogador) { //metodo que cria um jogador computador
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
            int[] posicao = tabuleiro.getUltimaPosicaoLivre();
            tentativa[0] = posicao[0];
            tentativa[1] = posicao[1];
            
        } while (!posicaoEstahLivre(tentativa, tabuleiro) );
	}
}
