package Containers;

public class ProductContainerRecorder extends ProductContainer
{

    // ---------------------------------------------------------------------------------- ATTRIBUTES

    private ContainerHistory thisContainerHistory;

    // ---------------------------------------------------------------------------------- CONSTRUCTORS

    public ProductContainerRecorder ()
    {
        // Default constructor here!
    }

    public ProductContainerRecorder ( double newCapacity , String newProductName, double newVolume )
    {
        super ( newCapacity , newProductName , newVolume );
        thisContainerHistory = new ContainerHistory ();
        this.thisContainerHistory.add ( newVolume ) ;
    }

    // --------------------------------------------------------------------------------- METHODS

    public String history ()
    {
        return this.thisContainerHistory.toString();
    }

    public void addToTheContainer ( double amount )
    {
        super.addToTheContainer ( amount );
        this.thisContainerHistory.add ( this.getVolume() );
    }

    public double takeFromTheContainer ( double amount )
    {
        double returnValue;

        returnValue = super.takeFromTheContainer( amount );
        this.thisContainerHistory.add ( this.getVolume() );

        return returnValue;
    }

    public void printAnalysis ( )
    {
        System.out.println ( "Product: " + this.getProductName() );
        System.out.println ( "History: " + this.thisContainerHistory );
        System.out.println ( "Greatest product amount: " + this.thisContainerHistory.maxValue() );
        System.out.println ( "Smallest product amount: " + this.thisContainerHistory.minValue() );
        System.out.println ( "Average: " + this.thisContainerHistory.average() );
        System.out.println ( "Greatest change: " + this.thisContainerHistory.greatestFluctuation() );
        System.out.println ( "Variance: " + this.thisContainerHistory.variance() );
    }
}
