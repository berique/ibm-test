package br.com.ibm.assassinato.commandline;

import java.util.Scanner;

public class GetInputService implements GetInput {

    @Override
    public String read() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        return str;
    }
}
