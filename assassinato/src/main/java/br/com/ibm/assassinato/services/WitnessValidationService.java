package br.com.ibm.assassinato.services;

import br.com.ibm.assassinato.actors.Guess;
import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.models.IncorrectType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WitnessValidationService implements WitnessValidation{

    public IncorrectType[] validate(Guess detectiveGuess, Witness witness) {
        List<IncorrectType> incorrectTypes = new ArrayList<>();
        for (IncorrectType incorrectType : IncorrectType.values()) {
            if (incorrectType.getWitnessValidator().validate(detectiveGuess, witness) == false) {
                incorrectTypes.add(incorrectType);
            }
        }
        return incorrectTypes.toArray(new IncorrectType[]{});
    }

}
