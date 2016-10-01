package Containers;

public class Container
{


    // -------------------------------------------------------------------------- ATTRIBUTES

    private double capacity;
    private double volume;

    // -------------------------------------------------------------------------- CONSTRUCTORS

    public Container ()
    {
        // Default constructor here!
    }

    public Container ( double newCapacity )
    {
        if ( newCapacity <= 0 )
        {
            this.setCapacity ( 0 );
        }
        else
        {
            this.setCapacity ( newCapacity );
        }
    }

    // -------------------------------------------------------------------------- METHODS

    public void setCapacity ( double newCapacity )
    {
        this.capacity = newCapacity;
    }

    public double getOriginalCapacity ()
    {
        return this.capacity;
    }

    public void setVolume ( double newVolume )
    {
        this.volume = newVolume;
    }

    public double getVolume ()
    {
        return this.volume;
    }

    public double getCurrentCapacity ()
    {
        return this.getOriginalCapacity() - this.getVolume();
    }

    public void addToTheContainer ( double amount )
    {
        if ( amount >= 0 )
        {
            if ( ( this.getCurrentCapacity() - amount ) < 0 )
            {
                this.setVolume ( this.getVolume() + this.getCurrentCapacity() );
            }
            else
            {
                this.setVolume ( this.getVolume() + amount );
            }
        }
    }

    public double takeFromTheContainer ( double amount )
    {
        double returnValue;

        if ( amount >= 0 )
        {
            if ( amount > this.getVolume() )
            {
                returnValue = this.getVolume();
                this.setVolume ( 0 );
            }
            else
            {
                returnValue = amount;
                this.setVolume ( this.getVolume() - amount );
            }
        }
        else
        {
            returnValue = 0;
        }

        return returnValue;
    }

    public String toString ()
    {
        return ( "volume = " + this.getVolume() + ", free space = " + this.getCurrentCapacity() );
    }

}
