package repo;


import fields.Director;
import mapper.AbstractMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DirectorRepositoryTest {


    @Mock
    Connection c;
    DBConnection connection;
    AbstractMapper<Director> mapper;
    DirectorRepository directorRepository;

    @Mock
    private Director d;

    @Before
    public void setup(){

        LocalDate date = LocalDate.now();
        Director d = mock(Director.class);
        d.setId(1);
        d.setDirectorName("John");
        d.setDirectorBiography("bio");
        d.setDirectorDayOfBirth(date);
        d.setIdTvSeries(1);

        mapper = mock(AbstractMapper.class);
        connection = mock(DBConnection.class);
    }


    @Test
    public void add() throws Exception {
        //given

        //when
        when(mapper.add(d)).thenReturn(1);
        //then
        Assert.assertEquals(1,mapper.add(d));
    }

    @Test
    public void add_null() throws Exception{
        Assert.assertEquals(0,mapper.add(null));
    }

    @Mock private Connection mockConnection;
    @Mock private PreparedStatement mockStatement;

    @Test (expected = NullPointerException.class)
    public void remove_objectDoesntExist() throws Exception{
        when(mockConnection.prepareStatement(Mockito.any()).executeUpdate()).thenReturn(0);
        directorRepository.remove(null);
    }

}