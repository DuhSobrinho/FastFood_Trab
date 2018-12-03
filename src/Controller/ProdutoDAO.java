package Controller;

import Infra.ConnectionFactory;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class ProdutoDAO {
   
    public  ProdutoDAO(){
    }
    
    public static void Add(Produto produto) throws Exception {
        try {
            String sql = "INSERT INTO Produto (cod_Item_Estoque, nome, funcao) "
                                    + "VALUES (?,?,?)" ;

            Connection con = ConnectionFactory.conectaBanco();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, produto.getCod_Item_Estoque());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getQuantidade());
            ps.setString(4, produto.getNome());
            
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }
    };
    
    public static List<Produto> listaEstoque() throws Exception {

        String sql = "SELECT *" +
                       "FROM Produto";

        Connection con = ConnectionFactory.conectaBanco();

        PreparedStatement stmt = con.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        List<Produto> listaEstoque = new ArrayList<>();

        while (rs.next()) {

            Produto estoque = new Produto();

            estoque.setCod_Item_Estoque(rs.getInt("Cod_Item_Estoque"));
            estoque.setDescricao(rs.getString("Descricao"));
            estoque.setQuantidade(rs.getInt("Quantidade"));
            estoque.setNome(rs.getString("Nome"));

            listaEstoque.add(estoque);
        }

        return listaEstoque;
    };
    
    public static void Delete(int cod_Produto) throws Exception {
        try {
            String sql = "DELETE Produto WHERE cod_Produto = ?)";

            Connection con = ConnectionFactory.conectaBanco();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, cod_Produto);
            
            ps.execute();
            
        } catch (Exception e) {
            throw e;
        }
    };
}
