package io.com.dropwizard.dao;

import io.com.dropwizard.mapper.DBEntityMapper;
import io.com.dropwizard.model.DBEntity;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(DBEntityMapper.class)
public interface DBEntityDAO {


    @SqlQuery("select * from entity;")
    public List<DBEntity> getEntity();

    @SqlQuery("select * from entity where id = :id")
    public DBEntity getDBEntity(@Bind("id") final int id);

    @SqlUpdate("insert into entity(name, type, description) values(:name, :type, :description)")
    void createPart(@BindBean final DBEntity dbEntity);

    @SqlQuery("select * from entity where name = :name")
    public DBEntity getPart(@Bind("name") final String name);

//    /*@SqlUpdate("update parts set name = coalesce(:name, name), code = coalesce(:code, code) where id = :id")
//    void editPart(@BindBean final Part part);
//
//    @SqlUpdate("delete from parts where id = :id")
//    int deletePart(@Bind("id") final int id);
//
//    @SqlQuery("select last_insert_id();")
//    public int lastInsertId();*/


}
