package lab5;

public class House {
    private Flat[] Flats;

    private House(){}

    public House(Flat ... Flats){
        this.Flats = Flats;
    }


    public Flat[] getFlats() {
        return Flats;
    }

    public void SortFlats(){
        QuickSortFlats(0, Flats.length - 1);
    }

    private void QuickSortFlats(int leftBorder, int rightBorder){
        var leftMarker = leftBorder;
        var rightMarker = rightBorder;
        var pivot = Flats[(leftMarker + rightMarker) / 2];
        do {
            while (Flats[leftMarker].GetRooms() < pivot.GetRooms()) {
                leftMarker++;
            }
            while (Flats[rightMarker].GetRooms() > pivot.GetRooms()) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    var tmp = Flats[leftMarker];
                    Flats[leftMarker] = Flats[rightMarker];
                    Flats[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            QuickSortFlats(leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            QuickSortFlats(leftBorder, rightMarker);
        }
    }
}
