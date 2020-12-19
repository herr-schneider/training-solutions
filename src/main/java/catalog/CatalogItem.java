package catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogItem {
    private List<Feature> features = new ArrayList<>();
    private int price;
    private String regNumber;

    public CatalogItem(){
        super();
    }
    public CatalogItem(String regNumber, int price, Feature... features) {
        for (Feature f : features){
            this.features.add(f);
        }
        this.price = price;
        this.regNumber = regNumber;
    }
    public int numberOfPagesAtOneItem(){
        int fullLegth = 0;
        for (Feature feature : features) {
            if (feature.getClass() == PrintedFeatures.class) {
                fullLegth += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return fullLegth;
    }
    public boolean hasAudioFeature(){
        for (Feature feature : features) {
            if (feature.getClass() ==AudioFeatures.class) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature(){
        for (Feature feature : features) {
            if (feature.getClass() == PrintedFeatures.class) {
                return true;
            }
        }
        return false;
    }

    public int fullLengthAtOneItem() {
        int fullLegth = 0;
        for (Feature feature : features) {
            if (feature.getClass() == AudioFeatures.class) {
                fullLegth += ((AudioFeatures) feature).getLength();
            }
        }
        return fullLegth;
    }

    public List<String> getContributors() {
        List<String> results = new ArrayList<>();
        for (Feature feature : features) {
            for (String contributor : feature.getContributors()) {
                results.add(contributor);
            }
        }
        return results;
    }

    public List<String> getTitles() {
        List<String> results = new ArrayList<>();
        for (Feature feature : features) {
            results.add(feature.getTitle());
        }
        return results;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public int getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return regNumber;
    }
}
