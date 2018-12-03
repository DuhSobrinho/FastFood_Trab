package Controller;

import Model.Produto;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Eduardo
 */
public class Cadastro_ProdutoController implements Initializable {

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private ComboBox<?> cbMenu;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextArea txtDescricao;

    @FXML
    void btnSalvarOnAction(ActionEvent event) throws Exception {
        try {
            if (cbMenu.getValue() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um tipo!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                cbMenu.requestFocus();
                return;
            } else if (txtNome.getText() == null) {
                JOptionPane.showMessageDialog(null, "Nome vazio, verifique!!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtNome.requestFocus();
                return;
            } else if (Integer.parseInt(txtQuantidade.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "De uma quantidade de itens!", "Atenção!", JOptionPane.WARNING_MESSAGE);
                txtQuantidade.requestFocus();
                return;
            }

            Produto produto = new Produto();

            produto.setNome(txtNome.getText());
            produto.setDescricao(txtDescricao.getText());
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

            ProdutoDAO.Add(produto);

        } catch (Exception e) {
            throw e;
        }

    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
        JOptionPane.showConfirmDialog(null, "Você realmente cancelar?");

        if (JOptionPane.YES_OPTION == 1) {
            Stage stage = (Stage) btnCancelar.getScene().getWindow(); //Obtendo a janela atual
            stage.close();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert btnSalvar != null : "fx:id=\"btnSalvar\" was not injected: check your FXML file 'Cadastro_Produto.fxml'.";
        assert txtQuantidade != null : "fx:id=\"txtQuantidade\" was not injected: check your FXML file 'Cadastro_Produto.fxml'.";
        assert cbMenu != null : "fx:id=\"cbMenu\" was not injected: check your FXML file 'Cadastro_Produto.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Cadastro_Produto.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'Cadastro_Produto.fxml'.";
        assert txtDescricao != null : "fx:id=\"txtDescricao\" was not injected: check your FXML file 'Cadastro_Produto.fxml'.";

    }
}
