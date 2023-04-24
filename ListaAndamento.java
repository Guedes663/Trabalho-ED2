import java.util.Random;

public class ListaAndamento extends Lista{ 
   private Lista listaMago;
   private Lista listaTanker;
   private Lista listaCarregador;
   private Lista listaSuporte;
   private Lista listaTime;
   private int pontuacao;
      
   public ListaAndamento() {
      this.listaMago = new Lista();
      this.listaTanker = new Lista();
      this.listaCarregador = new Lista();
      this.listaSuporte = new Lista();
      this.listaTime = new Lista();
   }
   
   public Lista getTime(){
      return this.listaTime;
   }
   
   public void preencherListasRoles(No atual, Lista nomeLista){
      No novoNo = new No();
            
      novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
      novoNo.setAnterior(nomeLista.getCabeca());
      novoNo.setProximo(nomeLista.getCabeca().getProximo());
      nomeLista.getCabeca().getProximo().setAnterior(novoNo);
      nomeLista.getCabeca().setProximo(novoNo);
            
      nomeLista.adicionarTamanho();
      
   }
      
   public void dividirJogadores(Lista lista){ 
      
      for(No atual = lista.getCabeca().getProximo(); atual != lista.getCauda(); atual = atual.getProximo()){  
         if(atual.getDados().getRole().equals("Mago")){
            
            preencherListasRoles(atual, listaMago);
            
         }
         if(atual.getDados().getRole().equals("Tanker")){
            
            preencherListasRoles(atual, listaTanker);
            
         }
         if(atual.getDados().getRole().equals("Carregador")){
            
            preencherListasRoles(atual, listaCarregador);
            
         }
         if(atual.getDados().getRole().equals("Suporte")){
            
            preencherListasRoles(atual, listaSuporte);
            
         }     
      }
   }
   
   public void formarTimes(){
      Random random = new Random();
      
      int sorteio = random.nextInt(2);
      
      for(int i = 0; i < 2; i++){
         No mago = listaMago.getCabeca().getProximo();
         No tanker = listaTanker.getCabeca().getProximo();
         No carregador = listaCarregador.getCabeca().getProximo();
         No suporte = listaSuporte.getCabeca().getProximo(); 
         
         super.adicionarInicio(listaTime, mago);
         listaMago.removeFirst(listaMago);
         
         super.adicionarInicio(listaTime, suporte);
         listaMago.removeFirst(listaSuporte);

         if(sorteio == 1){
            super.adicionarInicio(listaTime, tanker);
            listaMago.removeFirst(listaTanker);
         }else{
            super.adicionarInicio(listaTime, carregador);
            listaMago.removeFirst(listaCarregador);   
         }
      
      }  
   }
   
//   public void removerJogadoresListaEsperaA(Lista listaEspera){
  //    for(No atualE = listaEspera.getCabeca().getProximo(); atualE != listaEspera.getCauda(); atualE = atualE.getProximo()){
    //     for (No atual = listaTime.getCabeca().getProximo(); atual != listaTime.getCauda(); atual = atual.getProximo()){
         
      //      if(atualE.getDados().getID() == atual.getDados().getID()){
                    
   //}
      
   public void calcularPontuacao() {
      int pontuacaoTime = 0;
    
      for (No atual = listaTime.getCabeca().getProximo(); atual != listaTime.getCauda(); atual = atual.getProximo()) {
         pontuacaoTime += atual.getDados().getPontuacaoDeHabilidade();
      }

      this.pontuacao = pontuacaoTime;
   }   
}