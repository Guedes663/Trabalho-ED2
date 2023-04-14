import java.util.Scanner;
import java.util.ArrayList;

public class Menu{
   ArrayList<Jogador> listaEspera = new ArrayList<Jogador>();
   
   public void menu(){
      Scanner scanner = new Scanner(System.in);
      Jogador jogador = new Jogador();
      int opcao = 0;
      
      while(opcao != 4){
         System.out.println("1. Adicionar jogador\n2. Ver jogadores em espera\n3. Ver partidas em andamento\n4. Sair\n");
         opcao = scanner.nextInt();
      
         if(opcao == 1){
            jogador.adicionarJogador();
            listaEspera.add(jogador);
            System.out.println("Jogador adicionado com sucesso na lista\n");
            
         }else if(opcao == 2){
            exibirListaEspera();
            
         }else if(opcao == 3){
         
         }else if(opcao == 4){
         
         }else{
            System.out.println("Opção inválida\n");
         }
      }
   }
   
   public void exibirListaEspera(){
      Jogador jogador = new Jogador();
      for(int i = 0; i < this.listaEspera.size(); i++){
         System.out.println(listaEspera.get(i));
      }
   }
   
}