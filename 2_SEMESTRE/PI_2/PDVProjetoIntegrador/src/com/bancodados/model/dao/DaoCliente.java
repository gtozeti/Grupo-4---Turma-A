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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            stmt = con.prepareStatement("INSERT INTO cliente (nome, email, telefone, cep, logradouro, logradouro_num, complemento, bairro, cidade, documento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            stmt.setString(1, cs.getNome());
            stmt.setString(2, cs.getEmail());
            stmt.setString(3, cs.getTelefone());
            stmt.setString(4, cs.getCep());
            stmt.setString(5, cs.getLogradouro());
            stmt.setString(6, cs.getLogradouro_num());
            stmt.setString(7, cs.getComplemento());
            stmt.setString(8, cs.getBairro());
            stmt.setString(9, cs.getCidade());
            stmt.setString(10, cs.getDocumento());

            stmt.executeUpdate(); // Executando atualização do comando

            JOptionPane.showMessageDialog(null, "INFO adicionada com sucesso!"); // Mensagem para caso o comando dê certo

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar adicionar/n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }

    public ArrayList<ModelCliente> read() {

        Connection con = ConnectionFactory.getConnection(); // Iniciando a conexão com o Banco de Dados
        PreparedStatement stmt = null; // Variável para executar comando MySQL
        ResultSet rs = null;

        ArrayList<ModelCliente> listaCliente = new ArrayList(); // Lista do tipo objeto para alocar os valores da tabelaTeste

        try {
            stmt = con.prepareStatement("SELECT cod_cs, nome, email, telefone, documento from cliente"); // Comando MySQL
            rs = stmt.executeQuery(); // Adicionando os valores coletados no comando MySQL na varáivel

            while (rs.next()) {
                ModelCliente c = new ModelCliente(); // Objeto semente iniciado para conseguir ler os dados da variável rs

                c.setCod_cs(rs.getInt("cod_cs"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setDocumento(rs.getString("documento"));

                listaCliente.add(c); // Enviando todos os valores para a lista
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha em buscar dados\n" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs); // fechando conexão com o banco de dados inependente do que acontecer
        }

        return listaCliente; // retorna valor da lista.
    }

    public void update(ModelCliente cs) {

        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, email = ?, telefone = ?, cep = ?, logradouro = ?, logradouro_num = ?, complemento = ?, bairro = ?, cidade = ?, documento = ? WHERE id = ?"); // Comando MySQL para atualizar valores na tabela "tabelaTeste"

            stmt.setString(1, cs.getNome());
            stmt.setString(2, cs.getEmail());
            stmt.setString(3, cs.getTelefone());
            stmt.setString(4, cs.getCep());
            stmt.setString(5, cs.getLogradouro());
            stmt.setString(6, cs.getLogradouro_num());
            stmt.setString(7, cs.getComplemento());
            stmt.setString(8, cs.getBairro());
            stmt.setString(9, cs.getCidade());
            stmt.setString(10, cs.getDocumento());
            stmt.setInt(11, cs.getCod_cs());

            stmt.executeUpdate(); // Executando atualização do comando

            JOptionPane.showMessageDialog(null, "INFO atualizada com sucesso!"); // Mensagem para caso o comando dê certo

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar atualizar/n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }
    
    
}
