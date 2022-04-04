package jogoExemplo;

public abstract class Jogador {
    
    protected int[] tentativa = new int[2]; //instancia as tentativas
    protected int jogador;

    
    public Jogador(int jogador){
        this.jogador = jogador;
    }
    
    public abstract void jogar(Tabuleiro tabuleiro);
    
    public abstract void tentativa(Tabuleiro tabuleiro);
    
    protected boolean posicaoEstahLivre(int[] tentativa, Tabuleiro tabuleiro){ //metodo para validar as tentativas disponiveis
        return tabuleiro.getPosicao(tentativa) == 0;
    }
}
