package classroom.model.dao;

import java.util.ArrayList;
import java.util.List;

public class NotasDAO {
    private final List<Nota> notas = new ArrayList<>();

    public void adicionarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularMedia(Aluno aluno) {
        double a1 = 0, a2 = 0, a3 = 0;

        for (Nota nota : notas) {
            if (nota.getAluno().equals(aluno)) {
                switch (nota.getTipo().toLowerCase()) {
                    case "a1":
                        a1 = nota.getValor();
                        break;
                    case "a2":
                        a2 = nota.getValor();
                        break;
                    case "a3":
                        a3 = nota.getValor();
                        break;
                }
            }
        }

        return a1 * 0.3 + a2 * 0.3 + a3 * 0.4;
    }
}
