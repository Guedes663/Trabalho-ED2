import java.util.Scanner;
import java.util.ArrayList;

public class Menu{
   
   public void menu(){
      Scanner scanner = new Scanner(System.in);
      ListaEspera listaEspera = new ListaEspera();
      
      int opcao = 0;
      
      while(opcao != 4){
         System.out.println("1. Adicionar jogador\n2. Ver jogadores em espera\n3. Ver partidas em andamento\n4. Sair\n");
         opcao = scanner.nextInt();
      
         if(opcao == 1){
            listaEspera.adicionarJogador();
            System.out.println("Jogador adicionado com sucesso na lista\n");
            
         }else if(opcao == 2){
            
         }else if(opcao == 3){
         
         }else if(opcao == 4){
         
         }else{
            System.out.println("Opção inválida\n");
         }
      }
   }
   
}