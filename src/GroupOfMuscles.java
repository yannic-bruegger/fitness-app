import java.util.ArrayList;

public class GroupOfMuscles
{
    private String nameOfGroup;
    private ArrayList< String > muscleList;

    public GroupOfMuscles() {
        this( "", new ArrayList<String>() );
    }

    public GroupOfMuscles(String nameOfGroup, ArrayList<String> muscleList) {
        this.nameOfGroup = nameOfGroup;
        this.muscleList = muscleList;
    }

    public String getNameOfGroup() {
        return nameOfGroup;
    }

    public void setNameOfGroup(String nameOfGroup) {
        this.nameOfGroup = nameOfGroup;
    }

    public ArrayList<String> getMuscleList() {
        return muscleList;
    }

    public void setMuscleList(ArrayList<String> muscleList) {
        this.muscleList = muscleList;
    }

    public boolean isInGroup(String muscleName )
    {
        for( int c = 0; c < this.muscleList.size(); c++ )
        {
            if(muscleList.get(c).equals(muscleName)) return true;
        }
        return false;
    }

    public boolean isInGroup( GroupOfMuscles groupOfMuscles )
    {
        if( groupOfMuscles.muscleList.size() > this.muscleList.size() ) return false;
        boolean match = true;
        for( int c = 0; c < groupOfMuscles.muscleList.size() && match; c++ )
        {
            boolean found = false;
            for( int i = 0; i < this.muscleList.size() && !found; i++ )
            {
                if(groupOfMuscles.muscleList.get(c).equals(this.muscleList.get(i)))
                {
                    found = true;
                }
            }
            match = match && found;
        }
        return match;
    }
}