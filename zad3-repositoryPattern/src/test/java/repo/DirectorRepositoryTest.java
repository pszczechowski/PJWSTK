package repo;


import fields.Director;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DirectorRepositoryTest {

    @Mock
    Connection connection;

    @Mock
    PreparedStatement preparedStatement;

    @Mock
    ResultSet resultSet;

    @Mock
    Map<Long, Director> loadedMap;

    Director director;

    DirectorRepository directorRepo;
    @Before
    public void setup() throws Exception {
        directorRepo = new DirectorRepository(connection);
    }

    @Test
    public void create() throws Exception{
        when(connection.prepareStatement(any(String.class),anyInt())).thenReturn(preparedStatement);

        director = new Director();
        director.setId(1);
        director.setDirectorDayOfBirth(LocalDate.of(1993, Month.JANUARY, 1));
        director.setDirectorBiography("bio");
        director.setDirectorName("Name");
        director.setIdTvSeries(2);

        new DirectorRepository(connection).add(director);
    }

    @Test (expected = NullPointerException.class)
    public void createNullPassed(){

        new DirectorRepository(connection).add(null);
    }

    @Test
    public void remove() throws Exception{

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);

        directorRepo.remove(director);
    }

    @Test (expected = NullPointerException.class)
    public void removeNullPassed() throws Exception{

        directorRepo.remove(null);
    }

    @Test
    public void find() throws Exception {
        Director d = new Director(1,"Adam",LocalDate.now(),"Bio",0);

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setLong(anyInt(),anyLong());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        when(resultSet.getInt(any())).thenReturn(d.getId());
        when(resultSet.getDate(any())).thenReturn(Date.valueOf(d.getDirectorDayOfBirth()));
        when(resultSet.getString("directorName")).thenReturn(d.getDirectorName());
        when(resultSet.getString("directorBiography")).thenReturn(d.getDirectorBiography());

        Assert.assertEquals(d,directorRepo.GetById(1));
    }


    @Test
    public void update() throws Exception {
        Director temp = new Director(1,"Adam",LocalDate.now(),"Bio",1);
        Director tempUpdated = new Director(1,"Jan",LocalDate.now(),"Brak",1);

        when(connection.prepareStatement(any())).thenReturn(preparedStatement);

        directorRepo.update(tempUpdated);

        temp.setDirectorBiography("Brak");
        temp.setDirectorName("Jan");

        Assert.assertEquals(temp, tempUpdated);

    }

    @Test (expected = NullPointerException.class)
    public void updateNullPassed() throws Exception {
        when(connection.prepareStatement(any())).thenReturn(preparedStatement);
        directorRepo.update(null);
    }






}
