package week05;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff){
        this.destinationCoordinates = diff;
    }

    @Override
    public String toString() {
        return "Satellite" + registerIdent + "destinationCoordinates:" + destinationCoordinates;
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }
}
