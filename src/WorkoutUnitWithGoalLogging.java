import java.util.Date;

public class WorkoutUnitWithGoalLogging extends WorkoutUnitWithGoal
{
    private int counter;

    public WorkoutUnitWithGoalLogging( int durationInMinutes, Date startDateTime, FitnessDevice fitnessDevice, int caloryGoal )
    {
        super(durationInMinutes, startDateTime, fitnessDevice, caloryGoal);
        counter = 0;
    }

    @Override
    public void workout( int minutes )
    {
        super.workout(minutes);
        System.out.println( ++counter );
    }
}