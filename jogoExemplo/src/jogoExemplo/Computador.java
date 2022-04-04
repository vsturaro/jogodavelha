package jogoExemplo;

public abstract class Computador extends Jogador {
 
	public Computador(int jogador){ //metodo que cria um jogador computador
		super(jogador);
		System.out.println("Jogador 'Computador' criado!");
	}
}
