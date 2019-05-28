package br.com.ibm.assassinato.services;

import br.com.ibm.assassinato.actors.Witness;
import org.springframework.stereotype.Service;

import static br.com.ibm.assassinato.utils.HypothesisUtils.*;
import static br.com.ibm.assassinato.utils.RandomUtils.random;

@Service
public class WitnessGeneratorService implements WitnessGenerator {
    @Override
    public Witness generate() {
        return new Witness(GUNS[random(GUNS.length)], LOCATIONS[random(LOCATIONS.length)], SUSPECTS[random(SUSPECTS.length)]);
    }
}
