package br.com.ibm.assassinato.commandline;

import br.com.ibm.assassinato.actors.Guess;
import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.models.IncorrectType;
import br.com.ibm.assassinato.services.WitnessValidation;
import br.com.ibm.assassinato.utils.HypothesisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Order(2)
public class InputCommandLine implements CommandLineRunner {
    private final static Logger LOGGER = LoggerFactory.getLogger(InputCommandLine.class);

    private final GetInput getInput;

    private final Witness witness;

    private final WitnessValidation witnessValidation;

    @Autowired
    public InputCommandLine(Witness witness, GetInput getInput, WitnessValidation witnessValidation) {
        this.witness = witness;
        this.witnessValidation = witnessValidation;
        this.getInput = getInput;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            LOGGER.info("Digite o id do suspeito, id da arma e id do local");
            LOGGER.info("EX: 1, 1, 1");
            String str = getInput.read();
            LOGGER.info("Entrada: {}", str);
            String[] ars = parseInput(str);
            if (ars.length < 3) {
                LOGGER.info("Numero de parametro insuficientes");
                continue;
            }
            int suspect, gun, location;
            try {
                suspect = Integer.parseInt(ars[0]);
            } catch (NumberFormatException e) {
                LOGGER.info("{} é id de suspeito é inválido.", ars[0]);
                continue;
            }
            try {
                gun = Integer.parseInt(ars[1]);
            } catch (NumberFormatException e) {
                LOGGER.info("{} é id de arma é inválido.", ars[1]);
                continue;
            }
            try {
                location = Integer.parseInt(ars[2]);
            } catch (NumberFormatException e) {
                LOGGER.info("{} é id de local é inválido.", ars[2]);
                continue;
            }
            if (validateInput(suspect, HypothesisUtils.SUSPECTS.length) == false) {
                LOGGER.info("{} é id de suspeito é inválido.", suspect);
                continue;
            }
            if (validateInput(gun, HypothesisUtils.GUNS.length) == false) {
                LOGGER.info("{} é id de arma é inválido.", gun);
                continue;
            }

            if (validateInput(location, HypothesisUtils.LOCATIONS.length) == false) {
                LOGGER.info("{} é id de local é inválido.", location);
                continue;
            }
            for (String arg : args) {
                if (arg.equals("-d")) {
                    LOGGER.info("{}", witness);
                }
            }
            IncorrectType[] result = witnessValidation.validate(Guess.DetectiveGuessBuilder.aDetectiveGuess()
                    .withGun(HypothesisUtils.GUNS[gun])
                    .withLocation(HypothesisUtils.LOCATIONS[location])
                    .withSuspect(HypothesisUtils.SUSPECTS[suspect])
                    .build(), witness);
            if (result.length == 0) {
                LOGGER.info("0");
                break;
            } else {
                LOGGER.info("Resultado:");
                String tmp = "";
                for (IncorrectType type : result) {
                    if (!StringUtils.isEmpty(tmp)) {
                        tmp += ", ";
                    }
                    tmp += type.getType();
                }
                LOGGER.info(tmp);
            }
        }
    }

    private String[] parseInput(String str) {
        str = str.replaceAll("\\s+", "");
        return str.split("\\,");
    }

    private boolean validateInput(int suspect, int length) {
        if (suspect < 0) {
            return false;
        }
        if (suspect > length) {
            return false;
        }
        return true;
    }
}
