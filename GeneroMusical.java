//Criação do enum
public enum GeneroMusical{

  AXE("AXE"),
  FORRO("FORRO"),
  FUNK("FUNK"),
  MPB("MPB"),
  PAGODE("PAGODE"),
  POP("POP"),
  ROCK("ROCK"),
  SAMBA("SAMBA"),
  SERTANEJO("SERTANEJO");

  private String descricao;

  GeneroMusical(String descricao) {
        this.descricao = descricao;
    }
    
  public String getDescricao() {
      return descricao;
  }
}