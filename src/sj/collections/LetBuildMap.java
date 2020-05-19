package sj.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LetBuildMap {
    public static void main(String [] args){


        Map<String,String> hm = new HashMap<>();
        hm.put("sanjay","kumar");
        hm.put("amjay","kumar");
        hm.put("sjay","kumar");
        hm.put("anjay","kumar");
        hm.put("jay",null);
        hm.put(null,"kumar");
        hm.put(null,null);

        for (String s : hm.keySet()) {
            System.out.println(hm.get(s));
        }

        Map<String, String> map =Collections.synchronizedMap(hm);

        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }

        Hashtable<String, String> ht = new Hashtable<>();
        ht.put("sanjay","kumar");
        ht.put("ajay","kumar");
        ht.put("sjay","kumar");
        ht.put("anjay","kumar");
     //   ht.put("jay",null);
       // ht.put(null,"kumar");
      //  ht.put(null,null);

        for (String s : ht.keySet()) {
            System.out.println(ht.get(s));
        }
    }
}
