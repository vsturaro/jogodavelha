package jogoExemplo;

public class Tabuleiro {

	 private final int[][] tabuleiro= new int[3][3]; //instancia o tabuleiro como uma matriz 3x3
	    
    public Tabuleiro(){
        limpaTabuleiro();
    }
    
    public void limpaTabuleiro(){ //metodo para limpar o tabuleiro
        for(int linha = 0; linha < tabuleiro.length; linha++)
            for(int coluna = 0; coluna < tabuleiro.length; coluna++)
                tabuleiro[linha][coluna]=0;
    }
    
    public void exibeTabuleiro(){ //metodo para exibir em tela o preenchimento do tabuleiro
        System.out.println();
        for(int linha = 0; linha < tabuleiro.length; linha++) { //faz a verificacao das linhas
        
            for(int coluna = 0; coluna < tabuleiro.length; coluna++) { //faz a verificacao das colunas
                
                if(tabuleiro[linha][coluna]==-1){ //caso houver algum valor preenchido com -1 "X" será preenchido
                    System.out.print(" X ");
                }
                if(tabuleiro[linha][coluna]==1){ //caso houver algum valor preenchido com 1 "O" será preenchido
                    System.out.print(" O ");
                }
                if(tabuleiro[linha][coluna]==0){ //caso não houver ainda preenchimento, será exibido espaço vazio
                    System.out.print("   ");
                }
                
                if(coluna==0 || coluna==1)
                    System.out.print("|"); //imprime divisor independente de haver ou não valor preenchido
            }
            System.out.println();
        }
        
    }

    public int getPosicao(int[] tentativa){
        return tabuleiro[tentativa[0]][tentativa[1]];
    }
    
    public int[] getPrimeiraPosicaoLivre(){
        int[] posicao = new int[2];
        
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if(tabuleiro[i][j] == 0){
                    posicao[0] = i;
                    posicao[1] = j;
                    return posicao;
                }
            }
        }
        return posicao;
    }
    
    public int[] getUltimaPosicaoLivre(){
        int[] posicao = new int[2];
        
        for (int i = tabuleiro.length-1; i >= 0; i--) {
            for (int j = tabuleiro.length-1; j >= 0 ; j--) {
                if(tabuleiro[i][j] == 0){
                    posicao[0] = i;
                    posicao[1] = j;
                    return posicao;
                }
            }
        }
        return posicao;
    }
	    
    public void setPosicao(int[] tentativa, int jogador){ //seta a tentativa e o jogador para controlar as jogadas
        if(jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            tabuleiro[tentativa[0]][tentativa[1]] = 1;
        
        exibeTabuleiro();
    }

    public int checaLinhas(){ //metodo para checar preenchimento de linhas
        for (int linha = 0; linha < tabuleiro.length; linha++) {
        //(int linha=0 ; linha<3 ; linha++){

            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3) //verifica se a linha foi toda preenchida com "X"
                return -1;
            if( (tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3) //verifica se a linha foi toda preenchida com "O"
                return 1;
        }
        
        return 0;
        
    }
    
    public int checaColunas(){ //metodo para checar preenchimento de colunas
        for(int coluna=0; coluna < tabuleiro.length; coluna++) {
        //(int coluna=0 ; coluna<3 ; coluna++){

            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3) //verifica se a coluna foi toda preenchida com "X"
                return -1;
            if( (tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3) //verifica se a coluna foi toda preenchida com "O"
                return 1;
        }
        
        return 0;
        
    }
    
    public int checaDiagonais(){ //metodo para checar preenchimento de diagonais
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3) //verifica se a diagonal foi toda preenchida com "X"
            return -1;
        if( (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3) //verifica se a diagonal foi toda preenchida com "O"
            return 1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3) //verifica se a diagonal foi toda preenchida com "X"
            return -1;
        if( (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3) //verifica se a diagonal foi toda preenchida com "O"
            return 1;
        
        return 0;
    }

    public boolean tabuleiroCompleto(){ //metodo para verificar se o tabuleiro foi todo preenchido sem existir ganhador
        for(int linha = 0; linha < tabuleiro.length; linha++) //faz a busca pelas linhas
       // (int linha=0 ; linha<3 ; linha++)
            for(int coluna=0; coluna < tabuleiro.length; coluna++) //faz a busca pelas  colunas
            //(int coluna=0 ; coluna<3 ; coluna++)
                if( tabuleiro[linha][coluna]==0 ) //se nao houver nenhum valor preenchido para o campo, logo esta vazio e retorna falso, tabuleiro nao esta completo
                    return false;
        return true;
    }
}

