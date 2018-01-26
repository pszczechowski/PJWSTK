package mapper;


import fields.Season;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SeasonMapper extends AbstractMapper<Season> {
    private static final String COLUMNS = "id, seasonNumber,seasonYearOfRelease";
    public static final String FIND = "SELECT " + COLUMNS + " FROM Season WHERE id=?";
    public static final String INSERT = "INSERT INTO Season(seasonNumber,seasonYearOfRelease,idTvSeries) VALUES(?,?,?)";
    public static final String UPDATE = "UPDATE Season SET(seasonNumber,seasonYearOfRelease,idTvSeries)=(?,?,?) WHERE id=?";
    public static final String DELETE = "DELETE FROM Season WHERE id=?";

    public SeasonMapper(Connection connection){
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
    public Season doLoad(ResultSet rs) throws SQLException {
        Season s = new Season();
        s.setId(rs.getInt("id"));
        s.setSeasonNumber(rs.getInt("seasonNumber"));
        s.setSeasonYearOfRelease(rs.getInt("seasonYearOfRelease"));

        return s;

    }

    @Override
    protected void parametrizeInsertStatement(PreparedStatement statement, Season s) throws SQLException {
        statement.setInt(1,s.getSeasonNumber());
        statement.setInt(2,s.getSeasonYearOfRelease());
        statement.setInt(3,s.getIdTvSeries());
    }

    @Override
    protected void parametrizeUpdateStatement(PreparedStatement statement, Season s) throws SQLException {
        parametrizeInsertStatement(statement,s);
        statement.setLong(1,s.getId());
    }



}
