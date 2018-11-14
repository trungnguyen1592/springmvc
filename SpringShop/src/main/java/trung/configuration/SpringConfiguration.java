package trung.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "trung")
@PropertySource(value={"classpath:db.properties"})
@EnableTransactionManagement
public class SpringConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	Environment environment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("classpath:tiles.xml");
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/views/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/resouces/");
		registry.addResourceHandler("/files/**").addResourceLocations("/resouces/image/");
		registry.addResourceHandler("/*.jsp").addResourceLocations("/WEB-INF/views/");
		//registry.addResourceHandler("/files/**").addResourceLocations("file:F:\\");
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("forward:/home.html");
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}
	
//	@Bean
//	public UserValidator userValidator() {
//		return new UserValidator();
//	}
	
	@Bean(name="multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(-1);
		return commonsMultipartResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("driver"));
		dataSource.setUrl(environment.getProperty("url"));
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan("trung.entity");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		hibernateProperties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		
		bean.setHibernateProperties(hibernateProperties);
		
		return bean;
	}
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
//	@Bean
//	public JdbcTemplate jdbcTemplate() {
//		return new JdbcTemplate(dataSource());
//	}
//	
//	@Bean(name="transactionManager")
//	public DataSourceTransactionManager dataSourceTransactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}
	
	
	
}