public class Main{
   public static void main(String[] args){
      Menu gerenciadorMenu = new Menu();
      ListaEspera gerenciar = new ListaEspera();
      
      gerenciadorMenu.menu();
      gerenciar.printListaEspera();
   }
}