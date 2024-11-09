package my.first.customlistviewtake2;

public class MyContact {

    int photoID;
    String name;
    String phoneNum;

    public MyContact(int photoID, String name, String phoneNum) {
        this.photoID = photoID;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public MyContact() {
    }


    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
