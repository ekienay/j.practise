import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
       FileInputStream fff = new FileInputStream("src/file.csv");
       readFile(fff);

       int[] arr = {
               2,4,7,2,6,9,3,1
       };

       int [] rand = new int[10];
       for (int i = 0; i < rand.length;i++)
       {
           rand[i] = (int) (Math.random() * 30) - 15;
       }

       int sum = 4;
       arrayExample(rand,sum);
    }

    public static void arrayExample(int[] arr, int sum)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if ((arr[i] + arr[j]) == sum)
                {
                    count++;
                }
            }
        }
        System.out.println("Quantity couple in array: " + count);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void readFile(FileInputStream stream)
    {
        try
        {
            int length = stream.available();
            byte[] items = new byte[length];
            stream.read(items);

            String line = new String(items);
            String[] lines = line.split(";");
            Arrays.stream(lines).forEach(System.out::println);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
