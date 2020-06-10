package Model;

public class Houses {
    String  id ,houseimage, description,price,place,phone,date,time;

    public Houses() {
    }

    public Houses(String id, String houseimage, String description, String price, String place, String phone, String date, String time) {
        this.id = id;
        this.houseimage = houseimage;
        this.description = description;
        this.price = price;
        this.place = place;
        this.phone = phone;
        this.date = date;
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHouseimage() {
        return houseimage;
    }

    public void setHouseimage(String houseimage) {
        this.houseimage = houseimage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
