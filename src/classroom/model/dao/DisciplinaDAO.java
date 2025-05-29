package classroom.model.dao;

import classroom.model.entidades.Disciplina;
import classroom.model.entidades.Professor;
import classroom.model.dao.ProfessorDAO;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DisciplinaDAO {
    private final Connection connection;
    
    public DisciplinaDAO(Connection connection){
        this.connection = connection;
    }
    
    public void adicionarDisciplina(Disciplina disciplina, String pcode){
        String add_sql = "INSERT INTO Disciplina (nome, dcode, professor_code) VALUES (?, ?, ?);";
        
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(add_sql);
                
                stmt.setString(1, disciplina.getNome());
                stmt.setString(2, disciplina.getdCode());
                stmt.setString(3, pcode);
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void removerDisciplina(String dcode) {
        String remove_sql = "DELETE FROM Disciplina WHERE dcode=?";
        
        if (connection!=null){
            try{
                PreparedStatement stmt = connection.prepareStatement(remove_sql);
                
                stmt.setString(1, dcode);
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public List<Disciplina> listarTodos(){
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT id, nome, dcode, professor_code FROM Disciplina";
        
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()){
                        Disciplina disciplina = new Disciplina(rs.getString("nome"), 
                        rs.getString("dcode"));
                    
                    disciplinas.add(disciplina);
                }
                
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return disciplinas;
    }
    
    public Disciplina listarPorCodigo(String dcode){
        String sql = "SELECT id, nome, dcode, professor_code FROM Disciplina WHERE dcode=?";
        Disciplina disciplina = null;
        
        if(connection!=null) {
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, dcode);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    disciplina = new Disciplina(rs.getString("nome"), rs.getString("dcode"));
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }         
        }
        
        return disciplina;
    }
    
    public void atualizarDisciplina(Disciplina disciplina, String pcode){
        String sql = "UPDATE Disciplina SET nome=?, professor_code=? WHERE dcode=?";
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                
                stmt.setString(1, disciplina.getNome());
                stmt.setString(2, pcode);
                stmt.setString(3, disciplina.getdCode());
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
