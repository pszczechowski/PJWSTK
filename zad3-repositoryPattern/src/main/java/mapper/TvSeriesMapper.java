package mapper;


import fields.TvSeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TvSeriesMapper extends AbstractMapper<TvSeries> {

    private static final String COLUMNS = "id, tvSeriesName";
    public static final String FIND = "SELECT " + COLUMNS + " FROM TvSeries WHERE id=?";
    public static final String INSERT = "INSERT INTO TvSeries(tvSeriesName) VALUES(?)";
    public static final String UPDATE = "UPDATE TvSeries SET(tvSeriesName)=(?) WHERE id=?";
    public static final String DELETE = "DELETE FROM TvSeries WHERE id=?";

    public TvSeriesMapper(Connection connection){
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
    protected TvSeries doLoad(ResultSet rs) throws SQLException {
        TvSeries tv = new TvSeries();
        tv.setId(rs.getInt("id"));
        tv.setName(rs.getString("tvSeriesName"));
        return tv;
    }

    @Override
    protected void parametrizeInsertStatement(PreparedStatement statement, TvSeries tv) throws SQLException {
        statement.setString(1,tv.getName());
    }

    @Override
    protected void parametrizeUpdateStatement(PreparedStatement statement, TvSeries tv) throws SQLException {
        parametrizeInsertStatement(statement, tv);
        statement.setLong(1,tv.getId());
    }


}
