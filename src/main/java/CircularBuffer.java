public class CircularBuffer {
    private final int bufferSize;
    private String[] buffer;
    private int readPointer;
    private int writePointer;

    public CircularBuffer() {
        this(10);
    }

    public CircularBuffer(int size) {
        this.bufferSize = size;
        this.buffer = new String[bufferSize];
    }

    public boolean isEmpty() {
//        for(int i = 0; i<bufferSize; i++){
//            if(this.buffer[readPointer] == null){
//                readPointer++;
//            } else {
//                return false;
//            }
//        }
//        return readPointer==bufferSize;
        return readPointer == writePointer;
    }

    public void writeData(String input) {
        this.buffer[writePointer++] = input;
        if(writePointer ==bufferSize){
            writePointer = 0;
        }
    }

    public boolean isFull() {
//        for(int i = 0; i<bufferSize; i++){
//            if(this.buffer[readPointer] != null){
//                readPointer++;
//            }
//            else{
//                return false;
//            }
//        }
//        return readPointer==bufferSize;
        return writePointer>=bufferSize;
    }

    public String readData() {
        return this.buffer[readPointer++];
    }

    public void setSize(int input) {
        this.buffer = new String[input];
    }

    public boolean isSameSize(int size){
        return this.buffer.length == size;
    }

    public void writeDataSlot(String a, int i) {
        this.buffer[i-1] = a;
    }

    public boolean checkOnSlot(String a, int slot) {
        return this.buffer[slot - 1].equals(a);
    }

    public void remove(int i) {
        this.buffer[i-1] = null;
    }
}
