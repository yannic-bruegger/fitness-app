public class FitnessDevice
{
    private String deviceName;
    private DeviceType deviceType;
    private GroupOfMuscles groupOfMuscles;
    private int maxMinutesOfTraining;
    private int burntCaloriesEachHour;
    private boolean isElectronicDevice;

    public FitnessDevice()
    {
        this( "Fitness Device", DeviceType.CARDIO, new GroupOfMuscles(), 60, 600, false );
    }

    public FitnessDevice( String deviceName, DeviceType deviceType, GroupOfMuscles groupOfMuscles, int maxMinutesOfTraining, int burntCaloriesEachHour, boolean isElectronicDevice )
    {
        setDeviceName( deviceName );
        setDeviceType( deviceType );
        setGroupOfMuscles( groupOfMuscles );
        setMaxMinutesOfTraining( maxMinutesOfTraining );
        setBurntCaloriesEachHour( burntCaloriesEachHour );
        setIsElectronicDevice( isElectronicDevice );
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName( String deviceName )
    {
        this.deviceName = deviceName;
    }

    public DeviceType getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType( DeviceType deviceType )
    {
        this.deviceType = deviceType;
    }

    public GroupOfMuscles getGroupOfMuscles()
    {
        return groupOfMuscles;
    }

    public void setGroupOfMuscles( GroupOfMuscles groupOfMuscles) {
        this.groupOfMuscles = groupOfMuscles;
    }

    public int getMaxMinutesOfTraining() {
        return maxMinutesOfTraining;
    }

    public void setMaxMinutesOfTraining(int maxMinutesOfTraining) {
        this.maxMinutesOfTraining = maxMinutesOfTraining;
    }

    public void setBurntCaloriesEachHour(int burntCaloriesEachHour)
    {
        this.burntCaloriesEachHour = burntCaloriesEachHour;
    }

    public int getBurntCaloriesEachHour()
    {
        return burntCaloriesEachHour;
    }

    public int getBurntCalories( int minutes )
    {
        return minutes > 0 ? (int)( getBurntCaloriesEachHour() / 60.0 * minutes) : 0;
    }

    public int getBurntCalories( int hours, int minutes )
    {
        return getBurntCalories( hours * 60 + minutes );
    }

    public boolean supportsMuscle( String muscle )
    {
        return groupOfMuscles.isInGroup( muscle );
    }

    public boolean supportsMuscle( GroupOfMuscles groupOfMuscles )
    {
        return this.groupOfMuscles.isInGroup( groupOfMuscles );
    }

    public boolean isElectronicDevice()
    {
        return isElectronicDevice;
    }

    public void setIsElectronicDevice( boolean isElectronicDevice )
    {
        this.isElectronicDevice = isElectronicDevice;
    }

}