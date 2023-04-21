public class Jogador{
   private String ID;
   private String role;
   private int pontuacaoDeHabilidade;
      
   public Jogador(String ID, String role, int pontuacaoDeHabilidade){
      this.ID = ID;
      this.role = role;
      this.pontuacaoDeHabilidade = pontuacaoDeHabilidade;
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
   
   public void setID(String elemento){
      this.ID = elemento;
   }
   
   public void setRole(String elemento){
      this.role = elemento;
   }
   
   public void setPontuacaoDeHabilidade(int elemento){
      this.pontuacaoDeHabilidade = elemento;
   }
   
   @Override
   public String toString() {
      return "ID: " + this.ID + "; Role: " + this.role + "; Pontuação de Habilidade: " + this.pontuacaoDeHabilidade;
   }
   // O método acima reescreve a representação em forma de String do Objeto em questão.
}