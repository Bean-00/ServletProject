package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import db.OracleConnectionPool;
import user.vo.UserVO;

public class UserDAO {

	public UserDAO() {
	}
	
	public UserVO setUser(ResultSet rs) throws SQLException {
		
		if (!rs.next())
			return null;
		
		UserVO userVO = new UserVO();

		userVO.setName(rs.getString("name"));
		userVO.setGender(rs.getString("gender"));
		userVO.setBirthDate(new java.util.Date(rs.getDate("birth").getTime()));
		userVO.setJob(rs.getString("job"));
		userVO.setMobile(rs.getString("mobile"));
		userVO.setAddress(rs.getString("address"));
		userVO.setId(rs.getString("id"));

		return userVO;
		
	}

	public void adduser(UserVO userVO) {

		ResultSet rs = null;

		try (Connection con = OracleConnectionPool.getInstance().getConnection();
				PreparedStatement pStmt = con
						.prepareStatement("INSERT INTO users_info\r\n" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");) {

			pStmt.setString(1, userVO.getName());
			pStmt.setString(2, userVO.getGender());
			pStmt.setDate(3, new java.sql.Date(userVO.getBirthDate().getTime()));
			pStmt.setString(4, userVO.getJob());
			pStmt.setString(5, userVO.getMobile());
			pStmt.setString(6, userVO.getAddress());
			pStmt.setString(7, userVO.getId());
			pStmt.setString(8, userVO.getPw());

			rs = pStmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (Objects.nonNull(rs)) {
				try {
					rs.close();
				} catch (Exception e1) {
					throw new RuntimeException(e1);
				}
			}

		}
	}

	public UserVO getLoginUser(String id, String pw) {
		ResultSet rs = null;

		try (Connection con = OracleConnectionPool.getInstance().getConnection();
				PreparedStatement pStmt = con.prepareStatement(
						"select name, gender, birth, job, mobile, address, id from users_info where id = ? and pw = ?")) {
			pStmt.setString(1, id);
			pStmt.setString(2, pw);

			rs = pStmt.executeQuery();
			
			return this.setUser(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (Objects.nonNull(rs)) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}

	}
	
	public UserVO getUserInfo (String name) {
		ResultSet rs = null;

		try (Connection con = OracleConnectionPool.getInstance().getConnection();
				PreparedStatement pStmt = con.prepareStatement(
						"select name, gender, birth, job, mobile, address, id from users_info where name = ?")) {
			pStmt.setString(1, name);

			rs = pStmt.executeQuery();

			return this.setUser(rs);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (Objects.nonNull(rs)) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}

}
