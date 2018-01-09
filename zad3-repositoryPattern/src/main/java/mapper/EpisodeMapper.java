package mapper;


import fields.Episode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EpisodeMapper extends AbstractMapper<Episode> {

    private static final String COLUMNS = "id, episodeName,episodeReleaseDate,episodeNumber,episodeDuration";
    public static final String FIND = "SELECT " + COLUMNS + " FROM Episode WHERE id=?";
    public static final String INSERT = "INSERT INTO Episode(episodeName,episodeReleaseDate,episodeNumber,episodeDuration,idSeason) VALUES(?,?,?,?,?)";
    public static final String UPDATE = "UPDATE Episode SET(episodeName,episodeReleaseDate,episodeNumber,episodeDuration)=(?,?,?,?) WHERE id=?";
    public static final String DELETE = "DELETE FROM Episode WHERE id=?";

    public EpisodeMapper(Connection connection){
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
    protected Episode doLoad(ResultSet rs) throws SQLException {
        Episode e = new Episode();
        e.setId(rs.getInt("id"));
        e.setEpisodeName(rs.getString("episodeName"));
        e.setEpisodeDuration(rs.getString("episodeDuration"));
        e.setEpisodeReleaseDate(rs.getDate("episodeReleaseDate").toLocalDate());
        e.setEpisodeNumber(rs.getInt("episodeNumber"));
        return e;
    }

    @Override
    protected void parametrizeInsertStatement(PreparedStatement statement, Episode e) throws SQLException {
        statement.setString(1,e.getEpisodeName());
        statement.setDate(2,java.sql.Date.valueOf(e.getEpisodeReleaseDate()));
        statement.setInt(3,e.getEpisodeNumber());
        statement.setString(4,e.getEpisodeDuration());
        statement.setInt(5,e.getIdSeason());
    }

    @Override
    protected void parametrizeUpdateStatement(PreparedStatement statement, Episode e) throws SQLException {
        parametrizeInsertStatement(statement, e);
        statement.setLong(1,e.getId());
    }
}
