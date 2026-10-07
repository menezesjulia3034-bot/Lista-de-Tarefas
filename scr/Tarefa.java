package scr;

public class Tarefa {
    private static int proximoId = 1; //contador, um só para todas as tarefas
    private int id; //um para cada tarefa
    private String titulo; //um para cada tarefa
    private String descricao; //um para cada tarefa
    private Status status; //um para cada tarefa

    //construtor
public Tarefa(String titulo, String descricao) {
    this.id = proximoId;
    proximoId++;
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = Status.PENDENTE;
}    // o id recebe o contador, o contador sobe 1, título e descrição vêm de fora, toda tarefa nova nasce PENDENETE

//GETTERS
    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public Status getStatus(){
        return Status.PENDENTE;
    }

//SETTERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
//toString
@Override 
public String toString(){
    return "[" +this.id + "] " + this.status.getIcone() + " " + this.titulo + " - " + this.descricao;
}    
}

