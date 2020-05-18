package multi.android.material_design_pro2.recycler;
//RecyclerView의 한 항목을 구성하는 데이터를 저장하는 객체
public class CircleItem {
    int img;

    public CircleItem(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "CircleItem{" +
                "img='" + img + '\'' +
                '}';
    }
}
