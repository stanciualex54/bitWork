package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BitReader {

    private static byte[] bufferReader;
    private int numberOfBitsRead;


    public static void readBit(Path filePath) throws IOException {

        bufferReader = Files.readAllBytes(filePath);

    }

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("D:\\Sem1\\Morariu\\test.txt");
        readBit(filePath);

    }
}
