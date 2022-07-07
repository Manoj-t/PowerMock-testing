import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Service.class})
public class ServiceTest {


    @Test
    public void testStaticMethods(){

        // Mock static methods
        PowerMockito.mockStatic(Service.class);

        // Set expectation
        Mockito.when(Service.staticMessage()).thenReturn("New Message from Mock!");

        // invoke the method
        String message = Service.staticMessage();

        assertEquals(message, "New Message from Mock!");
    }

    @Test
    public void verifyStaticMethodInvocation(){

        /* To verify static method invocation first call PowerMockito.verifyStatic(Static.class) to start verifying
        behavior and then call the static method to verify. This is important to note that we need to
        call verifyStatic() per static method invocation */

        // Mock static methods
        PowerMockito.mockStatic(Service.class);

        // Set expectation
        Mockito.when(Service.staticMessage()).thenReturn("New Message from Mock!");

        // invoke the method
        String message = Service.staticMessage();

        assertEquals(message, "New Message from Mock!");

        PowerMockito.verifyStatic(Service.class, Mockito.times(1));
        Service.staticMessage();
    }

    @Test
    public void testFinalMethods(){

        // Create mock
        Service serviceMock = PowerMockito.mock(Service.class);

        // Set expectation
        Mockito.when(serviceMock.finalMessage()).thenReturn("Message when invoked final message!");

        // invoke the method
        String message = serviceMock.finalMessage();

        // Assert the stub response
        assertEquals("Message when invoked final message!", message);

        // Verify final method invocation
        Mockito.verify(serviceMock, Mockito.times(1)).finalMessage();
    }

    @Test
    public void mockPrivateMethodTest() throws Exception {

        // Mock the class using spy()
        Service serviceMock = PowerMockito.spy(new Service());

        // Set expectation
        PowerMockito.when(serviceMock, "privateMessage").thenReturn("Private Method is invoked!!");

        // invoke the private method using Whitebox API
        String privateMessage = Whitebox.invokeMethod(serviceMock, "privateMessage");

        // assert the stub response
        assertEquals(privateMessage, "Private Method is invoked!!");

        // verify the private method invocation
        PowerMockito.verifyPrivate(serviceMock, Mockito.times(1)).invoke("privateMessage");
    }
}
