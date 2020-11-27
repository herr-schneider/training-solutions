package week05d05;

public class Song {
    private String name;
    private long lengthInSeconds;
    private String artist;

    public Song(String name, long lengthInSeconds, String artist) throws IllegalArgumentException {
        if (isEmpty(name) || isEmpty(artist)) {
            throw new IllegalArgumentException("Empty input String!");
        }
        if (lengthInSeconds<=0) {
            throw new IllegalArgumentException("Invalid length!");
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    private boolean isEmpty (String toBeChecked) {
        if (toBeChecked == null || toBeChecked.isBlank() || toBeChecked.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return artist + ": " + name + " length:" + lengthInSeconds;
    }
}
