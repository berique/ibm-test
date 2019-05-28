package br.com.ibm.assassinato.models;

import br.com.ibm.assassinato.services.validator.WitnessValidator;
import br.com.ibm.assassinato.services.validator.WitnessValidatorGun;
import br.com.ibm.assassinato.services.validator.WitnessValidatorLocation;
import br.com.ibm.assassinato.services.validator.WitnessValidatorSuspect;

public enum IncorrectType {
    MUDER(1, new WitnessValidatorSuspect()),
    LOCATION(2, new WitnessValidatorLocation()),
    GUN(3, new WitnessValidatorGun());

    private final WitnessValidator witnessValidator;
    private final int type;

    IncorrectType(int type, WitnessValidator witnessValidator) {
        this.type = type;
        this.witnessValidator = witnessValidator;
    }

    public WitnessValidator getWitnessValidator() {
        return witnessValidator;
    }

    public int getType() {
        return type;
    }
}
