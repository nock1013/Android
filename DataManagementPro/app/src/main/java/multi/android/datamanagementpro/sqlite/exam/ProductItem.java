package multi.android.datamanagementpro.sqlite.exam;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Adapter;

public class ProductItem implements Parcelable {
    String id;
    String name;
    String price;
    String su;
    String totPrice;

    public ProductItem(String id, String name, String totPrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.su = su;
        this.totPrice = totPrice;
    }

    protected ProductItem(Parcel in) {
        id = in.readString();
        name = in.readString();
        totPrice = in.readString();
    }


    public static final Creator<ProductItem> CREATOR = new Creator<ProductItem>() {
        @Override
        public ProductItem createFromParcel(Parcel in) {
            return new ProductItem(in);
        }

        @Override
        public ProductItem[] newArray(int size) {
            return new ProductItem[size];
        }
    };

    @Override
    public String toString() {
        return  id + ", " +
                name + ", " +
                totPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(totPrice);
    }
}
