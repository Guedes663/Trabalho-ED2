import java.util.Scanner;

public class Lista{
   private No cauda;
   private No cabeca;
   private int tamanho;
   
   public Lista(){
      cauda = new No();
      cabeca = new No();
      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
      tamanho = 0;
   }
   
   public No getCabeca(){
      return cabeca;
   }
   
   public No getCauda(){
      return cauda;
   }
   
   public void setTamanho(){
      this.tamanho ++;
   }
   
   public int getTamanho(){
      return this.tamanho;   
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
      novoJogador.setAnterior(cabeca);
      novoJogador.setProximo(cabeca.getProximo());
      cabeca.getProximo().setAnterior(novoJogador);
      cabeca.setProximo(novoJogador);
      tamanho++; 
   }
   
   public void printLista(){
      if(tamanho == 0){
         System.out.println("Nao existe nenhum jogador\n");
      } else{
         for(No atual = cabeca.getProximo(); atual != cauda; atual = atual.getProximo()){
            System.out.println(atual.getDados());
         }
      }   
   }

}