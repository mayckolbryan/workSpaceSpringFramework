/**
 * 
 */
package com.mitocode;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author BRYAN
 *
 */
//@PropertySources para la administracion de varios recursos
//@PropertySource para indicar el recurso en especifico
//@EnableTransactionManagement habilita las Transacciones
@Configuration
@ComponentScan
@PropertySources({@PropertySource("classpath:properties/ds_config.properties")})
@EnableTransactionManagement
public class AppConfig {
	
	//Environment se utiliza de la mano con el @PropertySource para la lectura de aarchivos properties
	@Autowired
	private Environment env;
	
	@Bean(name="dataSource")
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));
		return dataSource;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}
