package model;


import entity.Level;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *The DAOLevel class
 *
 * It returns the result from the database into a level object
 *
 * @author Valentin
 */

class DAOLevel extends DAOEntity<Level>
{

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection the connection
     * @throws SQLException the SQL exception
     */
    public DAOLevel(Connection connection) throws SQLException {
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


    /**
     * The find method
     *
     * It will communicates with the DAO by calling the LevelSelect procedure
     * @param id
     *          the id
     * @return
     */
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

