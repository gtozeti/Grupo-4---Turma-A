/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.database.teste002.model.dao;

import com.bancodados.connection.ConnectionFactory;
import com.teste.database.teste002.model.bean.TesteTabelaBean;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class TesteTabelaDAO {

    public void create(TesteTabelaBean t) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tabelaTeste (nome, idade, sexo, cidade) VALUES (?, ?, ?, ?)");
            
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getIdade());
            stmt.setString(3, t.getSexo());
            stmt.setString(4, t.getCidade());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "INFO adicionada com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar adicionar");
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
    }
}
