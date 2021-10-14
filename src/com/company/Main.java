package com.company;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        BitReader bitReader = new BitReader();
        BitWriter bitWriter = new BitWriter();
        Path filePath = Paths.get("D:\\Sem1\\Morariu\\test.txt");
        FileChannel fileChannel;
        fileChannel = FileChannel.open(filePath);
        long fileSize = fileChannel.size() * 8;
        while(fileSize > 0){

            int r = 32;
            if(fileSize < r){
                r = (int) fileSize;
            }

            int val = bitReader.readNBits(r);
            bitWriter.writeNBits(r, val);
            fileSize -= r;
        }




    }
}
