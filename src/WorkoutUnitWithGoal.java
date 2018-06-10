import java.util.Date;

public class WorkoutUnitWithGoal extends WorkoutUnit implements WorkoutGoal
{

    private int     caloryGoal;
    private boolean goalArchieved;

    public WorkoutUnitWithGoal(FitnessDevice fitnessDevice)
    {
        super(fitnessDevice);
    }

    public WorkoutUnitWithGoal( int durationInMinutes, Date startDateTime, FitnessDevice fitnessDevice, int caloryGoal )
    {
        super( durationInMinutes, startDateTime, fitnessDevice );
        this.caloryGoal     = caloryGoal;
        this.goalArchieved  = false;
    }

    @Override
    public boolean archivedGoal( int calories )
    {
        return super.archivedGoal( calories );
    }

    @Override
    public void setCaloryGoal( int caloryGoal )
    {
        this.caloryGoal = caloryGoal >= 0 ? caloryGoal : 0;
    }

    @Override
    public double getGoalArchivedDegree()
    {
        return ( double ) burntCalories() / ( double ) caloryGoal;
    }


    @Override
    public int getCloryGoal()
    {
        return caloryGoal;
    }

    @Override
    public void workout( int minutes )
    {
        super.workout( minutes );
        if( burntCalories() >= caloryGoal && !goalArchieved )
        {
            System.out.println( "Hurray, Wohooo!" );
            goalArchieved = true;
        }
    }
}