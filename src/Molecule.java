package src;

public class Molecule implements IParticle {
    @Override
    public boolean haveRelationships(IPerson person) {
        return true;
    }

    @Override
    public boolean haveRealtionships(IParticle molecule) {
        return true;
    }
}
