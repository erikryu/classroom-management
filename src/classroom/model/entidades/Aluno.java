package classroom.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private final String ra;
    private final String nome;
    private int presente;
    private int faltante;
    private final List<Integer> notas;
    
    Aluno(String ra, String nome){
        this.ra = ra;
        this.nome = nome;
        this.presente = 0;
        this.faltante = 0;
        this.notas = new ArrayList<>();
    }
    
    //Retorna RA do aluno
    public String getRa() {
        return ra;
    }
    
    //Retorna nome do aluno
    public String getNome() {
        return nome;
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
    
    public void addNota(int nota) {
        if (notas.size() < 3) {
            notas.add(nota);
        }
    }
    
    public double setNotaFinal() {
        int nota_final = 0;
        
        if (notas.isEmpty()) return 0;
        
        for(int nota:notas)
        {
            nota_final = nota_final + nota;
        }
        
        return nota_final;
    }
}
