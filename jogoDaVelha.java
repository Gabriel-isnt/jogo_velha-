import java.util.Scanner;

public class jogoDaVelha {
        public static void main(String[] args) {
                
                Scanner sc = new Scanner(System.in);

                char[] jogo = {' ', ' ', ' ',' ', ' ', ' ',' ', ' ', ' '};
                
                Jogador jogador1 = new Jogador('X', "jogador 1");
                Jogador jogador2 = new Jogador('O', "jogador 2"); 
                

                while(true){
                        mostraJogo(jogo);
                        jogo = fazerJogada(jogador1.getSimbolo(), jogo, sc);

                        if(verificaVitoria(jogo, jogador1.getSimbolo())){
                                terminouJogo(jogador1.getNome(), jogo);
                                break;
                        }

                        mostraJogo(jogo);                        
                        jogo = fazerJogada(jogador2.getSimbolo(), jogo, sc);

                        if(verificaVitoria(jogo, jogador2.getSimbolo())){
                                terminouJogo(jogador2.getNome(), jogo);
                                break;
                        }
                }

                sc.close();

        }


        public static void quebraLinha(){
                
                System.out.println();
        }


        public static void mostraJogo(char[] jogo){  // mesma coisa que eu fiz no meu do C# pq gostei da ideia
                
                System.out.printf("   1 | 2 | 3         %c | %c | %c %n", jogo[0], jogo[1], jogo[2]);
                System.out.println("  -----------       -----------");
                System.out.printf("   4 | 5 | 6         %c | %c | %c %n", jogo[3], jogo[4], jogo[5]);
                System.out.println("  -----------       -----------");
                System.out.printf("   7 | 8 | 9         %c | %c | %c %n", jogo[6], jogo[7], jogo[8]);

        }


        public static char[] fazerJogada(char simbolo, char[] jogo, Scanner sc){
                
                int posicao;

                while(true){
                        
                        System.out.print("escolha uma posição válida: ");
                        posicao = sc.nextInt();

                        if((posicao >= 1 &&  posicao <= 9) && jogo[posicao - 1] == ' '){
                                jogo[posicao - 1] = simbolo;
                                return jogo;
                        }
                }
        }


        public static boolean verificaVitoria(char[] jogo, char simbolo){

                // vendo as linhas
                if(jogo[0] == simbolo && jogo[1] == simbolo && jogo[2] == simbolo) return true;
                if(jogo[3] == simbolo && jogo[4] == simbolo && jogo[5] == simbolo) return true;
                if(jogo[6] == simbolo && jogo[7] == simbolo && jogo[8] == simbolo) return true;

                // vendo as diagonais
                if(jogo[0] == simbolo && jogo[4] == simbolo && jogo[8] == simbolo) return true;
                if(jogo[2] == simbolo && jogo[4] == simbolo && jogo[6] == simbolo) return true;

                // vendo as colunas
                if(jogo[0] == simbolo && jogo[3] == simbolo && jogo[6] == simbolo) return true;
                if(jogo[1] == simbolo && jogo[4] == simbolo && jogo[7] == simbolo) return true;
                if(jogo[2] == simbolo && jogo[5] == simbolo && jogo[8] == simbolo) return true;

                return false;

        }


        public static void terminouJogo(String nome, char[] jogo){
                mostraJogo(jogo);
                System.out.printf("%s ganhou o jogo", nome);
        }

}


class Jogador {

        private char simbolo;   
        private String nome;    

        public Jogador(char simbolo, String nome) {
                this.simbolo = simbolo; 
                this.nome = nome;     
        }

        public char getSimbolo() {
                return simbolo;
        }

        public String getNome() {
                return nome;
        }
}

