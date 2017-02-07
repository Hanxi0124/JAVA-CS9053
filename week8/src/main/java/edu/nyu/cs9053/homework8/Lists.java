package edu.nyu.cs9053.homework8;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Lists {

    public static <T>List<T> reverse(List<T> list) {
    	List<T> returnListLinked=new LinkedList<T>(list);
        List<T> returnListArray=new ArrayList<T>(list);
        if(list.size()==0){
            System.out.println("The list is empty");
            return null;
        }

        if(list instanceof LinkedList){
          Collections.reverse(returnListLinked);
        }
        else {
          Collections.reverse(returnListArray);
        }
        if(list instanceof LinkedList){
          return returnListLinked;
        }
        else {
          return returnListArray;
        }
    }
}
