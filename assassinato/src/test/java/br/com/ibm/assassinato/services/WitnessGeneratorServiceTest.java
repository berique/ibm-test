package br.com.ibm.assassinato.services;

import br.com.ibm.assassinato.actors.Witness;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class WitnessGeneratorServiceTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(WitnessGeneratorServiceTest.class);

    private WitnessGeneratorService witnessGeneratorService = new WitnessGeneratorService();

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[20][0];
    }

    @Test
    public void generate() {
        Witness witness = witnessGeneratorService.generate();
        LOGGER.info("{}", witness);
        assertThat(witness, CoreMatchers.notNullValue());
    }
}