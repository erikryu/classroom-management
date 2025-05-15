package classroom;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private final String nome;
    private final List<Turma> turmas;
    
    Professor(String nome){
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }
    
    public String getNome(){
        return nome;
    }
    
    public List<Turma> getTurmas(){
        return turmas;
    }
    
    public void addTurma(Turma turma){
        turmas.add(turma);
    }
    
    public void addAlunoTurma(Turma turma, Aluno aluno){
        if (turmas.contains(turma)) {
            turma.adicionarAluno(aluno);
        }
    }
    
    public void addPresente(Turma turma, Aluno aluno){
        if (turmas.contains(turma) && turma.getAlunos().contains(aluno)){
            aluno.setPresenca();
        }
    }
    
    public void addFalta(Turma turma, Aluno aluno){
        if (turmas.contains(turma) && turma.getAlunos().contains(aluno)){
            aluno.setFalta();
        }
    }
    
}
