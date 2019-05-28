package br.com.ibm.assassinato.services.validator;

import br.com.ibm.assassinato.actors.Guess;
import br.com.ibm.assassinato.actors.Witness;

public interface WitnessValidator {
    boolean validate(Guess detectiveGuess, Witness witness);
}
