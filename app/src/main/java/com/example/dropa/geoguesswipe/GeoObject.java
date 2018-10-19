package com.example.dropa.geoguesswipe;

public class GeoObject {
    private boolean isEurope;
    private int mGeoImageName;

    public GeoObject(boolean isEurope, int mGeoImageName) {
        this.isEurope = isEurope;
        this.mGeoImageName = mGeoImageName;
    }

    public boolean getIsEurope() {
        return isEurope;
    }

    public void setIsEurope(boolean isEurope) {
        this.isEurope = isEurope;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public void setmGeoImageName(int mGeoImageName) {
        this.mGeoImageName = mGeoImageName;
    }

    public static final boolean[] PRE_DEFINED_GEO_IS_IN_EUROPE = {
            true, false, false, true, false, true, true, false
    };

    public static final int[] PRE_DEFINED_GEO_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };
}
