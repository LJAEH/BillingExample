package main;

import java.sql.SQLException;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;

import service.BillingService;

public class TestMain {
	
	private static SqlMapClient sqlMapClient;
	
	public static void main(String[] args) {
		
	
		BillingService service = new BillingService();
		
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		
		try {
			sqlMapClient.startTransaction(); // 트랜잭션 시작
			
			service.insert1(paramMap);
			
			service.insert2(paramMap);
			
			sqlMapClient.commitTransaction(); // 트랜잭션 성공 시 커밋
		} catch (Exception e) {
		    e.printStackTrace();
		    try {
				sqlMapClient.endTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // 예외 발생 시 롤백
	    }
		

	}
	
		

}
