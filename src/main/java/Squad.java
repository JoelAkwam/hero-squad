import java.util.ArrayList;
import java.util.List;

public class Squad{
    private String mName;
    private String mSize;
    private String mPurpose;
    private static List<Squad> instances = new ArrayList<>();
    private int mId;
    private List<Hero> mHeroes;

    public Squad(String name, String size, String purpose){
        mName = name;
        mSize = size;
        mPurpose = purpose;
        instances.add(this);
        mId = instances.size();
        mHeroes = new ArrayList<>();
    }

    public String getName(){
        return mName;
    }

    public String getSize(){
        return mSize;
    }
    public String getPurpose(){
        return mPurpose;
    }
    public static List<Squad> all(){
        return instances;
    }
    public int getId(){
        return mId;
    }
    public static void clear(){
        instances.clear();
    }
    public static Squad find(int id){
        return instances.get(id - 1);
    }
    public void addHero(Hero hero){
        mHeroes.add(hero);
    }

}


