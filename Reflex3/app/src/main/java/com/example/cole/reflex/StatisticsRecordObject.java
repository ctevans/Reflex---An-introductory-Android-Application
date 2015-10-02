package com.example.cole.reflex;

import java.util.ArrayList;

/**
 * This object is the heart of the core functionality of this application. If something needs
 * to be recorded it is here.
 * HOWEVER I handed ALL functionality of this object to the DataManager object.
 *
 */
public class StatisticsRecordObject {

    private ArrayList<SingleStatistics> singleStatsArray = new ArrayList<SingleStatistics>();
    private int[] twoPlayerMode = new int[2];
    private int[] threePlayerMode = new int[3];
    private int[] fourPlayerMode =new int[4];

    //There can be, and will ever only be, one of this object.
    public static void createStatisticsObject(){
        //Nothing to be done, just defaulting the constructor.
    }


    /** Now I am going to provide a TON of methods to access these values stored within
     * this object...
     **/

    //Getters....
    public ArrayList<SingleStatistics> getSingleStatsArray() {
        return singleStatsArray;
    }

    public int[] getTwoPlayerMode() {
        return twoPlayerMode;
    }

    public int[] getThreePlayerMode() {
        return threePlayerMode;
    }

    public int[] getFourPlayerMode() {
        return fourPlayerMode;
    }

    //Now with setters.... I greatly desire to have EASIER funtions to use outside of this class
    //So what am I going to do? Deal with all complexity HERE AND NOW.

    public void addSingleStat(SingleStatistics singleStatisticsObject){
        singleStatsArray.add(singleStatisticsObject);
    }

    public void addTwoPlayerPlayerOne(){


    }
}
