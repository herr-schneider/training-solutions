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
        for (Fence fence : Fence.values()) {
            int counter = 0;
            for (Site site : soldSites) {
                if (site.getFence() == fence) {
                    counter++;
                }
            }
            result.add(new FenceCondition(fence, counter));
        }
        return new ArrayList<>(result);
    }

    public List<FenceCondition> statOfFences2() { // nem jo, ha valtozik az enum, nem lesz automatikus
        List<FenceCondition> result = new ArrayList<>();
        int counterPerfect = 0;
        int counterUpdate = 0;
        int counterNoFence = 0;
        for (Site site : soldSites) {
            if (site.getFence() == Fence.PERFECT) {
                counterPerfect++;
            }
            if (site.getFence() == Fence.NEED_UPGRADE) {
                counterUpdate++;
            }
            if (site.getFence() == Fence.NO_FENCE) {
                counterNoFence++;
            }
        }
        result.add(new FenceCondition(Fence.PERFECT, counterPerfect));
        result.add(new FenceCondition(Fence.NEED_UPGRADE, counterUpdate));
        result.add(new FenceCondition(Fence.NO_FENCE, counterNoFence));
        return result;
    }

    public List<Site> getSoldSite() {
        return new ArrayList<>(soldSites);
    }

}
