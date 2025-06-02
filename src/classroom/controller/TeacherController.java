package classroom.controller;

import classroom.model.entidades.Aluno;
import classroom.model.entidades.Disciplina;
import classroom.model.dao.AlunoDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleObjectProperty;
        
public class TeacherController {

    @FXML
    private ComboBox<String> comboUC;

    @FXML
    private TableView<Aluno> tableAlunos;

    @FXML
    private TableColumn<Aluno, String> colNome;

    @FXML
    private TableColumn<Aluno, String> colRA;

    @FXML
    private TableColumn<Aluno, Double> colA1;

    @FXML
    private TableColumn<Aluno, Double> colA2;

    @FXML
    private TableColumn<Aluno, Double> colA3;

    @FXML
    private TableColumn<Aluno, Double> colNotaFinal;

    @FXML
    private Button btnSalvar;

    private ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();
    private ObservableList<Disciplina> listaDeDisciplinas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Simulando lista de UCs
        comboUC.setItems(FXCollections.observableArrayList("Matemática", "Português", "História"));

        // Simulando lista de alunos
        listaAlunos.addAll(
            new Aluno("João", "123",6.0,7.5,8.0),
            new Aluno("Maria", "456", 9.0,8.0,7.5),
            new Aluno("Carlos", "789", 7.5,4.0,5.5)
        );

        // Ligando colunas às propriedades
        colNome.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue() .getNome()));
        colRA.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getRa()));
        colA1.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getA1()));
        colA2.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getA2()));
        colA3.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getA3()));
        colNotaFinal.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNotaFinal()));                                                                                    

        // Preenchendo a tabela
        tableAlunos.setItems(listaAlunos);
    }
    @FXML
    private void salvarAluno() {
        // Lógica de salvar aluno (simulação por enquanto)
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Salvar");
        alert.setHeaderText(null);
        alert.setContentText("Dados dos alunos salvos com sucesso!");
        alert.showAndWait();
    }
/*    
    // Classe interna representando o aluno (temporária)
    public static class Aluno {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty ra;
    private final SimpleDoubleProperty a1;
    private final SimpleDoubleProperty a2;
    private final SimpleDoubleProperty a3;
    private final SimpleDoubleProperty notaFinal;
    public Aluno(String nome, String ra, double a1, double a2, double a3) {
    this.nome = new SimpleStringProperty(nome);
    this.ra = new SimpleStringProperty(ra);
    this.a1 = new SimpleDoubleProperty(a1);
    this.a2 = new SimpleDoubleProperty(a2);
    this.a3 = new SimpleDoubleProperty(a3);
    this.notaFinal = new SimpleDoubleProperty((a1 + a2 + a3) / 3);
    }
    public StringProperty nomeProperty() { return nome; }
    public StringProperty raProperty() { return ra; }
    public DoubleProperty a1Property() { return a1; }
    public DoubleProperty a2Property() { return a2; }
    public DoubleProperty a3Property() { return a3; }
    public DoubleProperty notaFinalProperty() { return notaFinal; }
    }*/}
