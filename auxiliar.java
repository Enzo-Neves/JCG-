import java.util.*;
/**
 * Classe auxiliar que ajuda no programa principal
 * 
 * @author Enzo Krzmienszki Neves 
 * @version 1.0 
 */
class auxiliar
{
    /**
     * Cria um menu funcional para o jogador escolher se quer jogar ou sair e retorna o menu
     * 
     * 
     * @param de teclado
     */
    public static int menu(Scanner teclado){
        int menu;
        System.out.println("====Bem vindo ao Jokenpo CardGame====");
        System.out.println("1-Classico     2-sair");
        System.out.println("");
        System.out.println("1:uma partida de jokenpo rapida com uma melhor de 3 para ver quem é o melhor;"); 
        menu=teclado.nextInt();      
        while(menu<1 || menu>2){
            System.out.println("Valor invalido, por favor digite novamente");           
            menu=teclado.nextInt();
        }
        return menu;
    }
    /**
     * imprime a carta escolhida pelo jogador de sua mao e armazena o valor da carta na variavel c e retorna o mesmo
     * @param um vetor de inteiro com nome de mao e um inteiro com nome de c
     */
    public static int pedra_Papel_Tesoura(int [] mao,int c){
        String  [] PPT = { "Scissor", "Paper" ,"Stone"  };

        if(c==0){
            c=mao[0]; 
        }else{
            if(c==1){
                c=mao[1];    
            }
            else{
                if(c==2){
                    c=mao[2];
                }
            }
        }
        if(c==1){
            System.out.println("Sua carta:");            
            System.out.print( PPT[0]);
        }
        else{
            if(c==2){
                System.out.println("Sua carta:");
                System.out.print( PPT[1]);
            }   
            else{ 
                if(c==4){
                    System.out.println("Sua carta:");
                    System.out.print( PPT[2]);
                }
            }
        }
        return c;
    }
    /**
     * Imprime as cartas da sua mao e retorna sua mao
     * 
     * @param um vetor de inteiro
     */public static int[] suasCartas(int[] Baralho){
        int i;
        int mao[] = new int[3];//mao do usuario
        //for que cria a mao do usuario 

        for(i = 0; i<3; i++){
            int rnd = new Random().nextInt(Baralho.length); 
            mao[i]=(Baralho[rnd]);
            if(mao[i]==1){
                System.out.println(i + ":Scissor");
            }
            if(mao[i]==2){
                System.out.println( i + ":Paper");
            }
            if(mao[i]==4){
                System.out.println(i +":Stone");
            }
        }    
        return mao;
    }
    /**
     * pega e gera uma carta aleatoria do vetor baralho e imprime como a carta da cpu e retorna o valor da carta
     * @param um vetor de inteiro
     */
    public static int[] carta_do_computador(int [] Baralho){
        int i;
        int cpu[] = new int[1];
        for(i = 0; i<1; i++){
            int rnd = new Random().nextInt(Baralho.length);
            cpu[i]=(Baralho[rnd]);
            if(cpu[i]==1){
                System.out.println( "Scissor");
            }
            if(cpu[i]==2){
                System.out.println( "Paper");
            }
            if(cpu[i]==4){
                System.out.println("Stone");
            }  
        }
        return cpu;
    }   
    /**
     * calcula o placar entre o jogador e a cpu e ve quem é o ganhador, retornando um valor de resultado para ser usado no programa principal
     * @param dois inteiros cada um com sua variavel, um sendo e e outro cartaCpu
     */
    public static int resultado(int c, int cartaCpu ){
        int resultado=0;
        int Player=0;
        int cpu=0;
        if(c==1 && cartaCpu==2){
            //tesoura e papel
            System.out.println("voce ganhou a rodada");
            Player=1;
            cpu=0;
        }
        if(c==4 && cartaCpu==1){
            //pedra e tesoura
            System.out.println("voce ganhou a rodada");
            Player=1;
            cpu=0;
        }
        if(c==2 && cartaCpu==4){
            //papel e pedra
            System.out.println("voce ganhou a rodada");
            Player=1;
            cpu=0;
        }
        if(c==1 && cartaCpu==4){
            //tresoura e pedra
            System.out.println("voce perdeu a rodada");
            Player=0;
            cpu=2;
        }
        if(c==2 && cartaCpu==1){
            //papel e tesoura
            System.out.println("voce perdeu a rodada");
            Player=0;
            cpu=2;
        }
        if(c==4 && cartaCpu==2){
            //pedra e papel
            System.out.println("voce perdeu a rodada"); 
            Player=0;
            cpu=2;
        }
        if(c == cartaCpu){
            System.out.println("a rodada empatou");
        }
        if(Player > cpu){
            resultado =1;
        }
        if(cpu>Player){
            resultado=2;
        }
        if(cpu==Player){
            resultado=0;
        }
        return resultado;
    } 
    /**
     * imprime o resultado final, se voce ganhou o jogo ou nao
     * @param recebe dois inteiros com nome de n e m 
     */
    public static void resultString(int n, int m){
        if(n>m){
            System.out.println("====Voce ganhou o jogo====");
        }
        else{
            if(m>n){
                System.out.println("====Voce perdeu o jogo====");          
            } 
            else{
                if(m==n){
                    System.out.println("====Empate====");           
                }
            }
        }
    }
    /**
     * embaralha o baralho recebido para a distribuiçao das cartas serem aleatorias
     * @param um vetor de inteiro com nome v
     */
    public static void embaralhar(int [] v){
        Random random = new Random();
        for (int i=0; i < v.length; i++) {
            //sorteia um índice
            int j = random.nextInt(v.length);
            //troca o conteúdo dos índices i e j do vetor
            int temp = v[i];
            v[i] = v[j];
            v[j] = temp;
        }   
    }
    /**
     * cria um baralho
     */
    public static int[] baralho(){
        int i;
        //Cria uma vetor com 54 espaços para cada carta
        int [] Baralho = new int [54];
        for (i=0; i<18; i ++){
            Baralho[i] = 1; 
        }
        for (i=18; i>=18 && i<36; i ++) {
            Baralho[i] = 2; 
        }
        for (i=36; i>=36 && i<54; i ++) {
            Baralho[i] = 4;
        }   
        return Baralho;
    }
}