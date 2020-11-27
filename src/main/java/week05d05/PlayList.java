package week05d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayList {
    List<Song> playList = new ArrayList<>();



    public void addSong (String name, long lengthInSeconds, String artist) {
        playList.add(new Song(name, lengthInSeconds, artist));
    }

    public Song getID (int num){
        return playList.get(num);
    }
    public List<Song> findByLengthGreaterThan (double lengthInMinutes){
        if (lengthInMinutes<=0) {
            throw new IllegalArgumentException("Invalid length!");
        }
        List<Song> lengthGraterThan = new ArrayList<>();
        int counter = 0;
        for (Song song : playList) {
          if (song.getLengthInSeconds() > (lengthInMinutes * 60)) {
              lengthGraterThan.add(song);
              counter++;
          }
      }
      if (counter<1) {
          throw new ArrayStoreException("Empty list! No songs on it!");
      }
      return lengthGraterThan;
    }

    public List<Song> getPlayList() { // only for test purpose
        return playList;
    }

}

