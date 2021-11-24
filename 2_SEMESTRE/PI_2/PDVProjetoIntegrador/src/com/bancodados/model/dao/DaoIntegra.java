package com.bancodados.model.dao;

import com.bancodados.connection.ConnectionFactory;
import com.bancodados.model.bean.ModelIntegra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoIntegra {
    
      public void create(ModelIntegra cs) {
        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL

        try {
            stmt = con.prepareStatement("INSERT INTO integra (quantidade_serv, fk_servico_cod_serv, fk_ordem_servico_cod_os) VALUES (?, ?, ?);");

            stmt.setString(1, Integer.toString(cs.getQuantidade_serv()));
            stmt.setString(2, Integer.toString(cs.getFk_servico_cod_serv()));
            stmt.setString(3, Integer.toString(cs.getFk_ordem_servico_cod_os()));

            stmt.executeUpdate(); // Executando atualização do comando

            //JOptionPane.showMessageDialog(null, "Serviço adicionado com sucesso!"); // Mensagem para caso o comando dê certo

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao relacionar os serviços com a OS\n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }
      
      public void delete(int id) {

        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL

        try {
            stmt = con.prepareStatement("DELETE FROM integra WHERE fk_ordem_servico_cod_os = ?"); // Comando MySQL para deletar valores na tabela "tabelaTeste"

            stmt.setString(1, String.valueOf(id)); // Pegando o valor de ID do objeto TesteTabelaBean e adicionando no "?"

            stmt.executeUpdate(); // Executando atualização do comando

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar atualizar as informações de INTEGRA\n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }
    
}
