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

import java.util.Scanner;

@Service
@Order(2)
public class InputCommandLine implements CommandLineRunner {
    private final static Logger LOGGER = LoggerFactory.getLogger(InputCommandLine.class);

    private Witness witness;

    private WitnessValidation witnessValidation;

    @Autowired
    public InputCommandLine(Witness witness, WitnessValidation witnessValidation) {
        this.witness = witness;
        this.witnessValidation = witnessValidation;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            try {
                LOGGER.info("Digite o id do suspeito, id da arma e id do local");
                LOGGER.info("EX: 1, 1, 1");
                Scanner s = new Scanner(System.in);
                String str = s.nextLine();
                str = str.replaceAll("\\s+", "");
                String ars[] = str.split("\\,");
                int suspect = Integer.parseInt(ars[0]);
                int gun = Integer.parseInt(ars[1]);
                int location = Integer.parseInt(ars[2]);
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
                LOGGER.info("{}", witness);
                IncorrectType[] result = witnessValidation.validate(Guess.DetectiveGuessBuilder.aDetectiveGuess()
                        .withGun(HypothesisUtils.GUNS[gun])
                        .withLocation(HypothesisUtils.LOCATIONS[location])
                        .withSuspect(HypothesisUtils.SUSPECTS[suspect])
                        .build(), witness);
                if ( result.length == 0 ) {
                    LOGGER.info("0");
                    break;
                } else {
                    LOGGER.info("Resultado:");
                    String tmp = "";
                    for ( IncorrectType type: result ) {
                        if (!StringUtils.isEmpty(tmp)) {
                            tmp += ", ";
                        }
                        tmp += type.getType();
                    }
                    LOGGER.info(tmp);
                }
            } catch (Exception e) {
                LOGGER.info(e.getMessage(), e);
            }
        }
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
