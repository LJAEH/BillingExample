package common;

import java.io.IOException;
import java.io.Reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DBServices {
	
	private static SqlMapClient ibatisClient;
	
	private static Logger logger = LogManager.getLogger(DBServices.class);
	
	static {
		try {
			String path ="sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(path);
			ibatisClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			
			logger.info("sql클라이언트 생성");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("sqlMap Error : " + e);

		}
		
	}

	public static SqlMapClient getSqlMapClient() {
		return ibatisClient;
	}

}
