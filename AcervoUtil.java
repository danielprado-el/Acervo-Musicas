import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class AcervoUtil {
  public static void main() {
    // Criação do arquivo de dados
    File arquivo = new File("Acervo.dat");

    // Criação da lista acervo
    Acervo acervo = new Acervo();

    // MENU
    char op = 'x';

    try{
        if(arquivo.exists()){
        
        // Criação do leitor de arquivo
        FileInputStream leitorArquivo = new FileInputStream (arquivo);

        // Criação do leitor de objeto
        ObjectInputStream leitorObjetos = new ObjectInputStream(leitorArquivo);

        // Inserindo os objetos no Acervo   
        acervo = (Acervo)leitorObjetos.readObject();

        // Fechando os leitores          
        leitorObjetos.close();
        leitorArquivo.close();
      }

    do {
      try{
      op = JOptionPane.showInputDialog(null, "DIGITE A OPERAÇÃO DESEJADA:\n\nA - ADICIONAR MIDIA\nB - LISTAR MIDIAS\nC - REPRODUZIR MIDIA\nD - ALTERAR MIDIA\nE - EXCLUIR MIDIA\nF - ADICIONAR MIDIA EM UMA POSIÇÃO ESPECIFICA\nG - LISTAR MIDIAS POR ARTISTA\nH - LISTAR MIDIAS POR GÊNERO\nI - QUANTIDADE DE MIDIAS POR GÊNERO\nJ - PERCENTUAL DE MIDIAS DO ARTISTA\nK - LISTAR MIDIAS JÁ REPRODUZIDAS\nL - LISTAR MIDIAS NÃO REPRODUZIDAS\nM - TOP5\n\n", "MENU", JOptionPane.PLAIN_MESSAGE).charAt(0);
      }
      catch(NullPointerException e){
        JOptionPane.showMessageDialog(null, "ACERVO ENCERRADO!!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        op = 'x';
      }
      catch(StringIndexOutOfBoundsException e){
        JOptionPane.showMessageDialog(null, "DIGITE ALGUMA OPERAÇÃO!!!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        op = '1';
      }

      switch(op) {
        case 'A':
        case 'a':
          String tituloMusica = "";
          String nomeArtista = "";
          int anoLancamento = 0;
          int duracaoMin = 0;
          GeneroMusical generoMusical = null;
          try{
          tituloMusica = JOptionPane.showInputDialog(null, "Digite o titulo da Música: ", "MENU", JOptionPane.PLAIN_MESSAGE);

          nomeArtista = JOptionPane.showInputDialog(null, "Digite o nome do artista: ", "MENU", JOptionPane.PLAIN_MESSAGE);

          anoLancamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de lançamento: ", "MENU", JOptionPane.PLAIN_MESSAGE));

          duracaoMin = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tempo de duração em segundos: ", "MENU", JOptionPane.PLAIN_MESSAGE));

          generoMusical = GeneroMusical.valueOf(JOptionPane.showInputDialog(null, "Digite um dos gêneros musicais disponiveis a baixo:\n\n[AXE | FORRO | FUNK |  MPB | PAGODE | POP | ROCK | SAMBA | SERTANEJO]\n\n", "MENU", JOptionPane.PLAIN_MESSAGE).toUpperCase());
          }
          catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }
          catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }
          
          acervo.addMidia(tituloMusica, nomeArtista, anoLancamento, duracaoMin, generoMusical);
          break;

        case 'B':
        case 'b':
          acervo.listar();
          break;

        case 'C':
        case 'c':
          String tituloMusica3 = JOptionPane.showInputDialog(null, "Digite o titulo da midia:\n", "MENU", JOptionPane.PLAIN_MESSAGE);

          String nomeArtista3 = JOptionPane.showInputDialog(null, "Digite o nome do artista da midia:\n", "MENU", JOptionPane.PLAIN_MESSAGE);

          acervo.reproduzirMidia(tituloMusica3, nomeArtista3);
          break;
        
        case 'D':
        case 'd':
          int index1 = 0;
          String tituloMusica1 = "";
          String nomeArtista1 = "";
          int anoLancamento1 = 0;
          int duracaoMin1 = 0;
          GeneroMusical generoMusical1 = null;
          try{
          index1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a posição da midia que deseja alterar: \n", "MENU", JOptionPane.PLAIN_MESSAGE));

          tituloMusica1 = JOptionPane.showInputDialog(null, "Digite o titulo da Música: \n", "MENU", JOptionPane.PLAIN_MESSAGE);

          nomeArtista1 = JOptionPane.showInputDialog(null, "Digite o nome do artista: \n", "MENU", JOptionPane.PLAIN_MESSAGE);
          
          anoLancamento1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de lançamento: \n", "MENU", JOptionPane.PLAIN_MESSAGE));

          duracaoMin1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tempo de duração em segundos: \n", "MENU", JOptionPane.PLAIN_MESSAGE));

          generoMusical1 = GeneroMusical.valueOf(JOptionPane.showInputDialog(null, "Digite um dos gêneros musicais disponiveis a baixo:\n\n[AXE | FORRO | FUNK |  MPB | PAGODE | POP | ROCK | SAMBA | SERTANEJO]\n\n", "MENU", JOptionPane.PLAIN_MESSAGE).toUpperCase());
          }
          catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }
          catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }
          catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }

          acervo.setMidia(index1, tituloMusica1, nomeArtista1, anoLancamento1, duracaoMin1, generoMusical1);
          break;

        case 'E':
        case 'e':
          int index2 = 0;
          try{
          index2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a posição da midia que deseja excluir: \n", "MENU", JOptionPane.PLAIN_MESSAGE));
          }
          catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }
          
          acervo.removerMidia(index2);
          break;
        
        case 'F':
        case 'f':
          int index3 = 0;
          String tituloMusica5 = "";
          String nomeArtista5 = "";
          int anoLancamento5 = 0;
          int duracaoMin5 = 0;
          GeneroMusical generoMusical5 = null;
          try{
          index3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a posição onde quer adicionar a midia: \n", "MENU", JOptionPane.PLAIN_MESSAGE));

          tituloMusica5 = JOptionPane.showInputDialog(null, "Digite o titulo da Música: \n", "MENU", JOptionPane.PLAIN_MESSAGE);

          nomeArtista5 = JOptionPane.showInputDialog(null, "Digite o nome do artista: \n", "MENU", JOptionPane.PLAIN_MESSAGE);

          anoLancamento5 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano de lançamento: \n", "MENU", JOptionPane.PLAIN_MESSAGE));

          duracaoMin5 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tempo de duração em segundos: \n", "MENU", JOptionPane.PLAIN_MESSAGE));

          generoMusical5 = GeneroMusical.valueOf(JOptionPane.showInputDialog(null, "Digite um dos gêneros musicais disponiveis a baixo:\n\n[AXE | FORRO | FUNK |  MPB | PAGODE | POP | ROCK | SAMBA | SERTANEJO]\n\n", "MENU", JOptionPane.PLAIN_MESSAGE).toUpperCase());
          }
          catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }
          catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }

          acervo.addMidia(index3, tituloMusica5, nomeArtista5, anoLancamento5, duracaoMin5, generoMusical5);
          break;

        case 'G':
        case 'g':
          String nomeArtista2 = JOptionPane.showInputDialog(null, "Digite o nome do artista desejado: \n", "MENU", JOptionPane.PLAIN_MESSAGE);

          acervo.getMidiaNome(nomeArtista2);
          break;

        case 'H':
        case 'h':
          GeneroMusical generoMusical2 = null;
          try{
          generoMusical2 = GeneroMusical.valueOf(JOptionPane.showInputDialog(null, "Digite o nome do genero desejado: \n", "MENU", JOptionPane.PLAIN_MESSAGE).toUpperCase());
          }
          catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "DADO INSERIDO INCORRETAMENTE!!!", "Mensagem", JOptionPane.ERROR_MESSAGE);
            break;
          }

          acervo.getMidiaGenero(generoMusical2);
          break;

        case 'I':
        case 'i':
          acervo.getQtdMidiasGenero();
          break;

        case 'J':
        case 'j':
          String nomeArtista4 = JOptionPane.showInputDialog(null, "Digite o nome do artista: \n", "MENU", JOptionPane.PLAIN_MESSAGE);

          acervo.getPercentualMidiasArtista(nomeArtista4);
          break;

        case 'K':
        case 'k':
          acervo.getQtdReproducoesMidia();
          break;
        
        case 'L':
        case 'l':
          acervo.getMidiasNaoReproduzidas();
          break;

        case 'M':
        case 'm':
          acervo.top5();
          break;
      }
    } while (op != 'x');

			FileOutputStream escritorArquivo = new FileOutputStream(arquivo);
			ObjectOutputStream escritorObjetos = new ObjectOutputStream(escritorArquivo);			
			escritorObjetos.writeObject(acervo);
			
			escritorObjetos.close();
			escritorArquivo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
  }
}