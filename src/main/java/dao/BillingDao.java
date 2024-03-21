package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;

import common.DBServices;
import service.BillingService;
import vo.MemberVo;

public class BillingDao extends ClientDao{
	
	private Logger log = LogManager.getLogger(BillingDao.class);
	
	private SqlMapClient sqlMap = DBServices.getSqlMapClient();
	
	public void insert1(HashMap<String,Object> paramMap) throws SQLException {
		sqlMapper.insert("insertBilling",paramMap);
	}

	public int insertTest(HashMap<String, Object> paramMap) throws SQLException{
		int result = (int) sqlMap.insert("insertBillingTest",paramMap);
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<MemberVo> memberList() throws Exception{
		// TODO Auto-generated method stub
		
		String className = Thread.currentThread().getStackTrace()[1].getClassName();
		String methodName = Thread.currentThread().getStackTrace()[1].getClassName();
		
		log.info("현재 단계 : " + className + "." + methodName);
		return (List<MemberVo>) sqlMap.queryForList("test.memberCall");
	}

}
