public class Lista{
   protected No cauda;
   protected No cabeca;
   protected int tamanho;
   
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
   
   public void adicionarTamanho(){
      this.tamanho ++;
   }
   
   public void diminuirTamanho(){
      this.tamanho --;
   }
    
   public int getTamanho(){
      return this.tamanho;   
   }
   
   public void adicionarInicio(Lista lista, No novoNo){
      novoNo.setAnterior(lista.getCabeca());
      novoNo.setProximo(lista.getCabeca().getProximo());
      lista.getCabeca().getProximo().setAnterior(novoNo);
      lista.getCabeca().setProximo(novoNo);
      lista.adicionarTamanho();   
   }
   
   public void adicionarFim(Lista lista, No novoNo){
      novoNo.setProximo(lista.getCauda());
      novoNo.setAnterior(lista.getCauda().getAnterior());
      lista.getCauda().getAnterior().setProximo(novoNo);
      lista.getCauda().setAnterior(novoNo);
      lista.adicionarTamanho();   
   }
   
   public void printLista(Lista lista){
      if(lista.getTamanho() == 0){
         System.out.println("Nao existe nenhum jogador\n");
      } else{
         for(No atual = lista.getCabeca().getProximo(); atual != lista.getCauda(); atual = atual.getProximo()){
            System.out.println(atual.getDados());
         }
      }   
   }
   
   public void removeFirst(Lista lista){
    if(lista.getTamanho() == 0){
        System.out.println("A lista está vazia, não é possível remover.");
    } else {
        No primeiroNo = lista.getCabeca().getProximo();
        if(primeiroNo != null) {
            No segundoNo = primeiroNo.getProximo();
            if(segundoNo != null) {
                segundoNo.setAnterior(lista.getCabeca());
            }
            lista.getCabeca().setProximo(segundoNo);
            lista.diminuirTamanho();
        }
    }
   }   
}