package com.smart.dao;

import com.smart.domain.ViewSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by Administrator on 2017/5/4.
 */
@Repository
public class ViewSpaceDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addViewSpace(ViewSpace viewSpace) {
        final String sql = "INSERT INTO t_view_space " +
                "(space_name,description,address) VALUES (?,?,?)";

        Object[] params = new Object[] {viewSpace.getSpaceName(),
                viewSpace.getDescription(),viewSpace.getAddress()};

        jdbcTemplate.update(sql, params, new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
    }

    public void addViewSpace1(final ViewSpace viewSpace) {
        final String sql = "INSERT INTO t_view_space " +
                "(space_name,description,address) VALUES (?,?,?)";

        Object[] params = new Object[] {viewSpace.getSpaceName(),
                viewSpace.getDescription(),viewSpace.getAddress()};

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return null;
            }
        });
    }
}
