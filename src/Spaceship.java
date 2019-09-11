package src;

public class Spaceship {
    public static Engine Engine;
    public IPerson[] Crew;

    public Spaceship(IPerson[] crew, Engine engine) {
        this.Crew = crew;
        Engine = engine;
    }

    public void swim() {
        for (IPerson person: Crew) {
            person.swim(this);
        }
    }

    public enum Engine {
        PHOTONIC,
        KEROCINIC,
        BENZINIC,
        ANY_OTHER
    }
}
