package lab4;

import java.util.Random;

public class mainRunner {
    public static void main(String[] args) {

        char[][] map = null;
        for(int i = 0;i < 100;++i){
            map = CreateAndInitializeMap(5,5,'x','o');
            var result = EntityIsWin(map,'x');

            if(result){
                System.out.println("I=" + i);
                System.out.println(result);
                break;
            }
        }
        DrawMap(map);
    }

    public static char[][] CreateAndInitializeMap(int m,int n,char entity_1,char entity_2){
        if(m < 5 || n < 5)
            throw new RuntimeException("m and n must be more than 5");

        Random rnd = new Random();
        var map = new char[m][n];
        int o = n*n/2;
        int x = (m*n) - o;

        for(int i = 0; i < m;++i){
            for(int j = 0;j < n;++j){
                var rndResult = rnd.nextBoolean();
                if((rndResult == true && x > 0) || o < 1){
                    map[i][j] = entity_1;
                    --x;
                    continue;
                }
                map[i][j] = entity_2;
            }

        }
        return map;
    }

    public static void DrawMap(char[][] map) {
        var rows = map.length;
        var columns = map[0].length;

        for(int i = 0; i < rows;++i){
            for(int j = 0;j < columns;++j){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean EntityIsWin(char[][] map,char entity){
        var result = false;
        result = WinIsDiagonal(map,entity);
        if(result)
            return true;
        result = WinIsVerticalOrHorizontal(map,entity);
        return result;
    }
    private static boolean WinIsDiagonal(char[][] map, char entity){
        var counter_up = 0;
        var counter_down = 0;
        int rows =  map.length;
        int columns = map[0].length;
        
        for(int  i= 0;i < rows;++i){
            for(
                int down_i_tmp = i,up_i_tmp = rows -i - 1, down_j = 0,up_j = columns-1;
                down_i_tmp < rows && down_j < columns && up_i_tmp > -1 && up_j > -1;
                ++down_i_tmp,--up_i_tmp,++down_j,--up_j
                ){
                    if(map[down_i_tmp][down_j] == entity) {
                        counter_up++;
                        if(counter_up > 4)
                            return true;
                    }
                    else{counter_up = 0;}
                    if(map[up_i_tmp][up_j] == entity) {
                        counter_down++;
                        if(counter_down > 4)
                            return true;
                    }
                    else{counter_down=0;}
            }
            counter_up = 0;
            counter_down=0;
        }
        return false;
    }


    private static boolean WinIsVerticalOrHorizontal(char[][] map, char entity){
        var rows= map.length;
        var columns = map[0].length;
        var counter = 0;

        for(int j = 0;j < columns;++j){
            for(int i = 0;i < rows;++i){
                if(map[i][j] == entity) {
                    ++counter;
                    if(counter > 4)
                        return true;
                    continue;
                }
                counter = 0;
            }
            counter = 0;
        }
        for(int i = 0;i < rows;++i){
            for(int j = 0;j < columns;++j){
                if(map[i][j] == entity) {
                    ++counter;
                    if(counter > 4)
                        return true;
                    continue;
                }
                counter = 0;
            }
            counter = 0;
        }
        return false;
    }
}
