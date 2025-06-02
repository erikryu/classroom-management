package classroom.model.entidades;

import classroom.model.entidades.Professor;
import classroom.model.entidades.Turma;

import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    private final String nome;
    private final String dCode;
    private final Professor professor;
    private List<Turma> turmas;
    
    public Disciplina(String nome, String dCode){
        this.nome = nome;
        this.dCode = dCode;
        this.professor = null;
        this.turmas = new ArrayList<>();
    }
    
    public String getdCode(){
        return dCode;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void adicionarTurmas(Turma turma){
        if (turmas.size()<2){
            turmas.add(turma);
        }
    }
    
    public void removerTurma(Turma turma){
        if (turmas.contains(turma)){
            turmas.remove(turma);
        }
    }
    
    
}
