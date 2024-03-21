package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.BillingDao;
import dao.TestDao;
import vo.MemberVo;

public class BillingService {
	
	private BillingDao dao;
	
	private Logger log = LogManager.getLogger(BillingService.class);
	
	public BillingService() {
		this.dao = new BillingDao();
	}
	

	public void insert1(HashMap<String,Object> paramMap) throws Exception {
		
		dao.insert1(paramMap);
	}


	public void insert2(HashMap<String, Object> paramMap) throws SQLException {
		dao.insert1(paramMap);
		
	}
	
	public int insertTest(HashMap<String, Object> paramMap) throws Exception {
		int a = dao.insertTest(paramMap);
		return a;
		
	}


	public List<MemberVo> memberList() throws Exception {
		
		String className = Thread.currentThread().getStackTrace()[1].getClassName();
		String methodName = Thread.currentThread().getStackTrace()[1].getClassName();
		
		log.info("현재 단계 : " + className + "." + methodName);
		return dao.memberList();
	}


}
