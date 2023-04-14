import java.util.Scanner;

public class Jogador{
   private String ID;
   private String role;
   private int pontuacaoDeHabilidade;
      
   public void adicionarJogador(){
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Digite o ID do jogador");
      this.ID = scanner.nextLine();
      System.out.println("Digite a role do jogador, sendo elas carregador, suporte, mago ou tanker");
      this.role = scanner.nextLine();
      System.out.println("Digite a pontuação de habilidade");
      this.pontuacaoDeHabilidade = scanner.nextInt();
   }
   
   public String getID(){
      return this.ID;   
   }
   
   public String getRole(){
      return this.role;
   }
   
   public int getPontuacaoDeHabilidade(){
      return this.pontuacaoDeHabilidade;
   }
}