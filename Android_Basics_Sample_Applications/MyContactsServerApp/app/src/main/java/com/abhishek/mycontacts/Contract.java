package com.abhishek.mycontacts;

import android.provider.BaseColumns;

public class Contract {
    private Contract() {
        //empty constructor to prevent it from being accidentially initialized
    }

    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_EMAIL = "email";
    }

}
