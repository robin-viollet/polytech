package ex5;

public class ClockDisplay implements IDisplay {

    private final NumberDisplay hours;
    private final NumberDisplay minutes;
    private String displayString;

    public ClockDisplay(){

        this(0, 0);

    }

    public ClockDisplay(int hours, int minutes){

        this.hours = new NumberDisplay(24);
        this.minutes = new NumberDisplay(60);

        this.hours.setValue(hours);
        this.minutes.setValue(minutes);

    }

    public String getTime(){

        updateDisplay();

        return displayString;

    }

    @Override
    public void updateDisplay(){

        displayString = hours.getDisplayValue() + ':' + minutes.getDisplayValue();

    }

    @Override
    public void setTime(int hour, int minute) throws ClockDisplayException{

        int oldHour = hours.getValue();
        int oldMinute = minutes.getValue();

        this.hours.setValue(hour);
        this.minutes.setValue(minute);

        updateDisplay();

        if (this.hours.getValue() != hour || this.minutes.getValue() != minute){

            this.hours.setValue(oldHour);
            this.minutes.setValue(oldMinute);

            throw new ClockDisplayException("ClockDisplayException error: this time (" + hour + ':' + minute + ") is impossible");

        }
    }

    @Override
    public void timeTick(){

        this.minutes.increment();

        if (this.minutes.getValue() == 0){

            this.hours.increment();

        }
    }
}
