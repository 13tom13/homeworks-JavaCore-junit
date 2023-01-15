package phone;

public class Contact {

    protected String name;

    protected String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Contact o = (Contact) obj;
        return phoneNumber.equals(o.phoneNumber) && name.equals(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, phoneNumber);
    }
}