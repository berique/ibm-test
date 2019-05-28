package br.com.ibm.assassinato.services;

import br.com.ibm.assassinato.actors.Guess;
import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.models.IncorrectType;
import org.junit.Test;

import static br.com.ibm.assassinato.utils.HypothesisUtils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WitnessValidationServiceTest {

    @Test
    public void validate() {
        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build()
        ).length, is(0));

        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[2])
                        .withSuspect(SUSPECTS[1])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build()
        ), is(new IncorrectType[]{IncorrectType.LOCATION}));

        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[2])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build()
        ), is(new IncorrectType[]{IncorrectType.MUDER}));

        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[2])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build()
        ), is(new IncorrectType[]{IncorrectType.GUN}));

        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[2])
                        .withLocation(LOCATIONS[2])
                        .withSuspect(SUSPECTS[1])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build()
        ), is(new IncorrectType[]{IncorrectType.LOCATION, IncorrectType.GUN}));

        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[2])
                        .withLocation(LOCATIONS[2])
                        .withSuspect(SUSPECTS[2])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[2])
                        .build()
        ), is(new IncorrectType[]{IncorrectType.LOCATION, IncorrectType.GUN}));

        assertThat(new WitnessValidationService().validate(
                Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(GUNS[2])
                        .withLocation(LOCATIONS[2])
                        .withSuspect(SUSPECTS[2])
                        .build(),
                Witness.WitnessBuilder.aWitness()
                        .withGun(GUNS[1])
                        .withLocation(LOCATIONS[1])
                        .withSuspect(SUSPECTS[1])
                        .build()
        ), is(new IncorrectType[]{IncorrectType.MUDER, IncorrectType.LOCATION, IncorrectType.GUN}));
    }
}