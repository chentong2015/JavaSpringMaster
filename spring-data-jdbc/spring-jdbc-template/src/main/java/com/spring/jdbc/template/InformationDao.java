package com.spring.jdbc.template;

import com.spring.jdbc.model.Information;

public interface InformationDao {

    boolean insertInformation(Information info);

    Information getInformation(int id);

    void cleanupTable();
}
