package classroom.model.entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private final String ra;
    private final String nome;
    private final double a1;
    private final double a2;
    private final double a3;
    private int presente;
    private int faltante;
    private final List<Integer> notas;
    private final List<Turma> turmas;
    
    public Aluno(String ra, String nome, double a1, double a2, double a3){
        this.ra = ra;
        this.nome = nome;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.presente = 0;
        this.faltante = 0;
        this.notas = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }
    
    //Retorna RA do aluno
    public String getRa() {
        return ra;
    }
    
    //Retorna nome do aluno
    public String getNome() {
        return nome;
    }
    
    //Retorna no Aula do aluno
    public double getA1(){
        return a1;
    }
    
    public double getA2(){
        return a2;
    }
    
    public double getA3(){
        return a3;
    }
    
    //Retorna o número de faltas do aluno
    public int getFaltas(){
        return faltante;
    }
    
    //Retorna o número de presenças do aluno
    public int getPresenca(){
        return presente;
    }
    
    public void setPresenca(){
        presente++;
    }
    
    public void setFalta(){
        faltante++;
    }
    
    public void escolherTurma(Turma turma){
        if (turmas.size()<3 && !turmas.contains(turma))
        {
            turmas.add(turma);
        }
    }
    
    public void sairDaTurma(Turma turma){
        if (turmas.size() - 1 > 1){
            turmas.remove(turma);
        }
    }
    
    public void addNota(int nota) {
        if (notas.size() < 3) {
            notas.add(nota);
        }
    }
    
    public double getNotaFinal() {
        int nota_final = 0;
        
        if (notas.isEmpty()) return 0;
        
        for(int nota:notas)
        {
            nota_final = nota_final + nota;
        }
        
        return(a1 + a2 + a3) /3.0;
    }
}
