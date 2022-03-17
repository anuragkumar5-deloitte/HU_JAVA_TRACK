package Practise4;
import java.util.*;

public class Collection_Rev {

        public static void main(String[] args)
        {

            List<String> my_list = new ArrayList<String>();

            // Adding elements to the List
            my_list.add("hashedin");
            my_list.add("by");
            my_list.add("Deloitte");
            my_list.add("2022");

            System.out.println("Original List : " + my_list);

            // Using reverse() method to
            Collections.reverse(my_list);

            System.out.println("Modified List: " + my_list);
        }
    }

