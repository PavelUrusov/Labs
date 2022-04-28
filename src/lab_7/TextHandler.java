package lab_7;

import java.util.*;

public class TextHandler {

    private String _string;
    private ArrayList<CustomSymbol> _customSymbols = new ArrayList<CustomSymbol>();

    public TextHandler(String string){
        if(string == null || string.length() == 0)
            throw new RuntimeException("String is null or empty");
        _string = string;
        _customSymbols = FindUniqueSymbols(string);
        sort();
    }

    public static ArrayList<CustomSymbol> FindUniqueSymbols(String string){
        var bytes = string.toCharArray();
        var list = new ArrayList<Character>();
        var uniqueSymbolsList = new ArrayList<CustomSymbol>();
        for(int i = 0;i < bytes.length;++i){
            list.add(bytes[i]);
        }
        Set<Character> uniqueChars = new HashSet<Character>(list);
        for(var ch:uniqueChars){
            long count = string.chars().filter(x -> x == ch).count();
            uniqueSymbolsList.add(new CustomSymbol(ch,count));
        }
        return uniqueSymbolsList;
    }
    public void PrintUniqueSymbols(int amount){
        if(amount > _customSymbols.size()){
            System.out.println("This number of unique characters in the text is not");
            return;
        }
        for(var x:_customSymbols)
            System.out.println(x);
    }

    private void sort(){
        _customSymbols.sort(Comparator.comparing(x->x.count()));
    }

    public boolean PrintMoreOftenSymbols(int count){
        if(count > _customSymbols.size()){
            System.out.println("Invalid number of characters");
            return false;
        }
        for(int i = _customSymbols.size() - 1; i >-1 && count > 0;--i,--count){
            System.out.println(_customSymbols.get(i));
        }
        return true;
    }

    public String GetSourceString(){
        return _string;
    }
    public int GetCountUniqueSymbols(){
        return _customSymbols.size();
    }
}
