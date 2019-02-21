package com.mysping.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {
	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
//	@Test
//	public void testConnection() {
//		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//				"spring","spring")){
//			log.info(con);
//		} catch (Exception e) {
//			// TODO: handle exception
//			fail(e.getMessage());
//		}
//	}
	@Test
	public void testMyBatis() {
		try (SqlSession sesstion = sqlSessionFactory.openSession();
				Connection con = sesstion.getConnection();
				){
			log.info(sesstion);
			log.info(con);
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
}
