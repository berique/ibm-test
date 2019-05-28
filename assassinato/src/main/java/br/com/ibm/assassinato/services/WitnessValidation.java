package br.com.ibm.assassinato.services;

import br.com.ibm.assassinato.actors.Guess;
import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.models.IncorrectType;

public interface WitnessValidation {
    IncorrectType[] validate(Guess detectiveGuess, Witness witness);
}
