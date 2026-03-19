package edu.kennesaw.teashop.util;

import java.util.Scanner;

public class ScannerSingleton {

    private static final Scanner INSTANCE = new Scanner(System.in);

    private ScannerSingleton(){}

    public static Scanner getInstance(){
        return INSTANCE;
    }
}
