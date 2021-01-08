package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {
    private List<Photo> pictureBook = new ArrayList<>();

    public void addPhoto(String... photos) {
        for (String photo : photos) {
            pictureBook.add(new Photo(photo));
        }
    }

    public void starPhoto(String name, Quality quality) {
        boolean found = false;
        for (Photo photo : pictureBook) {
            if (photo.getName().equals(name)) {
                photo.setQuality(quality);
                found = true;
            }
        }
        if (!found){throw new PhotoNotFoundException("Nincs ilyen kép!");}
    }

    public int numberOfStars() {
        int result = 0;
        for (Photo photo : pictureBook) {
            result += photo.getQuality().getNumberOfStar();
        }
        return result;
    }

    public List<Photo> getPhotos() {
        return pictureBook;
    }
}