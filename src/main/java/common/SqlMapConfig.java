package common;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapConfig {
	

	private static final SqlMapClient sqlMap; //sqlMap�� xml���� �о�� ��ü�� ���� ���̴�.
	
	
	//static�̹Ƿ� �̹� �޸𸮻� �ö� �ִ�.
	static {
		
		try {
			
			String resource = "sqlMapConfig.xml";
			
			Reader reader = Resources.getResourceAsReader(resource);
			
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
		} catch (Exception e) {
			e.printStackTrace();//���°�� �������� ���
			throw new RuntimeException("sqlMap Error : " + e);
		}
	}
	
	public static SqlMapClient getSqlMapInstance() {
		
		//�� �޼��带 ȣ���ϸ� �޸𸮻� �ö� �ִ� sqlMap�� ��ȯ�ȴ�.
		return sqlMap;
	}
	

}