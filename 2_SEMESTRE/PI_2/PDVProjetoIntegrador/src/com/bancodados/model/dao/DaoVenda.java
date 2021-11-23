package com.bancodados.model.dao;

import com.bancodados.connection.ConnectionFactory;
import com.bancodados.model.bean.ModelVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DaoVenda {

    public void create(ModelVenda v) {
        
        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL

        try {
            stmt = con.prepareStatement("INSERT INTO venda (dia, valor_total, metodo_pagamento, fk_cliente_cod_cs, fk_funcionario_cod_fun) VALUES (curdate(), ?, ?, ?, ?);");
            
            stmt.setDouble(1, v.getValor_total());
            stmt.setString(2, v.getMetodo_pagamento());
            stmt.setInt(3, v.getFk_cliente_cod_cs());
            stmt.setInt(4, v.getFk_funcionario_cod_fun());
            
            stmt.executeUpdate(); // Executando atualização do comando

            JOptionPane.showMessageDialog(null, "INFO adicionada com sucesso!"); // Mensagem para caso o comando dê certo

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar adicionar/n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }
}
