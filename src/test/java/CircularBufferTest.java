import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {
    CircularBuffer cb = new CircularBuffer();

    @Test
    public void create_new_buffer_should_empty(){
        boolean result = cb.isEmpty();
        assertTrue("Buffer not empty", result);
    }

    @Test
    public void create_new_buffer_should_full(){
        for(int i =0;i<10;i++){
            cb.writeData("A"+i);
        }
        boolean result = cb.isFull();
        assertTrue("Buffer Not full", result);
    }

    @Test
    public void create_new_buffer_with_default_size_should_10(){
        int size = 10;
        boolean result = cb.isSameSize(size);
        assertTrue("Buffer size is not ten", result);
    }

    @Test
    public void write_A_B_to_buffer_should_read_A_B(){
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }

    @Test
    public void overwrite_A_with_B_to_first_buffer_after_full(){
        for(int i =0;i<10;i++){
            cb.writeData("A"+i);
        }
        cb.writeData("B");
        assertEquals("B", cb.readData());
    }

    @Test
    public void set_new_buffer_size_from_ten_to_15(){
        int size = 15;
        cb.setSize(size);
        boolean result = cb.isSameSize(size);
        assertTrue("Buffer is not "+size+" in size",result);
    }

    @Test
    public void write_A_on_buffer_at_slot_3(){
        int slot = 3;
        cb.writeDataSlot("A",slot);
        boolean result = cb.checkOnSlot("A",slot);
        assertTrue("A isn't in slot 3",result);
    }

    @Test
    public void remove_A_on_first_buffer(){
        int slot = 1;
        cb.writeDataSlot("A",slot);
        cb.remove(slot);
        assertNull(cb.readData());
    }
}