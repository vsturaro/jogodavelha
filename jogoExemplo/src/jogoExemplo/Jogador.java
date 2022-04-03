package jogoExemplo;

public abstract class Jogador {
    
    protected int[] tentativa = new int[2]; //instancia as tentativas
    protected int jogador;

    
    public Jogador(int jogador){
        this.jogador = jogador;
    }
    
    public abstract void jogar(Tabuleiro tabuleiro);
    
    public abstract void Tentativa(Tabuleiro tabuleiro);

    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){ //metodo para validar as tentativas disponiveis
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
            
    }
}
