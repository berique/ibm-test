package br.com.ibm.assassinato.models;

public class Gun {

    private String name;

    public Gun(String name) {
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

        Gun gun = (Gun) o;

        return name.equals(gun.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Gun{" +
                "name='" + name + '\'' +
                '}';
    }
}
