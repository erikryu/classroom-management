package classroom.model.entidades;

import classroom.model.entidades.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private final String nome;
    private final String pcode;
    private final List<Disciplina> disciplinas;
    
    public Professor(String nome, String pcode){
        this.nome = nome;
        this.pcode = pcode;
        this.disciplinas = new ArrayList<>();
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getPcode(){
        return pcode;
    }
    
    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }
    
    public void escolherDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }    
}
