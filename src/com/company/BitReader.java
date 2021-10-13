package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BitReader {

    private byte bufferReader;
    private int numberOfBitsRead;
    private final byte[] bytesFromFile;
    private int count;


    public BitReader() throws IOException {

        numberOfBitsRead = 0;
        Path filePath = Paths.get("D:\\Sem1\\Morariu\\test.txt");
        bytesFromFile = Files.readAllBytes(filePath);
        bufferReader = bytesFromFile[0];
        count = 0;
    }

    private boolean isBufferEmpty() {
        return numberOfBitsRead == 0;
    }

    public int readBit() {

        if (isBufferEmpty()) {
            bufferReader = bytesFromFile[count];
            numberOfBitsRead = 8;
            count++;
        }
        int bit = (bufferReader >> numberOfBitsRead - 1) % 2;
        numberOfBitsRead--;
        return bit;
    }

    public int readNBits(int nr){

        int bitNumber = 0;
        for(int i = 0; i < nr; i++){
            int bit = readBit();
            bitNumber = 2 * bitNumber + bit;

        }
        return bitNumber;
    }

    public static void main(String[] args) throws IOException {

        BitReader bitReader = new BitReader();
        System.out.println(bitReader.bytesFromFile[0]);
        System.out.println(bitReader.bytesFromFile[1]);
        System.out.println();
        System.out.println(bitReader.readNBits(16));


    }
}
