package com.arthur.web.core.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MyDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mySqlSessionFactory")
public class MyDataSourceConfig {

	/**
	 * @Author liuhan
	 * @Description 精确到 mydata 目录，以便跟其他数据源隔离
	 * @Date 2019/8/13 10:48
	 * @Param
	 * @Return
	 */
	static final String PACKAGE = "com.arthur.web.dao.mapper";
	static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

	@Bean(name = "myDataSource",initMethod="init")
	@ConfigurationProperties(prefix = "my.datasource")
	public DataSource myDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		// configuration
		dataSource.setInitialSize(this.initialSize);
		dataSource.setMinIdle(this.minIdle);
		dataSource.setMaxActive(this.maxActive);
		dataSource.setMaxWait(this.maxWait);
		dataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(this.validationQuery);
		dataSource.setTestWhileIdle(this.testWhileIdle);
		dataSource.setTestOnBorrow(this.testOnBorrow);
		dataSource.setTestOnReturn(this.testOnReturn);
		dataSource.setPoolPreparedStatements(this.poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
		dataSource.setRemoveAbandoned(this.removeAbandoned);
		dataSource.setRemoveAbandonedTimeout(this.removeAbandonedTimeout);
		dataSource.setLogAbandoned(this.logAbandoned);
		return dataSource;
	}

	@Bean(name = "myTransactionManager")
	public DataSourceTransactionManager myTransactionManager() {
		return new DataSourceTransactionManager(myDataSource());
	}

	@Bean(name = "mySqlSessionFactory")
	public SqlSessionFactory mySqlSessionFactory(@Qualifier("myDataSource") DataSource myDataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MyDataSourceConfig.MAPPER_LOCATION));
		sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config-mydata.xml"));
		return sessionFactory.getObject();
	}

	/**
	 * @Author liuhan
	 * @Description 相关参数
	 * @Date 2019/8/13 10:48
	 * @Param
	 * @Return
	 */
	@Value("${my.datasource.url}")
	private String url;

	@Value("${my.datasource.username}")
	private String user;

	@Value("${my.datasource.password}")
	private String password;

	@Value("${my.datasource.driverClassName}")
	private String driverClass;

	@Value("${my.datasource.initialSize}")
	private int initialSize;

	@Value("${my.datasource.minIdle}")
	private int minIdle;

	@Value("${my.datasource.maxActive}")
	private int maxActive;

	@Value("${my.datasource.maxWait}")
	private int maxWait;

	@Value("${my.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${my.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${my.datasource.validationQuery}")
	private String validationQuery;

	@Value("${my.datasource.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${my.datasource.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${my.datasource.testOnReturn}")
	private boolean testOnReturn;

	@Value("${my.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Value("${my.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Value("${my.datasource.filters}")
	private String filters;

	@Value("${my.datasource.connectionProperties}")
	private String connectionProperties;

	@Value("${my.datasource.removeAbandoned}")
	private boolean removeAbandoned;

	@Value("${my.datasource.removeAbandonedTimeout}")
	private int removeAbandonedTimeout;

	@Value("${my.datasource.logAbandoned}")
	private boolean logAbandoned;
}