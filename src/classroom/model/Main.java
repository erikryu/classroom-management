package classroom.model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Turma> turmas;
    private List<Professor> professores;
    
    public Main(){
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();
    }
    
    public void init(){
        //Lógica de funcionamento do programa
    }

    public static void main(String[] args) {
        Main sys = new Main();
        sys.init();
    }
    
}
