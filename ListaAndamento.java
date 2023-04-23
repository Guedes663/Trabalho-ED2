import java.util.Random;

public class ListaAndamento extends Lista{ 
   private Lista listaMago;
   private Lista listaTanker;
   private Lista listaCarregador;
   private Lista listaSuporte;
   private Lista listaTimeA;
   private Lista listaTimeB;
   private int pontuacaoA;
   private int pontuacaoB;
      
   public ListaAndamento() {
      this.listaMago = new Lista();
      this.listaTanker = new Lista();
      this.listaCarregador = new Lista();
      this.listaSuporte = new Lista();
      this.listaTimeA = new Lista();
      this.listaTimeB = new Lista();
   }
   
   public Lista getTimeA(){
      return this.listaTimeA;
   }
   
   public Lista getTimeB(){
      return this.listaTimeB;
   }
      
   public void dividirJogadores(Lista lista){ 
      Lista listaMago = new Lista();
      Lista listaTanker = new Lista();
      Lista listaCarregador = new Lista();
      Lista listaSuporte = new Lista();
      
      for(No atual = lista.getCabeca().getProximo(); atual != lista.getCauda(); atual = atual.getProximo()){  
         if(atual.getDados().getRole().equals("Mago")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaMago.getCabeca());
            novoNo.setProximo(listaMago.getCabeca().getProximo());
            listaMago.getCabeca().getProximo().setAnterior(novoNo);
            listaMago.getCabeca().setProximo(novoNo);
            
            listaMago.adicionarTamanho();
         }
         if(atual.getDados().getRole().equals("Tanker")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaTanker.getCabeca());
            novoNo.setProximo(listaTanker.getCabeca().getProximo());
            listaTanker.getCabeca().getProximo().setAnterior(novoNo);
            listaTanker.getCabeca().setProximo(novoNo);
            
            listaTanker.adicionarTamanho();
         }
         if(atual.getDados().getRole().equals("Carregador")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaCarregador.getCabeca());
            novoNo.setProximo(listaCarregador.getCabeca().getProximo());
            listaCarregador.getCabeca().getProximo().setAnterior(novoNo);
            listaCarregador.getCabeca().setProximo(novoNo);
            
