@Configuration
@EnableTransactionManagement
public class HibernateConfig {

   // 在Spring中注入hibernate
  // Compatible with Hibernate 5.2/5.3/5.4, as of Spring 5.3. This Hibernate-specific
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("com.example.model");
    sessionFactory.setHibernateProperties(hibernateProperties());
    sessionFactory.setServiceRegistryBuilder(serviceRegistryBuilder());
    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    // define your DataSource bean here
  }

  @Bean
  public Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    properties.setProperty("hibernate.show_sql", "true");
    // define other Hibernate properties here
    return properties;
  }

  @Bean
  public StandardServiceRegistryBuilder serviceRegistryBuilder() {
    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
    serviceRegistryBuilder.applySetting("hibernate.temp.use_jdbc_metadata_defaults", false);
    
	// define other service registry settings here
    serviceRegistryBuilder.addInitiator(new MyCustomServiceInitiator());
    return serviceRegistryBuilder;
  }

  private static class MyCustomServiceInitiator implements ServiceInitiator<MyCustomService> {
    @Override
    public MyCustomService initiateService(Map configurationValues, ServiceRegistryImplementor registry) {
      // define your custom service implementation here
      return new MyCustomServiceImpl();
    }

    @Override
    public Class<MyCustomService> getServiceInitiated() {
      return MyCustomService.class;
    }
  }
}
