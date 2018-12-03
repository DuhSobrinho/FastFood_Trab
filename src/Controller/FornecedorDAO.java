/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Infra.ConnectionFactory;
import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class FornecedorDAO {

    private FornecedorDAO() {
    }

    public static void Add(Fornecedor fornecedor) throws Exception {
        try {
            try (Connection con = ConnectionFactory.conectaBanco()) {

                String sql = "INSERT INTO Colaboradores (nome, tipo_Grupo) "
                           + "VALUES (?, ?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, fornecedor.getNome());
                ps.setString(2, fornecedor.getTipo_Grupo());

                ps.execute();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public static List<Fornecedor> findAll() throws Exception {

        String sql = "SELECT *"
                     + "FROM Fornecedor";

        List<Fornecedor> fornecedores;

        try (Connection con = ConnectionFactory.conectaBanco()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            fornecedores = new ArrayList<>();
            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTipo_Grupo(rs.getString("tipo_Grupo"));

                fornecedores.add(fornecedor);
            }
        }
        return fornecedores;
    }
    
    public static void Delete(int cod_Fornecedor) throws Exception {
        try {
            String sql = "DELETE Fornecedor WHERE cod_Fornecedor = ?)";

            try (Connection con = ConnectionFactory.conectaBanco()) {
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, cod_Fornecedor);

                ps.execute();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
