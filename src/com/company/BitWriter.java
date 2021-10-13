package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class BitWriter {

    private byte bufferWriter;
    private int numberOfBitsWritten;

    public BitWriter(){
        numberOfBitsWritten = 0;
    }

    private boolean isBufferFull() {
        return numberOfBitsWritten == 8;
    }

    private void writeBit(int value) {

        int lastBit = (value >> numberOfBitsWritten) % 2;
        bufferWriter = (byte) (2 * bufferWriter + lastBit);
        numberOfBitsWritten++;

        if (isBufferFull()) {
            numberOfBitsWritten = 0;
           //write to file
        }
    }
}
