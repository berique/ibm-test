package br.com.ibm.assassinato.actors;

import br.com.ibm.assassinato.models.Gun;
import br.com.ibm.assassinato.models.Location;
import br.com.ibm.assassinato.models.Suspect;

public class Guess extends Hypotesis {
    public Guess(Gun gun, Location location, Suspect suspect) {
        super(suspect, gun, location);
    }


    public static final class DetectiveGuessBuilder {
        private Gun gun;
        private Location location;
        private Suspect suspect;

        private DetectiveGuessBuilder() {
        }

        public static DetectiveGuessBuilder aDetectiveGuess() {
            return new DetectiveGuessBuilder();
        }

        public DetectiveGuessBuilder withGun(Gun gun) {
            this.gun = gun;
            return this;
        }

        public DetectiveGuessBuilder withLocation(Location location) {
            this.location = location;
            return this;
        }

        public DetectiveGuessBuilder withSuspect(Suspect suspect) {
            this.suspect = suspect;
            return this;
        }

        public Guess build() {
            return new Guess(gun, location, suspect);
        }
    }

    @Override
    public String toString() {
        return "Guess{" + super.toString() + "}";
    }
}
