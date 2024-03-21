package main;

import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;

import service.BillingService;
import service.FileService;
import vo.MemberVo;

public class BillingMain {
	
	static String billingFileName;
	
	
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger(BillingMain.class);
		
        logger.debug("main runnnnnnnn");
        

        
		BillingService service = new BillingService();
		
		try {
		
		billingFileName = "newBillingFile";
		
		
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		
		List<MemberVo> memberList = service.memberList();
		
		FileService fservice = new FileService();
		
		fservice.makeFile(memberList);
		//fservice.sftpsend();

		logger.debug("endddddddddddd");
		
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
		
	}

}
