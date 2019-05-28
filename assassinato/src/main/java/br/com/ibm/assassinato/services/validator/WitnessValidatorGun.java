package br.com.ibm.assassinato.services.validator;

import br.com.ibm.assassinato.actors.Guess;
import br.com.ibm.assassinato.actors.Witness;
import org.springframework.stereotype.Service;

@Service
public class WitnessValidatorGun implements WitnessValidator {

    @Override
    public boolean validate(Guess detectiveGuess, Witness witness) {
        return detectiveGuess.getGun().equals(witness.getGun());
    }
}
