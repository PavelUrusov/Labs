package lab5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        var rnd = new Random();
        var countFlats = rnd.nextInt(5,30);
        var Flats = new Flat[countFlats];
        for(int  i = 0; i < countFlats;++i){
            Flats[i] = new Flat(rnd.nextInt(1,10));
        }
        var house = new House(Flats);
        house.SortFlats();

        var flats = house.getFlats();
        for(int i = 0; i < flats.length;++i){
            System.out.println(flats[i].GetRooms());
        }
    }
}
