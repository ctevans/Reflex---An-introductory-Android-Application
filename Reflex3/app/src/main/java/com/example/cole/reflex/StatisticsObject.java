package com.example.cole.reflex;

/**
 * Created by Cole on 2015-09-27.
 * Basically this class is going to be the abstract superclass of the "singleplayerstats" and
 * the "multiplayerstats" classes. This essentially is going to be able to do a few things:
 *
 * #1: Put in statistics. Where the "nanoSecondsValue" is going to be modified using a setter
 * method.
 *
 * #2: Retrieve the statistics. Where the "nanoSecondsValue" value is going to be given to
 * the getter method.
 *
 */
public class StatisticsObject{
    private long nanoSecondsValue;
    private long millisecondsValue = nanoSecondsValue/1000000;


    /** I am having it that it cannot be that you can "set" milliseconds value. This means
     * That this object can ONLY accept nanoseconds!*/
    public long getMillisecondsValue() {
        return millisecondsValue;
    }


    public StatisticsObject(long nanoSecondsValue) {
        this.nanoSecondsValue = nanoSecondsValue;
    }

    public long getNanoSecondsValue() {
        return nanoSecondsValue;
    }

    public void setNanoSecondsValue(long nanoSecondsValue) {
        this.nanoSecondsValue = nanoSecondsValue;
    }

    public StatisticsObject(){}

    @Override
    public String toString() { return Long.toString(this.getNanoSecondsValue()); }
    // This method was obtained from lab #2
    // Why i am using it is because when I was testing I used a listview to view the values
    // of all the objects in the array.... THIS method granted me the benefit of being able
    // to actually get the proper value opposed to some esoteric object reference.

}
