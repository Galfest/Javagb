package draft;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Collectionlesson {

    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1,2,3,4,5,6);

        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

}
