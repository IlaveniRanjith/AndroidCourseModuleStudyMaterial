package com.abhishek.mycontactlistclientapp;

import android.provider.BaseColumns;

public class Contract {
    private Contract() {
    }

    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "contacts";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";
    }
}
