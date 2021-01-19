package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private List<Site> soldSites = new ArrayList<>();

    public void sellSite(Site site) {
        soldSites.add(site);

    }

    public int lastSoldSite() {
        Site lastSite = soldSites.get(soldSites.size() - 1);
        int result = 0;
        for (Site site : soldSites) {
            if (lastSite.getEvenOdd() == site.getEvenOdd()) {
                result++;
            }
        }
        return lastSite.getEvenOdd() == 0 ? result * 2 : result * 2 - 1;
    }

    public List<FenceCondition> statOfFences() {
        List<FenceCondition> result = new ArrayList<>();
        int counter = 0;
        for (Fence fence : Fence.values()) {
            for (Site site : soldSites) {
                if (site.getFence() == fence) {
                    counter++;
                }
            }
            result.add(new FenceCondition(fence, counter));
            counter = 0;
        }
        return result;
    }


        public List<Site> getSoldSite () {
            return new ArrayList<>(soldSites);
        }

    }
