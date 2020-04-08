package exam.day03.view.selectview.view.adapter;

public class ActorItem {
    int examImg;
    String name;
    String date;
    String checkTxt;


    public ActorItem(int examImg, String name, String date, String checkTxt) {
        this.examImg = examImg;
        this.name = name;
        this.date = date;
        this.checkTxt = checkTxt;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "examImg=" + examImg +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", checkTxt='" + checkTxt + '\'' +
                '}';
    }
}
