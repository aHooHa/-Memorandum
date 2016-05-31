package com.newer.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.memo.util.MemoUtil;

public class MemoDao {

	private Connection cont;
	private PreparedStatement stat;
	private ResultSet res;

	public void saveMemo(Memo m) throws SQLException {

		cont = MemoUtil.getConnection();
		String sql = "insert into MEMO(name,type,theame,context,time1)  values(?,?,?,?,?) ";
		stat = cont.prepareStatement(sql);
		stat.setString(1, m.getName());
		stat.setString(2, m.getType());
		stat.setString(3, m.getContext());
		stat.setString(4, m.getTheame());
		
		stat.setString(5, m.getTime());
		
		stat.executeUpdate();

		MemoUtil.closeAll(null, stat, cont);
	}

	public List<Memo> findAll() throws SQLException {

		List<Memo> list = new ArrayList<>();
		cont = MemoUtil.getConnection();
		String sql = "select *from MEMO";
		stat = cont.prepareStatement(sql);
		res = stat.executeQuery();
		while (res.next()) {
			Memo m = new Memo();
			m.setId(res.getInt("id"));
			m.setName(res.getString("name"));
			m.setType(res.getString("type"));
			m.setTime(res.getString("time1"));
			m.setTheame(res.getString("theame"));
			m.setContext(res.getString("context"));
			
			list.add(m);
		}
		MemoUtil.closeAll(res, stat, cont);
		return list;

	}
	public void removeMemo(Memo mo) throws SQLException{
		cont = MemoUtil.getConnection();
		String sql = "delete from MEMO  where id =?";
		stat = cont.prepareStatement(sql);
		stat.setInt(1, mo.getId());
		stat.executeUpdate();
		MemoUtil.closeAll(null, stat, cont);
	}
	public void updateMemo(Memo mo) throws SQLException{
		cont = MemoUtil.getConnection();
		String sql="update MEMO set name=?,type=?,context=?,theame=?,time1=? where id=?";
		stat = cont.prepareStatement(sql);
		stat.setString(1, mo.getName());
		stat.setString(2, mo.getType());
		stat.setString(3, mo.getContext());
		stat.setString(4, mo.getTheame());
		stat.setString(5, mo.getTime());
		stat.setInt(6, mo.getId());
		stat.executeUpdate();
		
		
		MemoUtil.closeAll(null, stat, cont);
	}

}
