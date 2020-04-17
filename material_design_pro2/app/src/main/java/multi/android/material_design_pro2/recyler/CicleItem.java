package multi.android.material_design_pro2.recyler;



public class CicleItem {
    int image;

    public CicleItem(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "CicleItem{" +
                "image=" + image +
                '}';
    }
}
