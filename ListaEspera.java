import java.util.Scanner;

public class ListaEspera extends Lista{
      
   public void ordenarLista(Lista listaEspera){
    if(listaEspera.getTamanho() > 1){
        No atual = listaEspera.getCabeca();
        No proximo;
        boolean houveTroca = true;
        while(houveTroca){
            houveTroca = false;
            atual = atual.getProximo();
            while(atual != listaEspera.getCauda()){
                proximo = atual.getProximo();
                try {
                    if(atual.getDados().getPontuacaoDeHabilidade() < proximo.getDados().getPontuacaoDeHabilidade()){
                        Jogador temp = atual.getDados();
                        atual.setDados(proximo.getDados().getID(), proximo.getDados().getRole(), proximo.getDados().getPontuacaoDeHabilidade());
                        proximo.setDados(temp.getID(), temp.getRole(), temp.getPontuacaoDeHabilidade());
                        houveTroca = true;
                    }
                } catch (NullPointerException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                atual = atual.getProximo();
            }
            atual = listaEspera.getCabeca();
        }
    }
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
}