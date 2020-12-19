package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{
    private List<String> composer =  new ArrayList<>();
    private final int length;
    private List<String> performers = new ArrayList<>();
    private final String title;
    static int fullLenght;
    private List<String> contributors = new ArrayList<>();

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers,new ArrayList<>());
          }

    public AudioFeatures(String title, int length, List<String> performers,  List<String> composer) {
        if (!Validators.isEmpty(composer)){this.composer = composer;}
        for (String str : composer){
            contributors.add(str);
        }
        for (String str : performers){
            contributors.add(str);
        }
        if (Validators.isBlank(title)){throw new IllegalArgumentException("");}
        else{this.title = title;}
        if (length < 1){throw new IllegalArgumentException("");}
        else{this.length = length;
        this.fullLenght = this.fullLenght + length;}
    }

    public List<String> getContributors(){
        return this.contributors;
    }

    public int getLength(){
        return this.length;
    }

    public String getTitle(){
        return this.title;
    }
}
