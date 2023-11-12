package br.com.fiap.VistoriaPS.model.repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.VistoriaPS.model.entity.Cadastro;





public class CadastroRepository extends Repository{
	
	public static ArrayList<Cadastro> findAll() {
		ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
		String sql = "select * from tb_cadastro";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cadastro cadastro = new Cadastro();
					cadastro.setId(rs.getLong("id"));
					cadastro.setNome(rs.getString("nome"));
					cadastro.setEmail(rs.getString("email"));
					cadastro.setSenha(rs.getString("senha"));
					cadastros.add(cadastro);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return cadastros;
	}
	
	public static Cadastro save(Cadastro cadastro) {
		String sql = "insert into tb_cadastro" + "(id, nome, email, senha)"
				+ " values(null, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getEmail());
			ps.setString(3, cadastro.getSenha());
			if (ps.executeUpdate() > 0) {
				return cadastro;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static boolean delete(Long id) {
		String sql = "delete from tb_cadastro where id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return false;
	}
	
	public static Cadastro update(Cadastro cadastro) {
		String sql = "UPDATE tb_cadastro " + "SET nome=?, email=?, senha=?"
				+ "WHERE id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cadastro.getNome());
			ps.setString(2, cadastro.getEmail());
			ps.setString(3, cadastro.getSenha());
			ps.setLong(4, cadastro.getId());
			if (ps.executeUpdate() > 0) {
				return cadastro;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	public static Cadastro findById(Long id) {
		String sql = "select * from tb_cadastro where id=?";
		Cadastro cadastro = new Cadastro();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				cadastro.setId(rs.getLong("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setEmail(rs.getString("email"));
				cadastro.setSenha(rs.getString("senha"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return cadastro;
	}

}
