package classroom.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private void handleLogin(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        // Exemplo de validação simples — substitua por sua lógica real depois
        if ("admin".equals(usuario) && "123".equals(senha)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/classroom/view/TeacherScreen.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Tela do Docente");
                stage.setScene(new Scene(root));
                stage.show();

                // Fechar janela de login atual
                Stage loginStage = (Stage) txtUsuario.getScene().getWindow();
                loginStage.close();
            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlerta("Erro ao carregar a próxima tela.");
            }
        } else {
            mostrarAlerta("Usuário ou senha incorretos!");
        }
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro de Login");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
