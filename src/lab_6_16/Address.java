package lab_6_16;

public class Address {
    private String _street;
    private String _flat;
    private String _house;
    private String _address;
    private Address(){}

    public Address(String street, String house, String flat){
        _street = street;
        _house = house;
        _flat = flat;
        _address =  _house + " "+ _street + " " + "Street, "  + "Apartment #" + flat +".";
    }

    public String GetFlat() {
        return _flat;
    }

    public String GetHouse() {
        return _house;
    }

    public String GetStreet() {
        return _street;
    }

    public String GetAddress(){
        return _address;

    }
    public Address Clone(){
        return new Address(_street,_house,_flat);
    }
}
