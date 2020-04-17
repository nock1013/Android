package multi.android.material_design_pro2.recyler;

public class CardItem {
    int img;
    String txt;

    public CardItem(int img, String txt) {
        this.img = img;
        this.txt = txt;
    }

    public int getImg() {
        return img;
    }

    public String getTxt() {
        return txt;
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "img=" + img +
                ", txt='" + txt + '\'' +
                '}';
    }
}
