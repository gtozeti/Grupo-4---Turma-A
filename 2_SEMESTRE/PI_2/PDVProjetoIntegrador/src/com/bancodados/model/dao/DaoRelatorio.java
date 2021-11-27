package com.bancodados.model.dao;

import com.bancodados.connection.ConnectionFactory;
import com.my.utils.DateUtils;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DaoRelatorio {

    public ArrayList<String[]> read() {

        Connection con = ConnectionFactory.getConnection(); // Iniciando a conexão com o Banco de Dados
        PreparedStatement stmt = null; // Variável para executar comando MySQL
        ResultSet rs = null;
        
        DecimalFormat format = new DecimalFormat("0000");
        
        ArrayList<String[]> relatorio = new ArrayList(); // Lista do tipo objeto para alocar os valores da tabelaTeste

        try {
            stmt = con.prepareStatement("SELECT v.cod_vend, v.dia, c.nome AS nome_cliente, f.nome AS nome_funcionario, v.metodo_pagamento, v.valor_total FROM venda as v INNER JOIN cliente AS c ON v.fk_cliente_cod_cs = c.cod_cs INNER JOIN funcionario AS f ON v.fk_funcionario_cod_fun = f.cod_fun;"); // Comando MySQL
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel

            while (rs.next()) {
                String resultado = "";
                String a = rs.getString("dia");
                
                
                resultado = "Venda,,";
                resultado += format.format(rs.getInt("cod_vend")) + ",,";
                resultado += a.substring(8) + "-" + a.substring(5, 7) + "-" + a.substring(0, 4) + ",,";
                resultado += rs.getString("nome_funcionario") + ",,";
                resultado += rs.getString("nome_cliente") + ",,";
                resultado += rs.getString("metodo_pagamento") + ",,";
                resultado += NumberFormat.getCurrencyInstance().format(rs.getDouble("valor_total"));

                relatorio.add(resultado.split(",,"));
            }
            
            stmt = con.prepareStatement("SELECT o.cod_os, o.dia, f.nome AS nome_funcionario, c.nome AS nome_cliente, o.metodo_pagamento, o.valor_total FROM ordem_servico AS o INNER JOIN cliente AS c ON o.fk_cliente_cod_cs = c.cod_cs INNER JOIN funcionario AS f ON o.fk_funcionario_cod_fun = f.cod_fun;"); // Comando MySQL
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel
            
            while (rs.next()) {
                String resultado = "";
                String a = rs.getString("dia");
                
                resultado = "OS,,";
                resultado += format.format(rs.getInt("cod_os")) + ",,";
                resultado += a.substring(8) + "-" + a.substring(5, 7) + "-" + a.substring(0, 4) + ",,";
                resultado += rs.getString("nome_funcionario") + ",,";
                resultado += rs.getString("nome_cliente") + ",,";
                resultado += rs.getString("metodo_pagamento") + ",,";
                resultado += NumberFormat.getCurrencyInstance().format(rs.getDouble("valor_total"));

                relatorio.add(resultado.split(",,"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha em buscar dados\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); // fechando conexão com o banco de dados inependente do que acontecer
        }
        
        return relatorio; // retorna valor da lista.
    }
    
    public ArrayList<String[]> search(LocalDate inicio, LocalDate fim) {

        Connection con = ConnectionFactory.getConnection(); // Iniciando a conexão com o Banco de Dados
        PreparedStatement stmt = null; // Variável para executar comando MySQL
        ResultSet rs = null;
        
        DecimalFormat format = new DecimalFormat("0000");
        
        ArrayList<String[]> relatorio = new ArrayList(); // Lista do tipo objeto para alocar os valores da tabelaTeste

        try {
            stmt = con.prepareStatement("SELECT v.cod_vend, v.dia, c.nome AS nome_cliente, f.nome AS nome_funcionario, v.metodo_pagamento, v.valor_total FROM venda as v INNER JOIN cliente AS c ON v.fk_cliente_cod_cs = c.cod_cs INNER JOIN funcionario AS f ON v.fk_funcionario_cod_fun = f.cod_fun where v.dia BETWEEN CAST(? AS DATE) AND CAST(? AS DATE);"); // Comando MySQL
            stmt.setString(1, inicio.toString());
            stmt.setString(2, fim.toString());
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel

            while (rs.next()) {
                String resultado = "";
                String a = rs.getString("dia");
                
                resultado = "Venda,,";
                resultado += format.format(rs.getInt("cod_vend")) + ",,";
                resultado += a.substring(8) + "/" + a.substring(5, 7) + "/" + a.substring(0, 4) + ",,";
                resultado += rs.getString("nome_funcionario") + ",,";
                resultado += rs.getString("nome_cliente") + ",,";
                resultado += rs.getString("metodo_pagamento") + ",,";
                resultado += NumberFormat.getCurrencyInstance().format(rs.getDouble("valor_total"));

                relatorio.add(resultado.split(",,"));
            }
            
            stmt = con.prepareStatement("SELECT o.cod_os, o.dia, f.nome as nome_funcionario, c.nome as nome_cliente, o.metodo_pagamento, o.valor_total from ordem_servico as o inner join cliente as c on o.fk_cliente_cod_cs = c.cod_cs inner join funcionario as f on o.fk_funcionario_cod_fun = f.cod_fun where o.dia BETWEEN CAST(? AS DATE) AND CAST(? AS DATE);"); // Comando MySQL
            stmt.setString(1, inicio.toString());
            stmt.setString(2, fim.toString());
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel
            
            while (rs.next()) {
                String resultado = "";
                String a = rs.getString("dia");
                
                resultado = "OS,,";
                resultado += format.format(rs.getInt("cod_os")) + ",,";
                resultado += a.substring(8) + "/" + a.substring(5, 7) + "/" + a.substring(0, 4) + ",,";
                resultado += rs.getString("nome_funcionario") + ",,";
                resultado += rs.getString("nome_cliente") + ",,";
                resultado += rs.getString("metodo_pagamento") + ",,";
                resultado += NumberFormat.getCurrencyInstance().format(rs.getDouble("valor_total"));

                relatorio.add(resultado.split(",,"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha em buscar dados\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); // fechando conexão com o banco de dados inependente do que acontecer
        }
        
        return relatorio; // retorna valor da lista.
    }
}