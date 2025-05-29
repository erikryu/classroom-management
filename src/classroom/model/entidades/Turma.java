package classroom.model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private final String nome;
    private final String tcode;
    private final Disciplina disciplina;
    private final List<Aluno> alunos;
    
    public Turma(String nome, String tcode)
    {
        this.nome = nome;
        this.tcode = tcode;
        this.disciplina = null;
        this.alunos = new ArrayList<>();
    }
    
    public Disciplina getDisciplina(){
        return disciplina;
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
