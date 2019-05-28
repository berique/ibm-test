package br.com.ibm.assassinato.models;

public class Suspect {
    private String name;

    public Suspect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suspect suspect = (Suspect) o;

        return name.equals(suspect.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "name='" + name + '\'' +
                '}';
    }
}
