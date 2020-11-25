package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

    public class SpaceAgency {
        List<Satellite> satellites = new ArrayList<>();


        public void registerSatellite(Satellite satellite) {
            satellites.add(satellite);
        }

        public Satellite findSatelliteByRegisterIdent (String registerIdent) {
            for (Satellite findSatellite : satellites) {
                if (findSatellite.getRegisterIdent() == registerIdent) {
                    return findSatellite;
                }
            }
            return new Satellite(new CelestialCoordinates(0,0,0),null);
        }

        private boolean isEmpty(String str){
            boolean reply;
            if (str.isEmpty() || str.isBlank() || str == "") {
                reply = true;
            }
            else {reply = false;}
            return reply;
        }
    }

