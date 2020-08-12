package es.pc.repository;

import es.pc.entity.VehiculoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehiculoRepositoryImplTest {

    @InjectMocks
    private VehiculoRepositoryImpl repository;

    @Mock
    private Connection conn;

    @Test
    public void shouldReturnDataWhenCall() throws SQLException {

        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(conn.prepareStatement(SqlConstants.SELECT_ALL)).thenReturn(preparedStatement);
        ResultSet resultSet = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);


        List<VehiculoEntity> vehiculos = repository.getVehiculos();
        assertNotNull(vehiculos);
        assertEquals(0,vehiculos.size());
    }
}