package br.com.lifebf.dao;


import br.com.lifebf.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDao {

    public void createCliente(Cliente cliente) {

        String SQL = "INSERT INTO cliente (nome,email,cpf,senha,plano_saude,cep,rua,numero,bairro,cidade,estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lifebf?user=root&password=root");

            System.out.println("Success in database connection");

            PreparedStatement preparedStatement = conn.prepareStatement(SQL);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEmail());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getSenha());
            preparedStatement.setString(5, cliente.getPlanoSaude());
            preparedStatement.setString(6, cliente.getCep());
            preparedStatement.setString(7, cliente.getRua());
            preparedStatement.setString(8, cliente.getNumero());
            preparedStatement.setString(9, cliente.getBairro());
            preparedStatement.setString(10, cliente.getCidade());
            preparedStatement.setString(11, cliente.getEstado());

            preparedStatement.execute();
            System.out.println("cadastrado com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Fecha a conexão no bloco finally para garantir que será fechada mesmo em caso de erro
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}

