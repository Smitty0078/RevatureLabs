package common.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static DBUtil _instance;
	private Connection conn = null;
	
	//TODO: PRE/POST note: this is a singleton!
	private DBUtil() {}
	
	public static DBUtil getInstance() throws Exception{
		if(_instance == null) {
			_instance = new DBUtil();
		}
		return _instance;
	}
	
	public Connection getConnection() throws SQLException {
		
		if(this.conn == null){
			//note the config properties file must be established in the run configurations with appropriate file path!!
			String configFilePath = System.getProperty(AppConstants.CONFIG_FILE);
			try(FileInputStream fis = new FileInputStream(configFilePath)){
				Properties props = new Properties();
				props.load(fis);
				
				this.conn = DriverManager.getConnection(props.getProperty(AppConstants.DB_URL), 
														props.getProperty(AppConstants.DB_USERNAME), 
														props.getProperty(AppConstants.DB_PASSWORD));
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return this.conn;
		
	}
	
	
	
}
