package classroom.controller;

import classroom.model.entidades.Aluno;
import classroom.model.dao.AlunoDAO;
import classroom.model.entidades.Disciplina;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    private ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList().;
    private ObservableList<Disciplina> listaDeDisciplinas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Simulando lista de UCs
        comboUC.setItems(FXCollections.observableArrayList("Matemática", "Português", "História"));

        // Simulando lista de alunos
        listaAlunos.addAll(
            new Aluno("João", "123"),
            new Aluno("Maria", "456"),
            new Aluno("Carlos", "789")
        );

        // Ligando colunas às propriedades
        colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        colRA.setCellValueFactory(cellData -> cellData.getValue().raProperty());
        colA1.setCellValueFactory(cellData -> cellData.getValue().a1Property().asObject());
        colA2.setCellValueFactory(cellData -> cellData.getValue().a2Property().asObject());
        colA3.setCellValueFactory(cellData -> cellData.getValue().a3Property().asObject());
        colNotaFinal.setCellValueFactory(cellData -> cellData.getValue().notaFinalProperty().asObject());

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
    }*/
}
