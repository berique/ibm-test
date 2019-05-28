package br.com.ibm.assassinato.commandline;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class GetInputService implements GetInput {

    @Override
    public String read() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        return str;
    }
}
