package model;


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
 * @version $Id: $Id
 */
public class DAOLevel extends DAOEntity<Level>
{

    /**
     * Instantiates a new DAO entity.
     *
     * @param connection the connection
     * @throws java.sql.SQLException the SQL exception
     */
    public DAOLevel(Connection connection) throws SQLException {
        super(connection);
    }

    /** {@inheritDoc} */
    @Override
    public boolean create(Level entity) {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean delete(Level entity) {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean update(Level entity) {
        return false;
    }


    /**
     * {@inheritDoc}
     *
     * The find method
     *
     * It will communicates with the DAO by calling the LevelSelect procedure
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

