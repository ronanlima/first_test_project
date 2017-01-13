package br.home.myfirsttestproject.network.type;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

/**
 * Created by Ronan.lima on 13/01/17.
 */

public class FullName implements Parcelable {

    @Expose private String first;
    @Expose private String last;
    @Expose private String title;

    public FullName(){}

    protected FullName(Parcel in) {
        this.first = in.readString();
        this.last = in.readString();
        this.title = in.readString();
    }

    public String first() {
        return first.substring(0, 1).toUpperCase() + first.substring(1);
    }

    public String last() {
        return last.substring(0, 1).toUpperCase() + last.substring(1);
    }

    public String title() {
        return title.substring(0, 1).toUpperCase() + title.substring(1);
    }

    public static final Creator<FullName> CREATOR = new Creator<FullName>() {
        @Override
        public FullName createFromParcel(Parcel parcel) {
            return new FullName(parcel);
        }

        @Override
        public FullName[] newArray(int size) {
            return new FullName[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.first);
        dest.writeString(this.last);
        dest.writeString(this.title);
    }
}
