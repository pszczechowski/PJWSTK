package mapper;


import fields.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorMapper extends AbstractMapper<Director> {

    private static final String COLUMNS = "id, directorName,directorDayOfBirth,directorBiography";
    public static final String FIND = "SELECT " + COLUMNS + " FROM Director WHERE id=?";
    public static final String INSERT = "INSERT INTO Director(directorName,directorDayOfBirth,directorBiography) VALUES(?,?,?)";
    public static final String UPDATE = "UPDATE Director SET(directorName,directorDayOfBirth,directorBiography)=(?,?,?) WHERE id=?";
    public static final String DELETE = "DELETE FROM Director WHERE id=?";

    public DirectorMapper(Connection connection){
        super(connection);
    }

    @Override
    protected String findStatement() {
        return FIND;
    }

    @Override
    protected String insertStatement() {
        return INSERT;
    }

    @Override
    protected String updateStatement() {
        return UPDATE;
    }

    @Override
    protected String removeStatement() {
        return DELETE;
    }

    @Override
    protected Director doLoad(ResultSet rs) throws SQLException {
        Director d = new Director();
        d.setId(rs.getInt("id"));
        d.setDirectorName(rs.getString("directorName"));
        d.setDirectorDayOfBirth(rs.getDate("directorDayOfBirth").toLocalDate());
        d.setDirectorBiography(rs.getString("directorBiography"));
        return d;
    }


    @Override
    protected void parametrizeInsertStatement(PreparedStatement statement, Director d) throws SQLException {
        statement.setString(1,d.getDirectorName());
        statement.setDate(2,java.sql.Date.valueOf(d.getDirectorDayOfBirth()));
        statement.setString(3,d.getDirectorBiography());
    }

    @Override
    protected void parametrizeUpdateStatement(PreparedStatement statement, Director d) throws SQLException {
        parametrizeInsertStatement(statement, d);
        statement.setLong(1,d.getId());
    }


}
