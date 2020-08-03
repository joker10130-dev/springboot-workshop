import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {
    @Test
    public void create_new_buffer_should_empty(){
        CircularBuffer cb = new CircularBuffer();
        boolean result = cb.isEmpty();
        assertTrue("Buffer not empty", result);
    }

    @Test
    public void create_new_buffer_should_full(){
        CircularBuffer cb = new CircularBuffer();
        for(int i =0;i<10;i++){
            cb.writeData("A"+i);
        }
        boolean result = cb.isFull();
        assertTrue("Buffer Not full", result);
    }

    @Test
    public void create_new_buffer_with_default_size_should_10(){
        CircularBuffer cb = new CircularBuffer();
        int size = 10;
        boolean result = cb.isSameSize(size);
        assertTrue("Buffer size is not ten", result);
    }

    @Test
    public void write_A_B_to_buffer_should_read_A_B(){
        CircularBuffer cb = new CircularBuffer();
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }

    @Test
    public void overwrite_A_with_B_to_first_buffer_after_full(){
        CircularBuffer cb = new CircularBuffer();
        for(int i =0;i<10;i++){
            cb.writeData("A"+i);
        }
        cb.writeData("B");
        assertEquals("B", cb.readData());
    }

//    @Test
//    public void set_new_buffer_size_from_ten_to_15(){
//        CircularBuffer cb = new CircularBuffer();
//        int size = 15;
//        cb.setSize(size);
//        boolean result = cb.isSameSize(size);
//        assertTrue(result);
//    }
}