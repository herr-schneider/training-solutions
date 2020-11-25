package week05;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {
    List<Satellite> satellites = new ArrayList<>();


    public void registerSatellite(Satellite satellite) {
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) throws Exception {
        for (Satellite findSatellite : satellites) {
            if (findSatellite.getRegisterIdent() == registerIdent) {
                return findSatellite;
            }
        }
        throw new Exception("There is no satellite!");
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