            listaCarregador.adicionarTamanho();
         }
         if(atual.getDados().getRole().equals("Suporte")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaSuporte.getCabeca());
            novoNo.setProximo(listaSuporte.getCabeca().getProximo());
            listaSuporte.getCabeca().getProximo().setAnterior(novoNo);
            listaSuporte.getCabeca().setProximo(novoNo);
            
            listaSuporte.adicionarTamanho();
         }     
      }
      this.listaMago = listaMago;
      this.listaTanker = listaTanker;
      this.listaCarregador = listaCarregador;
      this.listaSuporte = listaSuporte;
   }
   
   public void formarTimes(){
      Random gerador = new Random();
      
      int sorteio = gerador.nextInt(2);
      
      No mago = new No();
      No suporte = new No();
      No tanker = new No();
      No carregador = new No();
      
      mago = listaMago.getCabeca().getProximo();
      suporte = listaSuporte.getCabeca().getProximo();
      tanker = listaTanker.getCabeca().getProximo();
      carregador = listaCarregador.getCabeca().getProximo();
      
      mago.setAnterior(listaTimeA.getCabeca());
      mago.setProximo(listaTimeA.getCabeca().getProximo());
      listaTimeA.getCabeca().setProximo(mago);
      listaTimeA.getCauda().setAnterior(mago);
      
      listaMago.removeFirst(listaMago);
      listaMago.diminuirTamanho();
      listaTimeA.adicionarTamanho();
      if(sorteio == 1){
         tanker.setAnterior(listaTimeA.getCabeca().getProximo());
         tanker.setProximo(listaTimeA.getCabeca().getProximo().getProximo());
         mago.setProximo(tanker);   
         listaTimeA.getCauda().setAnterior(tanker);
         
         listaTanker.removeFirst(listaTanker);
         listaTanker.diminuirTamanho();
         listaTimeA.adicionarTamanho();
         
         suporte.setAnterior(listaTimeA.getCauda().getAnterior());
         suporte.setProximo(listaTimeA.getCauda());
         listaTimeA.getCauda().setAnterior(suporte);
         tanker.setProximo(suporte);
         
         listaSuporte.removeFirst(listaSuporte);
         listaSuporte.diminuirTamanho();
         listaTimeA.adicionarTamanho();
      }else{
         carregador.setAnterior(listaTimeA.getCabeca().getProximo());
         carregador.setProximo(listaTimeA.getCabeca().getProximo().getProximo());
         mago.setProximo(carregador);
         listaTimeA.getCauda().setAnterior(carregador);
         
         listaCarregador.removeFirst(listaCarregador);
         listaCarregador.diminuirTamanho();
         listaTimeA.adicionarTamanho();
         
         suporte.setAnterior(listaTimeA.getCauda().getAnterior());
         suporte.setProximo(listaTimeA.getCauda());
         listaTimeA.getCauda().setAnterior(suporte);
         carregador.setProximo(suporte);
         
         listaSuporte.removeFirst(listaSuporte);
         listaSuporte.diminuirTamanho();
         listaTimeA.adicionarTamanho();
      }
      
      sorteio = gerador.nextInt(2);
      mago = listaMago.getCabeca().getProximo();
      suporte = listaSuporte.getCabeca().getProximo();
      tanker = listaTanker.getCabeca().getProximo();
      carregador = listaCarregador.getCabeca().getProximo();
      
      mago.setAnterior(listaTimeB.getCabeca());
      mago.setProximo(listaTimeB.getCabeca().getProximo());
      listaTimeB.getCabeca().setProximo(mago);
      listaTimeB.getCauda().setAnterior(mago);
      
      listaMago.removeFirst(listaMago);
      listaMago.diminuirTamanho();
      listaTimeB.adicionarTamanho();
      if(sorteio == 1){
         tanker.setAnterior(listaTimeB.getCabeca().getProximo());
         tanker.setProximo(listaTimeB.getCabeca().getProximo().getProximo());
         mago.setProximo(tanker);   
         listaTimeB.getCauda().setAnterior(tanker);
         
         listaTanker.removeFirst(listaTanker);
         listaTanker.diminuirTamanho();
         listaTimeB.adicionarTamanho();
         
         suporte.setAnterior(listaTimeB.getCauda().getAnterior());
         suporte.setProximo(listaTimeB.getCauda());
         listaTimeB.getCauda().setAnterior(suporte);
         tanker.setProximo(suporte);
         
         listaSuporte.removeFirst(listaSuporte);
         listaSuporte.diminuirTamanho();
         listaTimeB.adicionarTamanho();
      }else{
         carregador.setAnterior(listaTimeB.getCabeca().getProximo());
         carregador.setProximo(listaTimeB.getCabeca().getProximo().getProximo());
         mago.setProximo(carregador);
         listaTimeB.getCauda().setAnterior(carregador);
         
         listaCarregador.removeFirst(listaCarregador);
         listaCarregador.diminuirTamanho();
         listaTimeB.adicionarTamanho();
         
         suporte.setAnterior(listaTimeB.getCauda().getAnterior());
         suporte.setProximo(listaTimeB.getCauda());
         listaTimeB.getCauda().setAnterior(suporte);
         carregador.setProximo(suporte);
         
         listaSuporte.removeFirst(listaSuporte);
         listaSuporte.diminuirTamanho();
         listaTimeB.adicionarTamanho();
      }
      this.listaTimeA = listaTimeA;
      this.listaTimeB = listaTimeB;
   }
   
   public void removerJogadoresListaEsperaA(Lista listaEspera){
      for(No atualE = listaEspera.getCabeca().getProximo(); atualE != listaEspera.getCauda(); atualE = atualE.getProximo()){
         for (No atualA = listaTimeA.getCabeca().getProximo(); atualA != listaTimeA.getCauda(); atualA = atualA.getProximo()){
            if(atualE.getDados().getID() == atualA.getDados().getID()){
               if((atualE.getAnterior() == listaEspera.getCabeca())&&(atualE.getProximo() == listaEspera.getCauda())){
                  listaEspera.getCabeca().setProximo(listaEspera.getCauda());
                  listaEspera.getCauda().setAnterior(listaEspera.getCabeca());
               }
               else if((atualE.getAnterior() == listaEspera.getCabeca())&&(atualE.getProximo() != listaEspera.getCauda())){
                  listaEspera.getCabeca().setProximo(atualE.getProximo());
                  atualE.getProximo().setAnterior(listaEspera.getCabeca());
               }
               else if((atualE.getProximo() == listaEspera.getCauda())&&(atualE.getAnterior() != listaEspera.getCabeca())){
                  listaEspera.getCauda().setAnterior(atualE.getAnterior());
                  atualE.getAnterior().setProximo(listaEspera.getCauda());   
               }else{
                  atualE.getAnterior().setProximo(atualE.getProximo());
                  atualE.getProximo().setAnterior(atualE.getAnterior());
               }   
            }      
         }         
      }
      listaEspera.diminuirTamanho();      
   }
   
   public void removerJogadoresListaEsperaB(Lista listaEspera){
      for(No atualE = listaEspera.getCabeca().getProximo(); atualE != listaEspera.getCauda(); atualE = atualE.getProximo()){
         for (No atualB = listaTimeB.getCabeca().getProximo(); atualB != listaTimeB.getCauda(); atualB = atualB.getProximo()){
            if(atualE.getDados().getID() == atualB.getDados().getID()){
               if((atualE.getAnterior() == listaEspera.getCabeca())&&(atualE.getProximo() == listaEspera.getCauda())){
                  listaEspera.getCabeca().setProximo(listaEspera.getCauda());
                  listaEspera.getCauda().setAnterior(listaEspera.getCabeca());
               }
               else if((atualE.getAnterior() == listaEspera.getCabeca())&&(atualE.getProximo() != listaEspera.getCauda())){
                  listaEspera.getCabeca().setProximo(atualE.getProximo());
                  atualE.getProximo().setAnterior(listaEspera.getCabeca());
               }
               else if((atualE.getProximo() == listaEspera.getCauda())&&(atualE.getAnterior() != listaEspera.getCabeca())){
                  listaEspera.getCauda().setAnterior(atualE.getAnterior());
                  atualE.getAnterior().setProximo(listaEspera.getCauda());   
               }else{
                  atualE.getAnterior().setProximo(atualE.getProximo());
                  atualE.getProximo().setAnterior(atualE.getAnterior());
               }   
            }      
         }         
      }
      listaEspera.diminuirTamanho();    
   }
   
   public void calcularPontuacao() {
      int pontuacaoTimeA = 0;
      int pontuacaoTimeB = 0;
    
      for (No atual = listaTimeA.getCabeca().getProximo(); atual != listaTimeA.getCauda(); atual = atual.getProximo()) {
         pontuacaoTimeA += atual.getDados().getPontuacaoDeHabilidade();
      }
    
      for (No atual = listaTimeB.getCabeca().getProximo(); atual != listaTimeB.getCauda(); atual = atual.getProximo()) {
         pontuacaoTimeB += atual.getDados().getPontuacaoDeHabilidade();
      }
    
      this.pontuacaoA = pontuacaoTimeA;
      this.pontuacaoB = pontuacaoTimeB;
   }   
}