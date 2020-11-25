package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

    public class SpaceAgency {
        List<Satellite> satellites = new ArrayList<>();


        public void registerSatellite(Satellite satellite) {
            if (satellite == null) {
                throw new NullPointerException("Parameter must not be null!");}
            satellites.add(satellite);
        }

        public Satellite findSatelliteByRegisterIdent (String registerIdent) {
            if (registerIdent == null) {
                throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);}

                for (Satellite findSatellite : satellites) {
                    if (findSatellite.getRegisterIdent().equals(registerIdent)) {
                        return findSatellite;
                    }
                }


            throw new IllegalArgumentException("Satellite with the given registration cannot be found!" + registerIdent);
        }

        private boolean isEmpty(String str){
            boolean reply;
            if (str.isEmpty() || str.isBlank() || str == "") {
                reply = true;
            }
            else {reply = false;}
            return reply;
        }

        @Override
        public String toString() {
            return ""+satellites;
        }
    }

