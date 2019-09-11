package src;

public class Person implements IPerson {
    @Override
    public boolean feel(boolean ownWill, boolean justACoincidence, boolean physicalPrinciple) {
        return ownWill && justACoincidence && physicalPrinciple;
    }

    @Override
    public boolean haveRelationships(IPerson person) {
        return false;
    }

    @Override
    public boolean haveRelationships(IMolecule molecule) {
        return false;
    }

    @Override
    public boolean haveRelationships(IParticle atom) {
        return false;
    }

    @Override
    public void swim(Spaceship spaceship) {

    }
}
