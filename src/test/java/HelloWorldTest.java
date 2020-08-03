import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test
    public void sayHi_should_return_Hello_World(){
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHi();
        assertEquals("Hello World", result);
    }
    @Test
    public void sayHi_with_somkiat_should_return_Hello_Somkiat() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHi("somkiat");
        assertEquals("Hello Somkiat", result);
    }
    @Test
    public void sayHi_with_pui_should_return_Hello_Somkiat() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHi("pui");
        assertEquals("Hello Pui", result);
    }
}