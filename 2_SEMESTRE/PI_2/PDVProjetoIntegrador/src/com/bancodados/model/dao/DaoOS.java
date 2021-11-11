/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodados.model.dao;

import com.bancodados.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DaoOS {
   
  public ArrayList<String[]> search(String input) {

        Connection con = ConnectionFactory.getConnection(); // Iniciando a conexão com o Banco de Dados
        PreparedStatement stmt = null; // Variável para executar comando MySQL
        ResultSet rs = null;

        ArrayList<String[]> listaProduto = new ArrayList(); // Lista do tipo objeto para alocar os valores da tabelaTeste

        try {
            //Utilizando um JOIN para unir as tabelas cliente e ordem_servico para poder mostrar na tela as informações
            stmt = con.prepareStatement("SELECT os.cod_os, cl.nome, cl.email, os.dia FROM ordem_servico AS os JOIN cliente AS cl on cl.cod_cs = fk_cliente_cod_cs where cod_os = ? OR nome LIKE ? OR email LIKE ? ORDER BY nome");
            
            try {
                stmt.setInt(1, Integer.parseInt(input));
            } catch (Exception e) {
                stmt.setInt(1, -1);
            }
            stmt.setString(2, "%" + input + "%" );
            stmt.setString(3, input + "%");
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel

            while (rs.next()) {
                String resultado = "";

                resultado += Integer.toString(rs.getInt("cod_os")) + ",";
                resultado += rs.getString("nome") + ",";
                resultado += rs.getString("email") + ",";
                resultado += rs.getString("dia");

                listaProduto.add(resultado.split(","));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha em buscar OS\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); // fechando conexão com o banco de dados inependente do que acontecer
        }

        return listaProduto; // retorna valor da lista.
    }

   public ArrayList<String[]> read() {

        Connection con = ConnectionFactory.getConnection(); // Iniciando a conexão com o Banco de Dados
        PreparedStatement stmt = null; // Variável para executar comando MySQL
        ResultSet rs = null;

        ArrayList<String[]> produto = new ArrayList(); // Lista do tipo objeto para alocar os valores da tabelaTeste

        try {
            stmt = con.prepareStatement("SELECT os.cod_os, cl.nome, cl.email, os.dia FROM ordem_servico AS os JOIN cliente AS cl on cl.cod_cs = fk_cliente_cod_cs "); // Comando MySQL
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel


            while (rs.next()) {
                String resultado = "";

                 resultado += Integer.toString(rs.getInt("cod_os")) + ",";
                resultado += rs.getString("nome") + ",";
                resultado += rs.getString("email") + ",";
                resultado += rs.getString("dia");

                
                produto.add(resultado.split(","));
            }
            
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha em buscar OS\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); // fechando conexão com o banco de dados inependente do que acontecer
        }

        return produto; // retorna valor da lista.
    }
  
   public static String totalOS() {

        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL
        int total = 0;

        try {
            stmt = con.prepareStatement("SELECT MAX(cod_os) FROM ordem_servico"); // Executa a busca do código da última OS cadastrada
            ResultSet resultado = stmt.executeQuery(); // Executando atualização do comando

            if (resultado.next()) {

                total = Integer.valueOf(resultado.getString("max(cod_os)")) + 1; // Retorno do código da última OS cadastrada + 1
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar buscar as OS cadastradas\n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
            return String.valueOf(total);
        }
    }
}
