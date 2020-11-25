package immutable.satellite;

import java.lang.reflect.Array;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        this.destinationCoordinates = destinationCoordinates;
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");}
        this.registerIdent = registerIdent;
    }

    public boolean isEmpty(String validateText) {
        if (validateText == null || validateText.isEmpty() || validateText.isEmpty()){
            return true;
        }
        return  false;
    }


    @Override
    public String toString() {
        return registerIdent + ": CelestialCoordinates:" + " x=" + destinationCoordinates.getX() +
                ", y=" + destinationCoordinates.getY() +
                ", z=" + destinationCoordinates.getZ();
    }

    public void modifyDestination(CelestialCoordinates diff){
        int x = this.destinationCoordinates.getX() + diff.getX();
        int y = this.destinationCoordinates.getY() + diff.getY();
        int z = this.destinationCoordinates.getZ() + diff.getZ();
    this.destinationCoordinates = new CelestialCoordinates(x, y, z);
    }

    public CelestialCoordinates getDestinationCoordinates() {

        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }
}
