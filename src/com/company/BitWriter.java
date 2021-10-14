package com.company;

import java.io.FileOutputStream;
import java.io.IOException;

public class BitWriter {

    private byte bufferWriter;
    private int numberOfBitsWritten;
    private final FileOutputStream out;



    public BitWriter() throws IOException {
        numberOfBitsWritten = 0;
        out = new FileOutputStream("the-file-name");
    }

    private boolean isBufferFull() {
        return numberOfBitsWritten == 8;
    }

    private void writeBit(int value) throws IOException {

        bufferWriter = (byte) (2 * bufferWriter + value);
        numberOfBitsWritten++;

        if (isBufferFull()) {
            numberOfBitsWritten = 0;
            out.write(bufferWriter);
        }
    }

    public void writeNBits(int numberOfBits, int value) throws IOException {

        for(int i = numberOfBits - 1; i >= 0; i--){
            int bit = (value >> i) % 2;
            writeBit(bit);
        }
    }
}
