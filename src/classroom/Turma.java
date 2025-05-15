package classroom;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final String disciplina;
    private final Professor professor;
    private final List<Aluno> alunos;
    
    Turma(String disciplina, Professor professor)
    {
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
    
    public String getDisciplina(){
        return disciplina;
    }
    
    public Professor getProfessor(){
        return professor;
    }
    
    public List<Aluno> getAlunos(){
        return alunos;
    } 
    
    public void adicionarAluno(Aluno aluno){
        if (!alunos.contains(aluno)){
            alunos.add(aluno);
        }
    }
    
    public void removerAluno(Aluno aluno){
        alunos.remove(aluno);
    }
    
    public Aluno procurarAluno(String ra){
        for(Aluno aluno:alunos){
            if(aluno.getRa().equals(ra)){
                return aluno;
            }
        }
        
        return null;
    }
}
