package mapper;

import fields.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper extends AbstractMapper<Actor> {

    private static final String COLUMNS = "id, actorName,actorDayOfBirth,actorBiography";
    public static final String FIND = "SELECT " + COLUMNS + " FROM Actor WHERE id=?";
    public static final String INSERT = "INSERT INTO Actor(actorName,actorDayOfBirth,actorBiography,idTvSeries) VALUES(?,?,?,?)";
    public static final String UPDATE = "UPDATE Actor SET(actorName,actorDayOfBirth,actorBiography,idTvSeries)=(?,?,?,?) WHERE id=?";
    public static final String DELETE = "DELETE FROM Actor WHERE id=?";

    public ActorMapper(Connection connection){
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
    protected Actor doLoad(ResultSet rs) throws SQLException {
        Actor a = new Actor();
        a.setId(rs.getInt("id"));
        a.setActorName(rs.getString("actorName"));
        a.setActorDayOfBirth(rs.getDate("actorDayOfBirth").toLocalDate());
        a.setActorBiography(rs.getString("actorBiography"));
        return a;
    }

    @Override
    protected void parametrizeInsertStatement(PreparedStatement statement, Actor a) throws SQLException {
        statement.setString(1,a.getActorName());
        statement.setDate(2,java.sql.Date.valueOf(a.getActorDayOfBirth()));
        statement.setString(3,a.getActorBiography());
        statement.setInt(4,a.getIdTvSeries());
    }

    @Override
    protected void parametrizeUpdateStatement(PreparedStatement statement, Actor a) throws SQLException {
        parametrizeInsertStatement(statement, a);
        statement.setLong(1,a.getId());
    }
}
