package br.com.ibm.assassinato.commandline;

import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.services.WitnessGenerator;
import br.com.ibm.assassinato.services.WitnessGeneratorService;
import br.com.ibm.assassinato.services.WitnessValidationService;
import org.junit.Test;

import static org.junit.Assert.*;


public class BannerCommandLineTest {

    @Test
    public void run() throws Exception {
        new BannerCommandLine(new WitnessGeneratorService().generate(),
                new WitnessValidationService()).run(new String[] { "-d" });
    }
}