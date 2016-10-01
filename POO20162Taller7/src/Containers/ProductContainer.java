package Containers;

public class ProductContainer extends Container
{

    // -------------------------------------------------------------------------- ATTRIBUTES

    private String productName;

    // -------------------------------------------------------------------------- CONSTRUCTORS

    public ProductContainer ()
    {
        // Default constructor here!
    }

    public ProductContainer ( double newCapacity , String newProductName )
    {
        super ( newCapacity );
        this.setProductName ( newProductName );

    }

    public ProductContainer ( double newCapacity , String newProductName , double newVolume )
    {
        this ( newCapacity , newProductName );
        this.setVolume ( newVolume );
    }

    // -------------------------------------------------------------------------- METHODS

    public void setProductName ( String newProductName )
    {
        this.productName = newProductName;
    }

    public String getProductName ()
    {
        return this.productName;
    }

    public String toString ()
    {
        return ( this.getProductName() + ": " + "Volume: " + this.getVolume() + ", free space: " +
                 this.getCurrentCapacity() );

    }

}
