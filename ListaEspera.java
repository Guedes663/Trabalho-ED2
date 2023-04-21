import java.util.Scanner;

public class ListaEspera{
   private No cauda;
   private No cabeca;
   private int tamanho;
   
   public ListaEspera(){
      cauda = new No();
      cabeca = new No();
      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
      tamanho = 0;
   }
   
   public void adicionarJogador(){
      No novoJogador = new No();
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Digite o ID do seu jogador\n");
      String ID = scanner.nextLine();
      System.out.println("Digite a role do seu jogador\n");
      String role = scanner.nextLine();
      System.out.println("Digite a pontuação de habilidade do jogador\n");
      int pontuacaoDeHabilidade = scanner.nextInt();
      
      novoJogador.setDados(ID, role, pontuacaoDeHabilidade);
      novoJogador.setProximo(cabeca.getProximo());
      novoJogador.setAnterior(cabeca);
      cabeca.getProximo().setAnterior(novoJogador);
      cabeca.setProximo(novoJogador);
      tamanho ++; 
   }
   
   public void printListaEspera(){
      if(tamanho == 0){
         System.out.println("Não existe nenhum jogador\n");
      } else{
         for(No atual = cabeca.getProximo(); atual != cauda; atual = atual.getProximo()){
            System.out.println(atual.getDados());
         }
      }
   }
}