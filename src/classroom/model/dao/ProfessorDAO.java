package classroom.model.dao;

import classroom.model.entidades.Professor;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ProfessorDAO {
    private final Connection connection;
    
    public ProfessorDAO(Connection connection){
        this.connection = connection;
    }
    
    public void adicionarProfessor(Professor professor){
        String add_sql = "INSERT INTO Professor (nome, pcode) VALUES (?, ?);";
        
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(add_sql);
                
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getPcode());
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void removerProfessor(String pcode) {
        String remove_sql = "DELETE FROM Professor WHERE pcode=?";
        
        if (connection!=null){
            try{
                PreparedStatement stmt = connection.prepareStatement(remove_sql);
                
                stmt.setString(1, pcode);
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public List<Professor> listarTodos(){
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT id, nome, pcode FROM Professor";
        
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()){
                    Professor professor = new Professor(rs.getString("nome"), 
                        rs.getString("pcode"));
                    
                    professores.add(professor);
                }
                
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return professores;
    }
    
    public Professor listarPorCodigo(String pcode){
        String sql = "SELECT id, nome, pcode FROM Professor WHERE pcode=?";
        Professor professor = null;
        
        if(connection!=null) {
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, pcode);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    professor = new Professor(rs.getString("nome"), rs.getString("pcode"));
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }         
        }
        
        return professor;
    }
    
    public void atualizarProfessor(Professor professor){
        String sql = "UPDATE Professor SET nome=? WHERE pcode=?";
        if (connection!=null){
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getPcode());
                
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
