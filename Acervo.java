import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.Serializable;

public class Acervo implements Serializable{ 

  private List<Midia> acervo = new ArrayList<Midia>();

  // Listar Array
  public void listar(){
    if(acervo.size() > 0){
      for(int i=0; i<acervo.size(); i++){
        JOptionPane.showMessageDialog(null, "\nPosição: "+ (i+1) +"\nTitulo da Musica: " + acervo.get(i).getTitulo() + "\nNome do Artista: "+ acervo.get(i).getArtista() +"\nAno de lançamento: " + acervo.get(i).getAno() + "\nDuração da musica: " + acervo.get(i).getDuracao()+" Min"+"\nGenero Musical: "+ acervo.get(i).getGeneroMusical()+"\n\n", "MENU", JOptionPane.PLAIN_MESSAGE);
    } 
    } else{
      JOptionPane.showMessageDialog(null, "NENHUMA MÚSICA ADICIONADA!!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  // Metodo para adicionar Midia no Acervo sem index.
  public void addMidia(String tituloMusica, String nomeArtista, int anoLancamento, int  duracaoMin, GeneroMusical generoMusical){
    boolean verificacao = true;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getTitulo().equals(tituloMusica) && acervo.get(i).getArtista().equals(nomeArtista) || anoLancamento < 0 || duracaoMin < 0){
    
      verificacao = false;
      
      }
    }
    if(!verificacao){
      JOptionPane.showMessageDialog(null, "MUSICA JÁ ADICIONADA OU DADO INSERIDO INCORRETAMENTE!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    if(verificacao){
      acervo.add(new Midia(tituloMusica, nomeArtista, anoLancamento, duracaoMin, generoMusical));

      JOptionPane.showMessageDialog(null, "MIDIA ADICIONADA COM SUCESSO!!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  // Metodo para adicionar midia em uma determinada posição .
  public void addMidia(int index, String tituloMusica, String nomeArtista, int anoLancamento, int duracaoMin, GeneroMusical generoMusical){
    boolean verificacao = true;

    int xIndex = (int) (index-1);

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getTitulo().equals(tituloMusica) && acervo.get(i).getArtista().equals(nomeArtista) || anoLancamento < 0 || duracaoMin < 0 || index <= 0 || index-1 > acervo.size()){
    
      verificacao = false;
      
    }
    }

    if(!verificacao){
      JOptionPane.showMessageDialog(null, "MUSICA JÁ ADICIONADA OU DADO INSERIDO INCORRETAMENTE!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
    
    if(verificacao){
      acervo.add(xIndex, new Midia(tituloMusica, nomeArtista, anoLancamento, duracaoMin, generoMusical));

      JOptionPane.showMessageDialog(null, "MIDIA ADICIONADA COM SUCESSO!!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  // Alterar midia
  public void setMidia(int index, String tituloMusica, String nomeArtista, int anoLancamento, int duracaoMin, GeneroMusical generoMusical){
    boolean verificacao = true;

    int xIndex = (int) (index-1);
    if(xIndex > acervo.size() || index < 0 || acervo.size() == 0){
      JOptionPane.showMessageDialog(null, "A POSIÇÃO INDICADA NÃO ESTÁ OCUPADA OU É UMA POSIÇÃO INVALIDA", "ERRO", JOptionPane.ERROR_MESSAGE);
      verificacao = false;
    }

    if(verificacao){
      acervo.set(xIndex, new Midia(tituloMusica, nomeArtista, anoLancamento, duracaoMin,generoMusical));

      JOptionPane.showMessageDialog(null, "MIDIA ALTERADA COM SUCESSO!!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

    }
  }

  //Metodo para remover Midia adicionada
  public void removerMidia(int index){
    boolean verificacao = true;

    int xIndex = (int) (index-1);
    if(xIndex < 0 || xIndex >= acervo.size()){
      JOptionPane.showMessageDialog(null, "NÃO EXISTE MIDIA NESSA POSIÇÃO DO ACERVO!!", "ERRO", JOptionPane.ERROR_MESSAGE);

      verificacao = false;
    }

    if(verificacao){

    JOptionPane.showMessageDialog(null, "A SEGUINTE MIDIA FOI REMOVIDA:\n\nTitulo da Musica: " + acervo.get(xIndex).getTitulo() + "\nAno de lançamento: " + acervo.get(xIndex).getAno() + "\nDuração da musica: " + acervo.get(xIndex).getDuracao()+" Min", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

    acervo.remove(xIndex);
    }
  }
 
  //Metodo para pegar a midia pelo nome do artista.
  public void getMidiaNome(String nomeArtista){
    boolean verificacao = true;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getArtista().equals(nomeArtista)){
        JOptionPane.showMessageDialog(null, "========MIDIAS DO ARTISTA========\nTitulo da Musica: " + acervo.get(i).getTitulo() + "\nAno de lançamento: " + acervo.get(i).getAno() + "\nDuração da musica: " + acervo.get(i).getDuracao()+" Min", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        verificacao = false;
      }
    } 
    if(verificacao){
      JOptionPane.showMessageDialog(null, "ARTISTA NÃO ADICIONADO OU DIGITADO INCORRETAMENTE!!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
  }

  //Metodo para pegar a midia pelo genero.
  public void getMidiaGenero(GeneroMusical generoMusical){
    boolean verificacao = true;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getGeneroMusical().equals(generoMusical)){
        JOptionPane.showMessageDialog(null, "========MIDIAS DO GENERO========\nTitulo da Musica: " + acervo.get(i).getTitulo() + "\nAno de lançamento: " + acervo.get(i).getAno() + "\nDuração da musica: " + acervo.get(i).getDuracao()+" Min", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        verificacao = false;
      }
    }
    if(verificacao){
      JOptionPane.showMessageDialog(null, "GÊNERO DE MÚSICA NÃO ADICIONADO OU DIGITADO INCORRETAMENTE!!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    } 
  }
  
  //Metodo para reproduzir musica
  public void reproduzirMidia(String tituloMusica, String nomeArtista){
    boolean verificacao = true;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getTitulo().equals(tituloMusica) && acervo.get(i).getArtista().equals(nomeArtista)){
        acervo.get(i).setReproducao();
        JOptionPane.showMessageDialog(null, "MIDIA REPRODUZIDA COM SUCESSO!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        verificacao = false;
      }
    }
      if(verificacao){
        JOptionPane.showMessageDialog(null, "MIDIA NÃO ADICIONADA OU DIGITADO INCORRETAMENTE!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  //Metodo para ver a quantidade de midias por genero;
  public void getQtdMidiasGenero() {
    int axe = 0, forro = 0, funk = 0, mpb = 0, pagode = 0, pop = 0, rock = 0, samba = 0, sertanejo = 0;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.AXE){
        axe++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.FORRO){
        forro++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.FUNK){
        funk++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.MPB){
        mpb++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.PAGODE){
        pagode++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.POP){
        pop++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.ROCK){
        rock++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.SAMBA){
        samba++;
      }
      if(acervo.get(i).getGeneroMusical() == GeneroMusical.SERTANEJO){
        sertanejo++;
      }
    }

    JOptionPane.showMessageDialog(null, "========QUANTIDADE DE MIDIAS POR GÊNERO========\n\n|AXE: "+ axe +" |FORRO: "+ forro +" |FUNK: "+ funk +" |MPB: "+ mpb +" |PAGODE: "+ pagode +" |POP: "+ pop +" |ROCK: "+ rock +" |SAMBA: "+ samba +" |SERTANEJO: "+ sertanejo, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
  }

  // Metodo para pegar o percentual de midias adicionadas por artista
  public void getPercentualMidiasArtista(String nomeArtista){
    boolean verificacao = true;
    int qtd = 0;
    
    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getArtista().equals(nomeArtista)){
      qtd++;

      verificacao = false;
      }
    }
    if(verificacao){
      JOptionPane.showMessageDialog(null, "NENHUMA MIDIA DESSE ARTISTA FOI ADICIONADA OU NOME DIGITADO INCORRETAMENTE!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    if(!verificacao){
    double percentual = (qtd*100)/acervo.size();
    
    JOptionPane.showMessageDialog(null, "O PERCENTUAL DE MIDIAS DESSE ARTISTA É: "+ percentual+"%", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  // Metodo para pegar a quantidade de midias de audio por reproduções
  public void  getQtdReproducoesMidia(){
    boolean verificacao = true;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getReproducao() > 0){
        JOptionPane.showMessageDialog(null, "========MIDIAS QUE jÁ FORAM REPRODUZIDAS========\nTitulo da Musica: " + acervo.get(i).getTitulo() + "\nNome do Artista: "+ acervo.get(i).getArtista() +"\nAno de lançamento: " + acervo.get(i).getAno() + "\nDuração da musica: " + acervo.get(i).getDuracao()+" Min"+"\nGenero Musical: "+ acervo.get(i).getGeneroMusical()+"\nN° Reproduções: "+ acervo.get(i).getReproducao(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        verificacao = false;
      }
    }
    if(verificacao){
      JOptionPane.showMessageDialog(null, "NENHUMA MIDIA FOI REPRODUZIDA ATÉ O MOMENTO!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  // Metodo para pegar a quantidade de midias de audio não reproduzidas
  public void getMidiasNaoReproduzidas(){
    boolean verificacao = true;

    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getReproducao() == 0){
        JOptionPane.showMessageDialog(null, "========MIDIAS QUE NÃO FORAM REPRODUZIDAS========\nTitulo da Musica: " + acervo.get(i).getTitulo() + "\nNome do Artista: "+ acervo.get(i).getArtista() +"\nDuração: "+ acervo.get(i).getDuracao()+" Min", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        verificacao = false;
      }
    }
    if(verificacao){
      JOptionPane.showMessageDialog(null, "TODAS AS MIDIAS JÁ FORAM REPRODUZIDAS OU NENHUMA MIDIA ADICIONADA!!", "ERRO", JOptionPane.ERROR_MESSAGE);
    }
  }

  // Metodo para mostrar o top5 musicas mais reproduzidas
  public void top5(){
    if(acervo.size()>0){
    Midia TOP1 = acervo.get(0);
    Midia TOP2 = acervo.get(0);
    Midia TOP3 = acervo.get(0);
    Midia TOP4 = acervo.get(0);
    Midia TOP5 = acervo.get(0);

    TOP1.alterarReproducao();
    TOP2.alterarReproducao();
    TOP3.alterarReproducao();
    TOP4.alterarReproducao();
    TOP5.alterarReproducao();

    int valor = 0;
    int valor2 = 0;
    int valor3 = 0;
    int valor4 = 0;
    int valor5 = 0;
    for(int i=0; i<acervo.size(); i++){
      if(acervo.get(i).getReproducao() > valor){
      valor = acervo.get(i).getReproducao();
      TOP1 = acervo.get(i);
      }

      for(int j=0; j<acervo.size(); j++){
        if(acervo.get(j).getReproducao() > valor2 && acervo.get(j).getReproducao() <= TOP1.getReproducao() && !acervo.get(j).equals(TOP1)){
        valor2 = acervo.get(j).getReproducao();
        TOP2 = acervo.get(j);
        }
        
        for(int k=0; k<acervo.size(); k++){
          if(acervo.get(k).getReproducao() > valor3 && acervo.get(k).getReproducao() <= TOP2.getReproducao() && !acervo.get(k).equals(TOP2) && !acervo.get(k).equals(TOP1)){
          valor3 = acervo.get(k).getReproducao();
          TOP3 = acervo.get(k);
          }

          for(int l=0; l<acervo.size(); l++){
            if(acervo.get(l).getReproducao() > valor4 && acervo.get(l).getReproducao() <= TOP3.getReproducao() && !acervo.get(l).equals(TOP3) && !acervo.get(l).equals(TOP2) &&!acervo.get(l).equals(TOP1)){
              valor4 = acervo.get(l).getReproducao();
              TOP4 = acervo.get(l);
            }

            for(int m=0; m<acervo.size(); m++){
              if(acervo.get(m).getReproducao() > valor5 && acervo.get(m).getReproducao() <= TOP4.getReproducao() && !acervo.get(m).equals(TOP2) && !acervo.get(m).equals(TOP1) &&!acervo.get(m).equals(TOP3) && !acervo.get(m).equals(TOP4)){
              valor5 = acervo.get(m).getReproducao();
              TOP5 = acervo.get(m);
              }
            }
          }
        }
      }
    }
    if(TOP1.getReproducao()>0){
    JOptionPane.showMessageDialog(null, "=================TOP1=================\nTitulo da Musica: " + TOP1.getTitulo() + "\nNome do Artista: "+ TOP1.getArtista() +"\nAno de lançamento: " + TOP1.getAno() + "\nDuração da musica: " + TOP1.getDuracao()+" Min"+"\nGenero Musical: "+ TOP1.getGeneroMusical() + "\nN° de Reproduções: "+ TOP1.getReproducao(), "MENU", JOptionPane.PLAIN_MESSAGE);
    }

    if(TOP2.getReproducao()>0){
    JOptionPane.showMessageDialog(null, "=================TOP2=================\nTitulo da Musica: " + TOP2.getTitulo() + "\nNome do Artista: "+ TOP2.getArtista() +"\nAno de lançamento: " + TOP2.getAno() + "\nDuração da musica: " + TOP2.getDuracao()+" Min"+"\nGenero Musical: "+ TOP2.getGeneroMusical() + "\nN° de Reproduções: "+ TOP2.getReproducao(), "MENU", JOptionPane.PLAIN_MESSAGE);
    }

    if(TOP3.getReproducao()>0){
    JOptionPane.showMessageDialog(null, "=================TOP3=================\nTitulo da Musica: " + TOP3.getTitulo() + "\nNome do Artista: "+ TOP3.getArtista() +"\nAno de lançamento: " + TOP3.getAno() + "\nDuração da musica: " + TOP3.getDuracao()+" Min"+"\nGenero Musical: "+ TOP3.getGeneroMusical() + "\nN° de Reproduções: "+ TOP3.getReproducao(), "MENU", JOptionPane.PLAIN_MESSAGE);
    }

    if(TOP4.getReproducao()>0){
    JOptionPane.showMessageDialog(null, "=================TOP4=================\nTitulo da Musica: " + TOP4.getTitulo() + "\nNome do Artista: "+ TOP4.getArtista() +"\nAno de lançamento: " + TOP4.getAno() + "\nDuração da musica: " + TOP4.getDuracao()+" Min"+"\nGenero Musical: "+ TOP4.getGeneroMusical() + "\nN° de Reproduções: "+ TOP4.getReproducao(), "MENU", JOptionPane.PLAIN_MESSAGE);
    }

    if(TOP5.getReproducao()>0){
    JOptionPane.showMessageDialog(null, "=================TOP5=================\nTitulo da Musica: " + TOP5.getTitulo() + "\nNome do Artista: "+ TOP5.getArtista() +"\nAno de lançamento: " + TOP5.getAno() + "\nDuração da musica: " + TOP5.getDuracao()+" Min"+"\nGenero Musical: "+ TOP5.getGeneroMusical() + "\nN° de Reproduções: "+ TOP5.getReproducao(), "MENU", JOptionPane.PLAIN_MESSAGE);
    }
  }else {
    JOptionPane.showMessageDialog(null, "NENHUMA MIDIA ADICIONADA!!", "ERRO", JOptionPane.ERROR_MESSAGE);
  } 
  }
}

