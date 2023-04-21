public class ListaAndamento extends Lista{
   private int habilidadeTotal;  
   
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
            
            listaMago.setTamanho();
         }
         if(atual.getDados().getRole().equals("Tanker")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaTanker.getCabeca());
            novoNo.setProximo(listaTanker.getCabeca().getProximo());
            listaTanker.getCabeca().getProximo().setAnterior(novoNo);
            listaTanker.getCabeca().setProximo(novoNo);
            
            listaTanker.setTamanho();
         }
         if(atual.getDados().getRole().equals("Carregador")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaCarregador.getCabeca());
            novoNo.setProximo(listaCarregador.getCabeca().getProximo());
            listaCarregador.getCabeca().getProximo().setAnterior(novoNo);
            listaCarregador.getCabeca().setProximo(novoNo);
            
            listaCarregador.setTamanho();
         }
         if(atual.getDados().getRole().equals("Suporte")){
            No novoNo = new No();
            
            novoNo.setDados(atual.getDados().getID(), atual.getDados().getRole(), atual.getDados().getPontuacaoDeHabilidade());
            novoNo.setAnterior(listaSuporte.getCabeca());
            novoNo.setProximo(listaSuporte.getCabeca().getProximo());
            listaSuporte.getCabeca().getProximo().setAnterior(novoNo);
            listaSuporte.getCabeca().setProximo(novoNo);
            
            listaSuporte.setTamanho();
         }     
      }
   }
         
}