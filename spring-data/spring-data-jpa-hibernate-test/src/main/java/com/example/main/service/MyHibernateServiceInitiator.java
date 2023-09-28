package com.example.main.service;

import com.example.main.idgenerator.MyDefaultIdentifierGeneratorFactoryInitiator;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.PostgresPlusDialect;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public class MyHibernateServiceInitiator implements MyServiceInitiator {

    private BootstrapServiceRegistry bootstrapServiceRegistry;
    private StandardServiceRegistryBuilder standardServiceRegistryBuilder;
    private MetadataSources metadataSources = new MetadataSources();
    private Metadata metadata;

    public MyHibernateServiceInitiator() {
        this.metadata = getMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        System.out.println(sessionFactory.toString());
    }

    @Override
    public Metadata getMetadata() {
        this.bootstrapServiceRegistry = new BootstrapServiceRegistryBuilder().build();
        this.standardServiceRegistryBuilder = new StandardServiceRegistryBuilder(bootstrapServiceRegistry);

        // 配置Properties信息必须和指定的数据库对应
        Properties properties = new Properties();
        properties.put(AvailableSettings.URL, "jdbc:postgresql://localhost:5432/my_database");
        properties.put(AvailableSettings.USER, "postgres");
        properties.put(AvailableSettings.PASS, "admin");
        properties.put(AvailableSettings.DIALECT, PostgresPlusDialect.class.getName());
        standardServiceRegistryBuilder.applySettings(properties);

        standardServiceRegistryBuilder.addInitiator(new MyDefaultIdentifierGeneratorFactoryInitiator());

        StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.build();
        MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder(standardServiceRegistry);
        return metadataBuilder.build();
    }
}
