package br.com.ibm.assassinato.commandline;

import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.models.Gun;
import br.com.ibm.assassinato.models.Location;
import br.com.ibm.assassinato.models.Suspect;
import br.com.ibm.assassinato.services.WitnessValidation;
import br.com.ibm.assassinato.utils.HypothesisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class BannerCommandLine implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(BannerCommandLine.class);

    private final Witness witness;

    private final WitnessValidation witnessValidator;

    @Autowired
    public BannerCommandLine(Witness witness, WitnessValidation witnessValidation) {
        this.witness = witness;
        this.witnessValidator = witnessValidation;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Suspeitos:");
        LOGGER.info("=========");
        LOGGER.info("");
        getSuspects();
        LOGGER.info("");
        LOGGER.info("Locais:");
        LOGGER.info("=======");
        LOGGER.info("");
        getLocations();
        LOGGER.info("");
        LOGGER.info("Armas:");
        LOGGER.info("======");
        LOGGER.info("");
        getGuns();
        LOGGER.info("");
        if (args.length > 0) {
            for (int x = 0; x < args.length; x++) {
                if (args[x].equals("-d")) {
                    LOGGER.info("Testemunha: {}", witness);
                }
            }
        }

    }

    private void getLocations() {
        int x = 0;
        for (Location location : HypothesisUtils.LOCATIONS) {
            LOGGER.info("{}: {}", x, location.getName());
            ++x;
        }
    }

    private void getSuspects() {
        int x = 0;
        for (Suspect suspect : HypothesisUtils.SUSPECTS) {
            LOGGER.info("{}: {}", x, suspect.getName());
            ++x;
        }
    }

    private void getGuns() {
        int x = 0;
        for (Gun gun : HypothesisUtils.GUNS) {
            LOGGER.info("{}: {}", x, gun.getName());
            ++x;
        }
    }
}
