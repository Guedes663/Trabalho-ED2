public class ListaAndamento{
   private No cabeca;
   private No cauda;
   private int tamanho;
   
   public ListaAndamento(){
      cauda = new No();
      cabeca = new No();
      cabeca.setProximo(cauda);
      cauda.setAnterior(cabeca);
      tamanho = 0;
   }
   // O método abaixo esta errado, por favor, ser de Deus corrija-o 
   public void adicionarListaAndamento(ListaEspera elemento){
      for(No atual = cabeca.getProximo(); atual != cauda; atual = atual.getProximo()){
         System.out.println(elemento.getDados());
      }   
   }
}