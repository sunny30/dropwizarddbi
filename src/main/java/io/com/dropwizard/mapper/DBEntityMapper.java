package io.com.dropwizard.mapper;

import io.com.dropwizard.model.DBEntity;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBEntityMapper implements ResultSetMapper<DBEntity> {

    public DBEntity map(int i, ResultSet resultSet, StatementContext statementContex) throws SQLException {

        return new DBEntity(resultSet.getInt("id"),resultSet.getString("name"),
                resultSet.getString("description"),resultSet.getString("type"));

    }


}
