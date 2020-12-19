package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int i) {
        return 0.0;
    }

    public void deleteItemByRegistrationNumber(String str) {
        CatalogItem result = new CatalogItem();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber() == str) {
                result = catalogItem;
            }
        }
        deleteItem(result);
    }

    public void deleteItem(CatalogItem deleteCatalogItem) {
        catalogItems.remove(deleteCatalogItem);
    }
    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> results = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            for (String itemTitle : item.getTitles()){
                if (itemTitle == searchCriteria.getTitle()){
                    results.add(item);
                }
            }
            for (String itemContributor : item.getContributors()){
                if (itemContributor == searchCriteria.getContributor()){
                    results.add(item);
                }
            }
        }
        return results;
    }

    public int getAllPageNumber() {
        return PrintedFeatures.allPageNumber;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> results = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            for (Feature feature : item.getFeatures()) {
                if (feature.getClass() == AudioFeatures.class) {
                    results.add(item);
                }
            }
        }
        return results;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> results = new ArrayList<>();
        for (CatalogItem item : catalogItems) {
            for (Feature feature : item.getFeatures()) {
                if (feature.getClass() == PrintedFeatures.class) {
                    results.add(item);
                }
            }
        }
        return results;
    }

    public int getFullLength() {
        return AudioFeatures.fullLenght;
    }

}

