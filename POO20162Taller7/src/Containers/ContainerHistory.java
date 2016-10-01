package Containers;

import java.util.*;

public class ContainerHistory
{

    // ---------------------------------------------------------------------------- ATTRIBUTES

    private ArrayList < Double > volumeHistory;

    // ---------------------------------------------------------------------------- CONSTRUCTOR

    public ContainerHistory ()
    {
        // Default constructor here!
        volumeHistory = new ArrayList < Double > ();
    }

    // ---------------------------------------------------------------------------- METHODS

    public void add ( double situation )
    {
        volumeHistory.add ( situation );
    }

    public void reset ()
    {
        this.volumeHistory.clear();
    }

    public double minValue ()
    {
        double minValue;

        if ( !this.volumeHistory.isEmpty() )
        {
            minValue = this.volumeHistory.get ( 0 );
            for ( int i = 1; i < this.volumeHistory.size(); i = i + 1 )
            {
                if ( this.volumeHistory.get ( i ) < this.volumeHistory.get ( i - 1 ) )
                {
                    minValue = this.volumeHistory.get ( i );
                }
            }
        }
        else
        {
            minValue = 0.0;
        }

        return minValue;
    }

    public double maxValue ()
    {
        double maxValue;

        if ( !this.volumeHistory.isEmpty() )
        {
            maxValue = this.volumeHistory.get ( 0 );
            for ( int i = 1; i < this.volumeHistory.size(); i = i + 1 )
            {
                if ( this.volumeHistory.get ( i ) > this.volumeHistory.get ( i - 1 ) )
                {
                    maxValue = this.volumeHistory.get ( i );
                }
            }
        }
        else
        {
            maxValue = 0.0;
        }

        return maxValue;
    }

    public double average ()
    {
        double sum , average;

        sum = 0.0;
        for ( Double capacity : this.volumeHistory )
        {
            sum = sum + capacity;
        }

        average = sum / this.volumeHistory.size();

        return average;
    }

    public double greatestFluctuation ()
    {
        double greatestFluctuation;

        if ( this.volumeHistory.size() > 2 )
        {
            greatestFluctuation = Math.abs ( this.volumeHistory.get ( 0 ) - this.volumeHistory.get ( 1 ) );
            for ( int i = 1; i < this.volumeHistory.size(); i = i + 1 )
            {
                if ( Math.abs ( this.volumeHistory.get ( i ) - this.volumeHistory.get ( i + 1 ) ) > greatestFluctuation )
                {
                    greatestFluctuation = Math.abs ( this.volumeHistory.get ( i ) - this.volumeHistory.get ( i + 1 ) );
                }
                if ( i == this.volumeHistory.size() - 2 ) // So that we won't have any exceptions...
                {
                    break;
                }
            }
        }
        else
        {
            greatestFluctuation = 0.0;
        }

        return greatestFluctuation;
    }

    public double variance ()
    {
        double variance;

        if ( this.volumeHistory.size() > 2 )
        {
            double sum;

            sum = 0;
            for ( Double capacity : this.volumeHistory )
            {
                sum = sum + Math.pow( capacity - this.average() , 2 );
            }

            variance = sum / (this.volumeHistory.size() - 1);
        }
        else
        {
            variance = 0.0;
        }

        return variance;
    }

    public String toString ()
    {
        return this.volumeHistory.toString ();
    }

}
