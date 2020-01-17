package simple_multi_thread;

/**
 * Created by mrkhatami on 11/5/14.
 */
public class Numbers extends Thread
{
    private Integer[] numbers;
    Numbers()
    {
        numbers = new Integer[]{11,12,5,13,12,16,11,14,5,13,12,12,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16,11,14,5,13,12,16};
    }
    public void run()
    {
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
