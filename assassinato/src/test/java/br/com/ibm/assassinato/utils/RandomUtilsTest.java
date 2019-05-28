package br.com.ibm.assassinato.utils;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class RandomUtilsTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(RandomUtilsTest.class);

    @Test
    public void random() {
        int random = RandomUtils.random(10);
        LOGGER.info("Resultado do Random: {}", random);
        assertThat(random, CoreMatchers.not(11));
    }
}