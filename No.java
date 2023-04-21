public class No{
   private No proximo;
   private No anterior;
   private Jogador dados;
   
   public No getProximo(){
      return this.proximo;
   }
   
   public No getAnterior(){
      return this.anterior;
   }
   
   public Jogador getDados(){
      return this.dados;
   }
   
   public void setProximo(No proximo){
      this.proximo = proximo;
   }
   
   public void setAnterior(No anterior){
      this.anterior = anterior;
   }
   
   public void setDados(String ID, String role, int pontuacaoDeHabilidade){
      Jogador jogador = new Jogador(ID, role, pontuacaoDeHabilidade);
      this.dados = jogador;
   }   
}