package dao;

import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import vo.MemberVo;

public class TestDao {
	
	private SqlMapClient sqlMap;

	@SuppressWarnings("unchecked")
	public List<MemberVo> testDao() throws Exception {
		return (List<MemberVo>) sqlMap.queryForList("test.member");
	}

	public List<MemberVo> insert1(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
