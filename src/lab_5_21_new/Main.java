package lab_5_21_new;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrayList<BasePost> posts = new ArrayList<BasePost>(Arrays.asList(new Teacher("FIO_0"),new Dean("FIO_0")));

        var acdem = new Academy(posts);

    }
}
