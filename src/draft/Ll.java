package draft;

import java.util.LinkedList;

public class Ll {



    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();//Empty constructor
        LinkedList<String> linkedListFromCollection = new LinkedList<>(linkedList);


        linkedList.add("Str1");
        for (String str : linkedList){
            System.out.print(str);
        }

    }

}
