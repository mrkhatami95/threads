package simple_multi_thread;

/**
 * Created by mrkhatami on 11/5/14.
 */
public class MultiThread
{
    public static void main(String[] args)
    {
        try
        {
            Thread first = new Numbers();
            Thread second = new Names();
            second.start();
            first.start();
        }catch(IllegalThreadStateException e){
            System.err.println("fatal!");
        }
    }
}
