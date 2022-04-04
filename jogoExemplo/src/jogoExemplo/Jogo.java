package jogoExemplo;

import java.util.Scanner;

public class Jogo {
	private Tabuleiro tabuleiro;
    private int rodada=1;
    private int vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner scanner = new Scanner(System.in);

    
    public Jogo(){
        tabuleiro = new Tabuleiro(); //instancia um novo tabuleiro
    }
    
    public void start() {
        iniciaJogadores(); //chama o metodo para definir os jogadores
    
        jogar(); //enquanto não houver ganhador, continua
    }
    
    private void iniciaJogadores(){ //define a ordem dos jogadores
        System.out.println("Informe o Jogador 1 ?");
        if(escolheJogador() == 1) {
            this.jogador1 = new Humano(1); // instancia o jogador humano como primeiro jogador caso a escolha tenha sido a opcao 1 
        } else {
            this.jogador1 = getDificuldade(1); // instancia o jogador computador como primeiro jogador caso a escolha nao tenha sido a opcao 1
        }
        
        System.out.println("----------------------");
        System.out.println("Informe o Jogador 2 ?");
        
        if(escolheJogador() == 1)
            this.jogador2 = new Humano(2); // instancia o jogador humano como segundo jogador caso a escolha tenha sido a opcao 1
        else
            this.jogador2 = getDificuldade(2); // instancia o jogador computador como segundo jogador caso a escolha tenha sido a opcao 1
    }
    
    private Computador getDificuldade(int jogador) {
        int level=0;
    
        do{
            System.out.println("(1) - Nivel 1");
            System.out.println("(2) - Nivel 2");
            System.out.println("(3) - Nivel 3");
            System.out.print("Informe a opção desejada: ");
            level = scanner.nextInt();
        
            if(level < 1 || level > 3) //valida a opcao informada pelo usuario
                System.out.println("Opção inválida! Tente novamente");
        }
        while(level < 1 || level > 3); //fica em looping enquanto as opcoes informadas nao for uma das desejadas
    
        // define a implementação para o respectivo nivel
        return switch (level) {
            case 1 -> new ComputadorA(jogador);
            case 2 -> new ComputadorB(jogador);
            default -> new ComputadorC(jogador);
        };
    }
    
    private int escolheJogador(){ //metodo para o usuario escolher os jogadores
        int opcao=0;
        
        do{
            System.out.println("(1)Humano");
            System.out.println("(2)Computador\n");
            System.out.print("Informe a opção desejada: ");
            opcao = scanner.nextInt();
            
            if(opcao != 1 && opcao != 2) //valida a opcao informada pelo usuario
                System.out.println("Opção inválida! Tente novamente");
        }
        while(opcao != 1 && opcao != 2); //fica em looping enquanto as opcoes informadas nao for uma das desejadas
        
        return opcao;
    }
    
    
    
    private void jogar(){ //metodo que valida e repete as jogadas enquanto não houver ganhandor ou empate
        boolean gameOver = false;
        
        while(!gameOver) {
            if(ganhou() == 0 ){ //se ainda não houve ganhador,
                System.out.println("----------------------");
                System.out.println("Rodada "+rodada);
                System.out.println("É a vez do jogador " + vez() );
        
                if(vez()==1)
                    jogador1.jogar(tabuleiro); //vez do primeiro jogador
                else
                    jogador2.jogar(tabuleiro); //senão vez do segundo jogador
        
                if(tabuleiro.tabuleiroCompleto()){ //valida se já esgotou as jogadas
                    System.out.println("Tabuleiro Completo. Jogo empatado");
                    gameOver = true;
                }
                vez++;
                rodada++;
            } else{
                if(ganhou() == -1 )
                    System.out.println("Jogador 1 ganhou!");
                else
                    System.out.println("Jogador 2 ganhou!");
    
                gameOver = true;
            }
            
        }
    }
    
    private int vez(){ //metodo para determinar quem ira jogar
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    private int ganhou(){ //metodo para checar qual opcao ganhou (-1 -> X) ou (1 -> O)
        if(tabuleiro.checaLinhas() == 1) //verifica se alguma das linhas foram marcadas com "O"
            return 1;
        if(tabuleiro.checaColunas() == 1) //verifica se alguma das colunas foram marcadas com "O"
            return 1;
        if(tabuleiro.checaDiagonais() == 1) //verifica se alguma das diagonais foram marcadas com "O"
            return 1;
        
        if(tabuleiro.checaLinhas() == -1) //verifica se alguma das linhas foram marcadas com "X"
            return -1;
        if(tabuleiro.checaColunas() == -1) //verifica se alguma das colunas foram marcadas com "X"
            return -1;
        if(tabuleiro.checaDiagonais() == -1) //verifica se alguma das diagonais foram marcadas com "X"
            return -1;
        
        return 0;
    }
}
