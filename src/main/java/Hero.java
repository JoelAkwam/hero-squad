import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String mHeroName;
    private String mHeroPower;
    private int mHeroAge;
    private String mHeroWeakness;
    private static List<Hero> heroList = new ArrayList<>();
    private int mID;

    public Hero(String heroName, String heroPower, int heroAge, String heroWeakness){
        mHeroName = heroName;
        mHeroPower = heroPower;
        mHeroAge = heroAge;
        mHeroWeakness = heroWeakness;
        heroList.add(this);
        mID = heroList.size();
    }

    public String getHeroName() {
        return mHeroName;
    }

    public String getHeroPower(){
        return mHeroPower;
    }

    public int getHeroAge(){
        return mHeroAge;
    }

    public static List<Hero> getHeroList() {
        return heroList;
    }

    public String getHeroWeakness(){
        return mHeroWeakness;
    }

    public static void clear(){
            heroList.clear();
            }

    public int getId() {
        return mID;
    }

    public static Hero find(int id){
        return heroList.get(id - 1);
    }
}
