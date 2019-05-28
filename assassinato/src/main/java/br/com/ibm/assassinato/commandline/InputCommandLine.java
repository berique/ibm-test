package br.com.ibm.assassinato.commandline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class InputCommandLine implements CommandLineRunner {
    private final static Logger LOGGER = LoggerFactory.getLogger(InputCommandLine.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Digite o id da arma");
    }
}
