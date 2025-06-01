package classroom.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import classroom.model.entidades.Aluno;
import classroom.model.entidades.Notas;

public class NotasDAO {
    private final Connection conexao;
    private final DisciplinaDAO disciplinaDAO;
    private final AlunoDAO alunoDAO;

    public NotasDAO(Connection conexao, DisciplinaDAO disciplinaDAO, AlunoDAO alunoDAO) {
        this.conexao = conexao;
        this.disciplinaDAO = disciplinaDAO;
        this.alunoDAO = alunoDAO;
    }

    // Insere uma nota no banco de dados
    public void inserirNota(Notas nota) throws SQLException {
        String sql = "INSERT INTO notas (ra, tipo, valor) VALUES (?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nota.aluno().getRa());
        stmt.setString(2, nota.getTipo());
        stmt.setInt(3, nota.getValor());
        stmt.executeUpdate();
    }

    // Soma todas as notas do aluno
    public int somarNotasDoAluno(Aluno aluno) throws SQLException {
        String sql = "SELECT SUM(valor) as total FROM notas WHERE ra = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, aluno.getRa());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("total");
        }
        return 0;
    }

    // Mostra soma de todas as notas de um aluno
    public void mostrarSomaNotasAluno(Aluno aluno) throws SQLException {
        int soma = somarNotasDoAluno(aluno);
        System.out.println("Aluno: " + aluno.getNome() + " (RA: " + aluno.getRa() + ")");
        System.out.println("Soma das notas: " + soma);
    }
}