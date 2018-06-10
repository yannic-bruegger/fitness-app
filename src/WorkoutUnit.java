import java.util.Date;

public class WorkoutUnit
{
    private int durationInMinutes;
    private Date startDateTime;
    private FitnessDevice fitnessDevice;

    public WorkoutUnit( FitnessDevice fitnessDevice )
    {
        this( 0, new Date(), fitnessDevice );
    }

    public WorkoutUnit( int durationInMinutes, Date startDateTime, FitnessDevice fitnessDevice )
    {
        setDurationInMinutes( durationInMinutes );
        setStartDateTime( startDateTime );
        setFitnessDevice( fitnessDevice );
    }

    public int getDurationInMinutes()
    {
        return durationInMinutes;
    }

    public void setDurationInMinutes( int durationInMinutes )
    {
        this.durationInMinutes = durationInMinutes >= 0 ? durationInMinutes : 0;
    }

    public Date getStartDateTime()
    {
        return startDateTime;
    }

    public void setStartDateTime( Date startDateTime )
    {
        this.startDateTime = startDateTime;
    }

    public FitnessDevice getFitnessDevice()
    {
        return fitnessDevice;
    }

    public void setFitnessDevice( FitnessDevice fitnessDevice )
    {
        this.fitnessDevice = fitnessDevice;
    }

    public boolean archivedGoal( int calories )
    {
        return calories <= fitnessDevice.getBurntCalories( durationInMinutes );
    }

    public int calculateRequiredWorkoutTime( int calories )
    {
        /*TODO:
         * Might change this method due to conversion mistakes. Typecast.
         */
        return (int)(calories / (fitnessDevice.getBurntCaloriesEachHour() / 60.0));
    }

    public void workout()
    {
        workout( 1 );
    }

    public void workout( int minutes )
    {
        setDurationInMinutes( getDurationInMinutes() + minutes );
    }

    public int burntCalories() {
        return fitnessDevice.getBurntCalories(durationInMinutes);
    }
}