package hu.bme.mit.train.sensor;

import org.junit.Before;
import org.junit.Test;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

	TrainController ctrl;
	TrainUser usr;
	TrainSensor sense;
	
    @Before
    public void before() {
        ctrl=mock(TrainController.class);
        usr=mock(TrainUser.class);
        sense=new TrainSensorImpl(ctrl, usr);
    }

    @Test
    public void Correct() {
        sense.overrideSpeedLimit(100);
        assertEquals(100, sense.getSpeedLimit());
        assertEquals(false, usr.getAlarmState());
    }
    
    @Test
    public void AbsoluteSmall() {
        sense.overrideSpeedLimit(-1);
        verify(usr).setAlarmState(true);
    }
    
    @Test
    public void AbsoluteLarge() {
        sense.overrideSpeedLimit(501);
        verify(usr).setAlarmState(true);
    }
    
    @Test
    public void RelativeSmall() {
        sense.overrideSpeedLimit(101);
        sense.overrideSpeedLimit(45);
        verify(usr).setAlarmState(true);
    }
}
