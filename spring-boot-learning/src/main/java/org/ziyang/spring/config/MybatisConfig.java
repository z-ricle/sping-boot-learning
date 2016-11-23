package org.ziyang.spring.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.h2.Driver;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.ConnectionProperties;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseConfigurer;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement
public class MybatisConfig {
    
    public DataSource getH2DataSouce(){
    	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    	EmbeddedDatabase db = builder
    			.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
    			.setName("blog")
    			.setDataSourceFactory(new DataSourceFactory(){
    				private final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
					@Override
					public ConnectionProperties getConnectionProperties() {
						// TODO Auto-generated method stub
						return new ConnectionProperties() {

							@Override
							public void setDriverClass(Class<? extends java.sql.Driver> driverClass) {
								dataSource.setDriverClass(Driver.class);
							}

							@Override
							public void setUrl(String url) {
								dataSource.setUrl("jdbc:h2:~/blog;MODE=MySQL");
							}

							@Override
							public void setUsername(String username) {
								dataSource.setUsername("zy");
							}

							@Override
							public void setPassword(String password) {
								dataSource.setPassword("ziyang");
							}
							
						};
					}

					@Override
					public DataSource getDataSource() {
						return dataSource;
					}
    				
    			})
    			.build();
    	 return db;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(getH2DataSouce());
        //bean.setTypeAliasesPackage("tk.mybatis.springboot.model");

        //ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
	@Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

	@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("org.ziyang.dal.mapper");
        return mapperScannerConfigurer;
    }
	
	@Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");//RowBounds参数offset作为PageNum使用 - 默认不使用
        p.setProperty("rowBoundsWithCount", "true");//RowBounds是否进行count查询 - 默认不查询
        //p.setProperty("pageSizeZero", "true");//当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
        p.setProperty("reasonable", "true");//分页合理化
        p.setProperty("supportMethodsArguments", "false");////是否支持接口参数来传递分页参数，默认false
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
