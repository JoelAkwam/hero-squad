import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String mHeroName;
    private String mAbility;
    private int mAge;
    private String mWeakness;
    private static List<Hero> heroList = new ArrayList<>();
    private int mID;

    public Hero(String heroName, String ability, int age, String weakness){
        mHeroName = heroName;
        mAbility = ability;
        mAge = age;
        mWeakness = weakness;
        heroList.add(this);
        mID = heroList.size();
    }

    public String getHeroName() {
        return mHeroName;
    }

    public String getHeroPower(){
        return mAbility;
    }

    public int getHeroAge(){
        return mAge;
    }

    public static List<Hero> getHeroList() {
        return heroList;
    }

    public String getHeroWeakness(){
        return mWeakness;
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
