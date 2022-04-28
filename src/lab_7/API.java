package lab_7;

import java.util.Scanner;

public class API {
    private TextHandler _textHandler;
    private Scanner _in = new Scanner(System.in);

    public API(String sourceText){
        _textHandler = new TextHandler(sourceText);

    }

    public void Run(){
        var input = new String();
        System.out.println("Text handler interface. To view commands, type \"help\"");

        while (true){
            input = _in.nextLine();
            switch (input){
                case "help":{
                    System.out.println("find - search for characters in the text");
                    System.out.println("text - printing the source text");
                    System.out.println("exit - close the application");
                    break;
                }
                case "find":{
                    System.out.println("Enter the number of characters to search for(enter all or number): ");
                    var count = _in.nextLine();
                    int  parseCount = 0;
                    try {
                        if(count.equals("all")){
                            parseCount = _textHandler.GetCountUniqueSymbols();
                        }else {parseCount = Integer.parseInt(count);}
                    }
                    catch (NumberFormatException e){
                        System.out.println("Failed: Invalid count format");
                    }
                    if(_textHandler.PrintMoreOftenSymbols(parseCount)){
                        break;
                    }
                    System.out.println("Failed: Id not found");
                    break;
                }
                case "exit":{
                    System.out.println("Completion of the programme...");
                    return;
                }
                case "text":{
                    System.out.println(_textHandler.GetSourceString());
                    break;
                }
                default:{
                    System.out.println("Unknown command type \"help\" to view commands");
                    break;
                }

            }

        }
    }
}
