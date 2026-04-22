package exo1;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class collectionsDemo {
    static void main() {
        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("f");
        //用collections批量加数据
        Collections.addAll(list, "a", "b", "c", "d", "e", "f");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);


    }
}
