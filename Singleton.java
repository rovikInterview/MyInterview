// https://www.geeksforgeeks.org/singleton-design-pattern/

// Method 2: make getInstance() synchronized
// Thread Synchronized Java implementation of 
// singleton design pattern
class Singleton
{
    private static Singleton obj;
 
    private Singleton() {}
 
    // Only one thread can execute this at a time
    public static synchronized Singleton getInstance()
    {
        if (obj==null)
            obj = new Singleton();
        return obj;
    }
}

// Method 4 (Best): Use “Double Checked Locking” 
// Double Checked Locking based Java implementation of
// singleton design pattern
class Singleton
{
    private volatile static Singleton obj;
 // We have declared the obj volatile which ensures that multiple threads offer the obj variable correctly 
 // when it is being initialized to Singleton instance. 
 // This method drastically reduces the overhead of calling the synchronized method every time.
    private Singleton() {}
 
    public static Singleton getInstance()
    {
        if (obj == null)
        {
            // To make thread safe
            synchronized (Singleton.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj==null)
                    obj = new Singleton();
            }
        }
        return obj;
    }
}


// Method 3: Eager Instantiation

// Static initializer based Java implementation of
// singleton design pattern
class Singleton
{
    private static Singleton obj = new Singleton();
 
    private Singleton() {}
 
    public static Singleton getInstance()
    {
        return obj;
    }
}
