import java.util.ArrayList;
import java.util.Date;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Started fitness-app" );

        ArrayList<String> li1 = new ArrayList<String>();
        li1.add("Rückenmuskulatur");
        li1.add("Brustmuskulatur");
        li1.add("Bizeps");
        li1.add("Trizeps");

        GroupOfMuscles gom = new GroupOfMuscles( "Oberkörper", li1 );
        GroupOfMuscles gom2 = new GroupOfMuscles( "Oberer Rücken", li1 );

        FitnessDevice f1 = new FitnessDevice( "Device2", DeviceType.CARDIO, gom, 20, 900, false );
        FitnessDevice f2 = new FitnessDevice( "Device3", DeviceType.CARDIO, gom2, 20, 7000, false );

        // Aufgabe 2
        WorkoutUnit basicWorkoutUnit            = new WorkoutUnit( f1 );
        WorkoutUnitWithGoal extendedWorkoutUnit = new WorkoutUnitWithGoal( f2 );
        WorkoutUnitWithGoalLogging superExtendedWorkoutUnit = new WorkoutUnitWithGoalLogging( 60, new Date(), f1, 3000 );

        // Aufgabe 3
        WorkoutProgram program = new WorkoutProgram( 1800 );
        program.addWorkoutUnit( basicWorkoutUnit );
        program.addWorkoutUnit( extendedWorkoutUnit );

        program.setCaloryGoal( 8000 );

        basicWorkoutUnit.workout( 0 );
        extendedWorkoutUnit.workout( 0 );
        superExtendedWorkoutUnit.workout( 30 );
        superExtendedWorkoutUnit.workout( 30 );
        superExtendedWorkoutUnit.workout( 30 );
        superExtendedWorkoutUnit.workout( 30 );
        superExtendedWorkoutUnit.workout( 30 );
        superExtendedWorkoutUnit.workout( 30 );



    }
}