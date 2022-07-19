import java.io.Serializable;

public class Midia implements Serializable {
  private String tituloMusica;
  private String nomeArtista;
  private int anoLancamento;
  private int duracaoMin;
  private GeneroMusical generoMusical;
  int reproducao;

  //Criação do construtor padrão.
  Midia(String tituloMusica, String nomeArtista,int anoLancamento, int duracaoMin, GeneroMusical generoMusical){
      this.tituloMusica = tituloMusica;
      this.nomeArtista = nomeArtista;
      this.generoMusical = generoMusical;
      this.anoLancamento = anoLancamento;
      this.duracaoMin = duracaoMin;
      this.reproducao = 0;
  }

  //Criação dos metodos set e get.
  public void setTitulo(String tituloMusica){
    this.tituloMusica = tituloMusica;
  }
    
  public String getTitulo(){
    return tituloMusica;
  }

  public void setArtista(String nomeArtista){
    this.nomeArtista = nomeArtista;
  }

  public String getArtista(){
    return nomeArtista;
  }

  public void setAno(int anoLancamento){
    this.anoLancamento = anoLancamento;
  }

  public int getAno(){
    return anoLancamento;
  }

  public void setDuracao(int duracaoMin){
    this.duracaoMin = duracaoMin;
  }

  public String getDuracao(){
    String minSec = "";
    int min = 0;
    int sec = 0;

    sec = duracaoMin;
    while(sec > 59){
        min++;
        sec -= 60;
    }

    minSec = (String) ""+ min + ":" + sec;
    return minSec;
  }

  public void setGeneroMusical(GeneroMusical generoMusical){
    this.generoMusical = generoMusical;
  }

  
  public GeneroMusical getGeneroMusical(){
    return generoMusical;
  }

  public void setReproducao(){
    reproducao += 1;
  }

  public void alterarReproducao(){
    reproducao = 0;
  }

  public int getReproducao(){
    return reproducao;
  }

}