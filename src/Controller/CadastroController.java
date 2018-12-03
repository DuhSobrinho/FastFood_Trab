package Controller;

import Model.Colaborador;
import Model.EnumFuncoes;
import Model.EnumTipoPessoa;
import Model.Fornecedor;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class CadastroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtSenha;

    @FXML
    private AnchorPane MainPane;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnCancelar;

    @FXML
    private Pane paneLogin;

    @FXML
    private ComboBox<EnumTipoPessoa> cbTipo;

    @FXML
    private ComboBox<EnumFuncoes> cbFuncao;

    @FXML
    void verificaTipoPessoa(ActionEvent event) {
        if (cbTipo.getValue() == EnumTipoPessoa.Colaborador) {
            paneLogin.setVisible(true);
        }
    }

    @FXML
    void action_btnSalvar(ActionEvent event) throws Exception {
        if (cbTipo.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cbFuncao.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma função!", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escreva um nome", "Atenção!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cbTipo.getValue() == EnumTipoPessoa.Colaborador) {
            Colaborador colaborador = new Colaborador();

            colaborador.setNome(txtNome.getText());
            colaborador.setFuncao(cbFuncao.getValue().toString());
            colaborador.setTipo(cbTipo.getValue().toString());
            colaborador.setUsuario(txtLogin.getText());
            colaborador.setUsuario(txtSenha.getText());

            ColaboradorDAO.Add(colaborador);
        }else{
            Fornecedor fornecedor = new Fornecedor();
            
            fornecedor.setNome(txtNome.getText());
            
            FornecedorDAO.Add(fornecedor);
        }
    }

    @FXML
    void action_btnCancelar(ActionEvent event) {
        JOptionPane.showConfirmDialog(null, "Você realmente cancelar?");
        
        if (JOptionPane.YES_OPTION == 1) {
            Stage stage = (Stage) btnCancelar.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
        }

    }

    @FXML
    void initialize() {
        assert txtLogin != null : "fx:id=\"txtLogin\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert txtSenha != null : "fx:id=\"txtSenha\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert MainPane != null : "fx:id=\"MainPane\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert paneLogin != null : "fx:id=\"paneLogin\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert cbTipo != null : "fx:id=\"cbTipo\" was not injected: check your FXML file 'Cadastro.fxml'.";
        assert cbFuncao != null : "fx:id=\"cbFuncao\" was not injected: check your FXML file 'Cadastro.fxml'.";

        paneLogin.setVisible(false);
    }
}
