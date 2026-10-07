package scr;

public enum Status {
   PENDENTE("🚧"), EM_ANDAMENTO ("⏳"), CONCLUIDA ("✅");

   private final String icone;

   Status(String icone) {
    this.icone = icone;
   }

   public String getIcone(){
    return icone;
   }
}