package classroom.model.dao;

import classroom.model.entidades.Aluno;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class AlunoDAO {
    private final Connection connection;
    
    public AlunoDAO(Connection connection){
        this.connection = connection;
    }
    
    public void adicionarAluno(Aluno aluno){
        String add_sql = "INSERT INTO Aluno (nome, ra, presencas, faltas) VALUES (?, ?, ?, ?);";
        
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(add_sql);
                
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getRa());
                stmt.setInt(3, aluno.getPresenca());
                stmt.setInt(4, aluno.getFaltas());
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void removerAluno(String ra) {
        String remove_sql = "DELETE FROM Aluno WHERE ra=?";
        
        if (connection!=null){
            try{
                PreparedStatement stmt = connection.prepareStatement(remove_sql);
                
                stmt.setString(1, ra);
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public List<Aluno> listarTodos(){
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, ra, nome, presencas, faltas FROM Aluno";
        
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()){
                    Aluno aluno = new Aluno(rs.getString("ra"), 
                        rs.getString("nome"));
                    
                    alunos.add(aluno);
                }
                
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return alunos;
    }
    
    public Aluno listarPorRa(String ra){
        String sql = "SELECT id, ra, nome, presenca, faltas FROM Aluno WHERE ra=?";
        Aluno aluno = null;
        
        if(connection!=null) {
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, ra);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    aluno = new Aluno(rs.getString("ra"), rs.getString("nome"));
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }         
        }
        
        return aluno;
    }
    
    public void atualizarAluno(Aluno aluno){
        String sql = "UPDATE Aluno SET nome=?, presencas=?, faltas=? WHERE ra=?";
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                
                stmt.setString(1, aluno.getNome());
                stmt.setInt(2, aluno.getPresenca());
                stmt.setInt(3, aluno.getPresenca());
                stmt.setString(4, aluno.getRa());
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
