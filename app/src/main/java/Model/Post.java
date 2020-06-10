package Model;

public class Post {
    private String workPlace,workType,workShift,workEmployer,date,time;

    public Post() {
    }

    public Post(String workPlace, String workType, String workShift, String workEmployer, String date, String time) {
        this.workPlace = workPlace;
        this.workType = workType;
        this.workShift = workShift;
        this.workEmployer = workEmployer;
        this.date = date;
        this.time = time;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    public String getWorkEmployer() {
        return workEmployer;
    }

    public void setWorkEmployer(String workEmployer) {
        this.workEmployer = workEmployer;
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
