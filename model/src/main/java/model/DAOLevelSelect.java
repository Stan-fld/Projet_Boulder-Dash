package model;


import entity.Level;
import entity.LevelSelect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *
 *
 */
class DAOLevelSelect extends DAOEntity<Level>
{

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public DAOLevelSelect(Connection connection) throws SQLException {
        super(connection);
    }

    @Override
    public boolean create(Level entity) {
        return false;
    }

    @Override
    public boolean delete(Level entity) {
        return false;
    }

    @Override
    public boolean update(Level entity) {
        return false;
    }

    public Level find(final int id) {
        Level level = new Level();

        try {
            final String sql = "{call LevelSelect(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                level = new Level(resultSet.getString("Level"));
            }
            return level;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    }

