package my.first.customlistviewexample;

public class Contact {
    private int photoID;
    private String name;
    private String phoneNumber;


    public Contact() {
    }

    public Contact(int photoID, String name, String phoneNumber) {
        this.photoID = photoID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //setter method for name
    public void setName(String name){
        this.name = name;
    }

    //getter method for name
    public String getName() {
        return this.name;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
