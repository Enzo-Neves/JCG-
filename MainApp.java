import java.util.*;
/**
 * A classe MainApp Faz um jogo de cartas inspirado no jogo jokenpo numa md3.
 * @author Enzo Krzmienszki Neves 
 * @version 1.0  11/06/2021  
 * copiright Enzo Krzmienzki Neves
 */
public class MainApp

//Criar um vetor de String que armazena os nomes pedra papel tesoura


{
    public static void main(String[] args){
            int c;//carta que quer jogar
            int [] baralho;
            int []cpu;//vetor das cartas da cpu
            int [] mao;//vetor das cartas do usuario
            int resultado;//variavel que armazena o resultado
            int cartaCpu;//carta da jogada da cpu
            int desição;//variavel de desição para saber se o usuario quer continuar a jogar
            int r;//variavel da rodada
            int n=0;// placar do player 
            int m=0;//placar da cpu
            int menu;//variavel do menu do game
            int jogo=1;//variavel do laço do while
            int e;//controle de nova variavel para nao retornar sempre c
            Scanner teclado= new Scanner(System.in);//abertura do teclado
            System.out.print("\f"); //limpar o terminal da pessoa caso tenha algo escrito antes de começar o mini game
            menu=auxiliar.menu(teclado = new Scanner(System.in));//chama da classe auxiliar o menu do jogo
            
            //as 2 if's verificam qual foi a escolha do usuario feita no menu
             if(menu==1){
                System.out.println("Que comece a melhor de 3");
                
            }
            else{
                if(menu==2){
                   System.out.println("ate mais");
                        //faz com que o while do programa nao execute fazendo com que ele nao inicie
                        jogo=0;
                }
            }
        
    
        
            //programa do jogo de jokenpo card game
                while(jogo==1){
                baralho=auxiliar.baralho();
                auxiliar.embaralhar(baralho);//gera o baralho e o embaralha para partida classica
                mao=auxiliar.suasCartas(baralho);//da as 3 cartas do jogador e as enumera;
                //rodada começa em 0 para iniciar o while pelo menos uma vez
                r=0;
                //define os placares de m e n em 0 para a partida
                while(r<3){
                    System.out.println("====Escolha o numero da carta que voce deseja jogar====");
                    //faz o usuario escolher a carta que deseja jogar de sua mao
                    c=teclado.nextInt();
                        while(c>2 || c<0 ||mao[c]==-1 ){
                        System.out.println("====Por favor insira uma carta valida entre 0,1,2====");
                        c=teclado.nextInt();
                    }
                    // se a carta valida se ela ta na minha mao ex: 0 valida mas nao ta na mao
                    e=auxiliar.pedra_Papel_Tesoura(mao, c);
                    mao[c]=-1;
                    System.out.print(" X ");
                    cpu=auxiliar.carta_do_computador(baralho);
                    cartaCpu=cpu[0];
                    resultado=auxiliar.resultado(e,cartaCpu);
                    
                    if(resultado==1){
                        n= n + 1;
                    }
                     if(resultado==2){
                        m= m + 1;
                    }
                    System.out.println("Player:" + n + " Cpu:"+ m);
                    r=r+1;    
                        if (r==3){
                        auxiliar.resultString(n,m);
                        System.out.println("====Quer continuar a jogar:====");
                        System.out.println("===1-Sim 2-nao===");
                        desição=teclado.nextInt();
                        if(desição==1){
                            System.out.print("\f");
                        }
                        if(desição==2){
                            System.out.println("====Obrigado por jogar====");
                            jogo=0;
                            }
                    } 
                }
            }
            teclado.close();
    }
}