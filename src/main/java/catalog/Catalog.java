package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int i) {
        if (i < 1){throw new IllegalArgumentException("Page number must be positive");}
        int results = 0;
        int div =0;
        for (CatalogItem item : catalogItems) {
            for (Feature feature : item.getFeatures()) {
                if (feature.getClass() == PrintedFeatures.class) {
                    if (((PrintedFeatures) feature).getNumberOfPages() > i){
                        results += ((PrintedFeatures) feature).getNumberOfPages();
                        div ++;
                    }
                }
            }
        }
        if (div==0){throw new IllegalArgumentException("No page");}
        return results/div;
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
        /*for (CatalogItem item : catalogItems) {
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
        } */
        for (CatalogItem item : catalogItems) {
        if (item.getTitles().contains(searchCriteria.getTitle()) || item.getContributors().contains(searchCriteria.getContributor())){
            results.add(item);
        }
        }
        return results;
    }

    public int getAllPageNumber() {
        int results = 0;
        for (CatalogItem item : catalogItems) {
            for (Feature feature : item.getFeatures()) {
                if (feature.getClass() == PrintedFeatures.class) {
                    results += ((PrintedFeatures) feature).getNumberOfPages();
                }
            }
        }return results;
        //return PrintedFeatures.allPageNumber;
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
        int results = 0;
        for (CatalogItem item : catalogItems) {
            for (Feature feature : item.getFeatures()) {
                if (feature.getClass() == AudioFeatures.class) {
                    results += ((AudioFeatures) feature).getLength();
                }
            }
        }return results;
        //return AudioFeatures.fullLenght;
    }

}

