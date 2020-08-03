public class CircularBuffer {
    private int bufferSize = 10;
    private String[] buffer;
    private int readPointer;
    private int writePointer;

    public CircularBuffer() {
        this.buffer = new String[10];
    }

    public boolean isEmpty() {
        for(int i = 0; i<10; i++){
            if(this.buffer[readPointer] == null){
                readPointer++;
            }
            else{
                return false;
            }
        }
        return readPointer==10;
    }

    public void writeData(String input) {
        this.buffer[writePointer++] = input;
        if(writePointer ==10){
            writePointer = 0;
        }
    }

    public boolean isFull() {
        for(int i = 0; i<10; i++){
            if(this.buffer[readPointer] != null){
                readPointer++;
            }
            else{
                return false;
            }
        }
        return readPointer==10;
    }

    public String readData() {
        return this.buffer[readPointer++];
    }

    public void setSize(int input) {
        this.buffer = new String[15];
    }

    public boolean isSameSize(int size){
        return this.buffer.length == size;
    }

    public void writeDataSlot(String a, int i) {
        this.buffer[i-1] = a;
    }

    public boolean checkOnSlot(String a, int slot) {
        return this.buffer[slot-1] == a;
    }

    public void remove(int i) {
        this.buffer[i-1] = null;
    }
}
