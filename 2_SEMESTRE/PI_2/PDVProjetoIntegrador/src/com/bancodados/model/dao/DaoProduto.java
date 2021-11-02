/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bancodados.model.dao;

import com.bancodados.connection.ConnectionFactory;
import com.bancodados.model.bean.ModelProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DaoProduto {
    
    public void create(ModelProduto cs) {
        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL

        try {
            stmt = con.prepareStatement("INSERT INTO produto (nome, categoria, valor_unit, quantidade) VALUES (?, ?, ?, ?);");

            stmt.setString(1, cs.getNome());
            stmt.setString(2, cs.getCategoria());
            stmt.setString(3, Double.toString(cs.getValor_unit()));
            stmt.setString(4, Integer.toString(cs.getQuantidade()));
            
            
            stmt.executeUpdate(); // Executando atualização do comando

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!"); // Mensagem para caso o comando dê certo

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar adicionar o produto\n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
        }
    }
    
    //Função para buscar os valores disponíveis das categorias
    public static ArrayList categoria() {
        Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
        PreparedStatement stmt = null; // Variável utilizada para comando MySQL

        ArrayList vetor = new ArrayList(); // Variável para criação do vetor dos valores disponíveis das categorias

        try {
            stmt = con.prepareStatement("SELECT DISTINCT categoria FROM produto ORDER BY categoria"); // Executa a busca na tabela produto
            ResultSet resultado = stmt.executeQuery(); // Executando atualização do comando

            while (resultado.next()) {
                vetor.add(resultado.getString("categoria")); // Adição dos elementos no vetor
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao tentar buscar as categorias cadastradas\n" + ex); // Mensagem para cada o comando não dê certo
        } finally {
            ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
            return vetor;
        }
        
    }
    
    //Função para buscar o valor da última OS cadastrada
     public static String totalOS(){
         
         Connection con = ConnectionFactory.getConnection(); // Inicia conexão com o banco de dados
         PreparedStatement stmt = null; // Variável utilizada para comando MySQL
         int total = 0;
         
         try {
             stmt = con.prepareStatement("SELECT MAX(cod_prod) FROM produto"); // Executa a busca do código da última OS cadastrada
             ResultSet resultado = stmt.executeQuery(); // Executando atualização do comando

             if (resultado.next()) {
                 
                 total = Integer.valueOf(resultado.getString("max(cod_prod)")) + 1; // Retorno do código da última OS cadastrada + 1
             }
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Falha ao tentar buscar as OS cadastradas\n" + ex); // Mensagem para cada o comando não dê certo
         } finally {
             ConnectionFactory.closeConnection(con, stmt); // Fechando a conexão com o banco independendo do que aconteça
             return String.valueOf(total);
         }
    }
     
     //Função para validar as informações dos campos
     public static boolean campo(String frase){
         
         String palavra = frase.strip();
         
        return (palavra.isBlank() || palavra.isEmpty());
             
     }
}
