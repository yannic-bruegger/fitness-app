import java.util.ArrayList;

public class WorkoutProgram implements WorkoutGoal
{
    private ArrayList<WorkoutUnit> workoutUnits;
    private int caloryGoal;

    public WorkoutProgram( int caloryGoal )
    {
        this.caloryGoal = caloryGoal;
        workoutUnits = new ArrayList<WorkoutUnit>();
    }

    public void addWorkoutUnit(WorkoutUnit workoutUnit )
    {
        workoutUnits.add( workoutUnit );
    }

    public WorkoutUnit getMostEffectiveWorkout()
    {
        if( workoutUnits.isEmpty() ) return null;
        WorkoutUnit mostEffectiveWorkoutUnit = workoutUnits.get( 0 );
        for( int c = 1; c < workoutUnits.size(); c++ )
        {
            mostEffectiveWorkoutUnit = mostEffectiveWorkoutUnit.burntCalories() > workoutUnits.get( c ).burntCalories() ? mostEffectiveWorkoutUnit : workoutUnits.get( c );
        }
        return mostEffectiveWorkoutUnit;
    }

    @Override
    public int getCloryGoal()
    {
        return caloryGoal;
    }

    @Override
    public void setCaloryGoal( int caloryGoal )
    {
        this.caloryGoal = caloryGoal >= 0 ? caloryGoal : 0;
    }

    @Override
    public double getGoalArchivedDegree()
    {
        int sumOfBurntCalouries = 0;
        for( int c = 0; c < workoutUnits.size(); c++ )
        {
            sumOfBurntCalouries += workoutUnits.get( c ).burntCalories();
        }
        return ( double )sumOfBurntCalouries / ( double ) caloryGoal;
    }
}