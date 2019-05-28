package br.com.ibm.assassinato.config;

import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.services.WitnessGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureWitness {
    @Autowired
    WitnessGenerator witnessGenerator;

    @Bean
    public Witness witness() {
        return witnessGenerator.generate();
    }
}
