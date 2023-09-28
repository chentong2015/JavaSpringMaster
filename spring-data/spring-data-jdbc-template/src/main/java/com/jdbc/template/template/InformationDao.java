package com.jdbc.template.template;

import com.jdbc.template.model.Information;

public interface InformationDao {

    boolean insertInformation(Information info);

    Information getInformation(int id);

    void cleanupTable();
}
