/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodados.model.dao;

import com.bancodados.connection.ConnectionFactory;
import com.bancodados.model.bean.ModelCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DaoCliente {

    public void create(ModelCliente cs) {
        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, email, telefone, logradouro, complemento, bairro, logradouro_num, cidade, estado, cep, documento)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            
            stmt.setString(1, cs.getNome());
            stmt.setString(2, cs.getEmail());
            stmt.setString(3, cs.getTelefone());
            stmt.setString(4, cs.getLogradouro());
            stmt.setString(5, cs.getComplemento());
            stmt.setString(6, cs.getBairro());
            stmt.setString(7, cs.getLogradouro_num());
            stmt.setString(8, cs.getCidade());
            stmt.setString(9, cs.getEstado());
            stmt.setString(10, cs.getCep());
            stmt.setString(11, Integer.toString(cs.getDocumento()));

            stmt.executeUpdate(); // Executando atualização do comando

            JOptionPane.showMessageDialog(null, "INFO adicionada com sucesso!"); // Mensagem para caso o comando dê certo

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar adicionar/n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }
}
