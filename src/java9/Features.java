package java9;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Features {

    public static void main(String [] args) throws IOException {

        List<Integer> list = Collections.emptyList();
        Map<String, String> list1 = Collections.emptyMap();
        ClassLoader.getSystemResources("");
        AtomicReference ar = new AtomicReference();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{}));
    }
}