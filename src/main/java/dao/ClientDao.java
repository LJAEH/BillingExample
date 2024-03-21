package dao;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class ClientDao {
	
	protected static SqlMapClient sqlMapper;
	
	static {
		try {
			
			Reader reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			
			reader.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
