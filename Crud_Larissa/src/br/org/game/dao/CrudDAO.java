package br.org.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.org.game.controller.Conexao;
import br.org.game.model.Game;

public class CrudDAO {

	//CRUD- create
		public void create(Game game) {
			String sql = "INSERT INTO  jogos(nome, preco, categoria) VALUES (?, ?, ?)";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				p.setString(1, game.getNome());
				p.setFloat(2, game.getPreco());
				p.setString(3, game.getCategoria());
				p.setInt(0, game.getId());
				p.execute();
			}catch(Exception e) {
				JOptionPane.showConfirmDialog(null, "Erro ao inserir dados! \nERRO:" + e);
			}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//fim create///////////////////////////////////////////////////////////////
		//CRuD update
		
		public void update(Game game) {
			String sql = "UPDATE jogos SET nome = ?, preco= ?, categoria= ? WHERE id = ?";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				p.setString(1, game.getNome());
				p.setFloat(2, game.getPreco());
				p.setString(3, game.getCategoria());
				p.execute();
				JOptionPane.showMessageDialog(null, "dados atualizados com sucesso");
				System.out.println("dados atualizados com sucesso");
				}catch(Exception e) {
					JOptionPane.showConfirmDialog(null, "Erro ao inserir dados! \nERRO:" + e);
				}finally {
					try {
						if(p != null);
						p.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
		}///////////////////////////////////////////////////////////////////////////////////////

		//CrUD read

		public List<Game> read(){
			String sql = "SELECT * FROM jogos";
			List<Game> game = new ArrayList<Game>();
			Connection conn = null;
			PreparedStatement p = null;
			ResultSet resultado = null;
			
			try{
				conn = Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				resultado = p.executeQuery();
				
				while(resultado.next()) {
					Game ver_game = new Game();
					ver_game.setCategoria(resultado.getString("categoria"));
					ver_game.setNome(resultado.getString("nome"));
					ver_game.setPreco(resultado.getInt("preco"));
					game.add(ver_game);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
						try {
							if(p != null);
							p.close();
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
			
			return game;
					/////////////////////////////////////////////////////////////////////////////
				}//CRUd delete
		public boolean delete(int id) {
			String sql = "DELETE FROM jogos WHERE id = ?";
			Connection conn = null;
			PreparedStatement p = null;
			try {
				conn = Conexao.criandoConexao();
				p = (PreparedStatement) conn.prepareStatement(sql);
				p.setInt(0, id);
				p.execute();
				JOptionPane.showMessageDialog(null, "dados excluidos com sucesso");
				System.out.println("dados excluidos com sucesso");
			}catch(Exception e){
				JOptionPane.showConfirmDialog(null, "Erro ao excluir dados! \nERRO:" + e);
			}finally {
				try {
					if(p != null);
					p.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return false;
		}

}
