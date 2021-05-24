package io.com.dropwizard;

import io.com.dropwizard.dao.DBEntityDAO;
import io.com.dropwizard.model.DBEntity;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.CreateSqlObject;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public abstract class DAOService {


    @CreateSqlObject
    abstract DBEntityDAO dbEntityDAO() ;


    public void createPart(DBEntity dbEntity){
        dbEntityDAO().createPart(dbEntity);
    }



}
