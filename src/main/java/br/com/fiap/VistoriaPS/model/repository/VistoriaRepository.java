package br.com.fiap.VistoriaPS.model.repository;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.VistoriaPS.model.entity.Vistoria;





public class VistoriaRepository extends Repository{
	
	public static ArrayList<Vistoria> findAll() {
		ArrayList<Vistoria> vistorias = new ArrayList<Vistoria>();
		String sql = "select * from tb_vistoria";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Vistoria vistoria = new Vistoria();
					vistoria.setId(rs.getLong("id"));
					vistoria.setMarca(rs.getString("marca"));
					vistoria.setModelo(rs.getString("modelo"));
					vistoria.setNumSerie(rs.getLong("num_serie"));
					vistoria.setDataCompra(rs.getDate("data_compra").toLocalDate());
					vistorias.add(vistoria);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return vistorias;
	}
	
	public static Vistoria save(Vistoria vistoria) {
		String sql = "insert into tb_vistoria" + "(id, marca, modelo, num_serie, data_compra)"
				+ " values(null, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vistoria.getMarca());
			ps.setString(2, vistoria.getModelo());
			ps.setLong(3, vistoria.getNumSerie());
			ps.setDate(4, Date.valueOf (vistoria.getDataCompra()));
			if (ps.executeUpdate() > 0) {
				return vistoria;
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
		String sql = "delete from tb_vistoria where id=?";
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
	
	public static Vistoria update(Vistoria vistoria) {
		String sql = "UPDATE tb_vistoria " + "SET marca=?, modelo=?, num_serie=?, data_compra=?"
				+ "WHERE id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, vistoria.getMarca());
			ps.setString(2, vistoria.getModelo());
			ps.setLong(3, vistoria.getNumSerie());
			ps.setDate(4, Date.valueOf(vistoria.getDataCompra()));
			ps.setLong(5, vistoria.getId());
			if (ps.executeUpdate() > 0) {
				return vistoria;
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
	
	public static Vistoria findById(Long id) {
		String sql = "select * from tb_cadastro where id=?";
		Vistoria vistoria = new Vistoria();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {				
				vistoria.setId(rs.getLong("id"));
				vistoria.setMarca(rs.getString("marca"));
				vistoria.setModelo(rs.getString("modelo"));
				vistoria.setNumSerie(rs.getLong("num_serie"));
				vistoria.setDataCompra(rs.getDate("data_compra").toLocalDate());
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return vistoria;
	}

}