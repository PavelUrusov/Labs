package lab_7;

public record CustomSymbol(char symbol,long count) {
    @Override
    public String toString() {
        if(symbol == '\n'){
            return "symbol=" + "enter" + ", count=" + count;
        }
        if(symbol == ' '){
            return "symbol=" + "space" + ", count=" + count;
        }
        return "symbol=" + symbol + ", count=" + count;
    }
}
