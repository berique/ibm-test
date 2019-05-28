package br.com.ibm.assassinato.actors;

import br.com.ibm.assassinato.models.Gun;
import br.com.ibm.assassinato.models.Location;
import br.com.ibm.assassinato.models.Suspect;

class Hypotesis {
    private Gun gun;

    private Location location;

    private Suspect suspect;

    public Hypotesis(Suspect suspect, Gun gun, Location location) {
        this.gun = gun;
        this.location = location;
        this.suspect = suspect;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Suspect getSuspect() {
        return suspect;
    }

    public void setSuspect(Suspect suspect) {
        this.suspect = suspect;
    }

    @Override
    public String toString() {
        return "" +
                "gun=" + gun +
                ", location=" + location +
                ", suspect=" + suspect + " ";
    }
}
