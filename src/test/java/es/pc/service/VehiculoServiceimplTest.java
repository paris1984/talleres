package es.pc.service;

import es.pc.entity.VehiculoEntity;
import es.pc.exception.BusinessException;
import es.pc.repository.VehiculoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VehiculoServiceimplTest {

    @InjectMocks
    private VehiculoServiceimpl service;

    @Mock
    private VehiculoRepository vehiculoRepository;

    @Test
    public void shouldReturnOk(){

        String matricula = "1234-ZZZ";
        VehiculoEntity entity = mock(VehiculoEntity.class);
        when(vehiculoRepository.getVehiculo(matricula)).thenReturn(entity);
        VehiculoEntity vehiculo = service.getVehiculo(matricula);
        assertNotNull(vehiculo);
        assertEquals(entity,vehiculo);
    }

    @Test(expected = BusinessException.class)
    public void shouldReturnEmpty(){

        String matricula = "1234-ZZZ";

        when(vehiculoRepository.getVehiculo(matricula)).thenReturn(null);
        try{
            service.getVehiculo(matricula);
        }catch (BusinessException be){
            assertEquals("404",be.getCodeId());
            throw be;
        }
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnKO(){
        String matricula = "1234-ZZZ";
        VehiculoEntity entity = mock(VehiculoEntity.class);
        when(vehiculoRepository.getVehiculo(matricula)).thenThrow(new NullPointerException("message"));
        service.getVehiculo(matricula);
    }
}