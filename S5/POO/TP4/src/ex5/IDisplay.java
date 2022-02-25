package ex5;

/**
 * This interface must be implemeted to display the time
 * @author fred
 *
 */
interface IDisplay {
    /**
     * Update the internal string that represents the display.
     */
    void updateDisplay();

    /**
     * Set the time of the display to the specified hour and minute.
     */
    void setTime(int hour, int minute) throws ClockDisplayException;

    /**
     * This method should get called once every minute -
     * it makes the clock display go one minute forward.
     */
    void timeTick();

}
