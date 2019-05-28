package br.com.ibm.assassinato.actors;

import br.com.ibm.assassinato.models.Gun;
import br.com.ibm.assassinato.models.Location;
import br.com.ibm.assassinato.models.Suspect;

public class Witness extends Hypotesis {


    public Witness(Gun gun, Location location, Suspect suspect) {
        super(suspect, gun, location);
    }


    public static final class WitnessBuilder {
        private Gun gun;
        private Location location;
        private Suspect suspect;

        private WitnessBuilder() {
        }

        public static WitnessBuilder aWitness() {
            return new WitnessBuilder();
        }

        public WitnessBuilder withGun(Gun gun) {
            this.gun = gun;
            return this;
        }

        public WitnessBuilder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public WitnessBuilder withSuspect(Suspect suspect) {
            this.suspect = suspect;
            return this;
        }

        public Witness build() {
            return new Witness(gun, location, suspect);
        }
    }

    @Override
    public String toString() {
        return "Witness{ " + super.toString() + "}";
    }
}
