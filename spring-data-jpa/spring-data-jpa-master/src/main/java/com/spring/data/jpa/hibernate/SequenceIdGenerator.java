package com.spring.data.jpa.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class SequenceIdGenerator implements IdentifierGenerator {

    private SequenceStyleGenerator strategy;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        strategy = new SequenceStyleGenerator();
        strategy.configure(type, params, serviceRegistry);
    }

    @Override
    public void registerExportables(Database database) {
        strategy.registerExportables(database);
    }

    @Override
    public void initialize(SqlStringGenerationContext context) {
        strategy.initialize(context);
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return strategy.generate(session, object);
    }
}
