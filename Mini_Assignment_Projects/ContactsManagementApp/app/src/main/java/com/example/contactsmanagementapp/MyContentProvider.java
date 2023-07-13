package com.example.contactsmanagementapp;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

public class MyContentProvider extends ContentProvider {

    private static final int CONTACTS = 1;
    private static final int CONTACTS_ID = 2;

    private static final String AUTHORITY = "com.example.contactsmanagementapp.provider";
    private static final String BASE_PATH = "contacts";

    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private SQLiteDatabase database;

    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        initializeUriMatching();
        DatabaseHelper helper = new DatabaseHelper(getContext());
        database = helper.getWritableDatabase();
        return true;
    }

    private void initializeUriMatching() {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, CONTACTS);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", CONTACTS_ID);
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case CONTACTS:
                return "vnd.android.cursor.dir/vnd.com.example.contactsmanagementapp.provider.contacts";
            case CONTACTS_ID:
                return "vnd.android.cursor.item/vnd.com.example.contactsmanagementapp.provider.contacts";
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor;

        switch (uriMatcher.match(uri)){
            case CONTACTS:
                cursor = database.query(Contract.Entry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case CONTACTS_ID:
                String id = uri.getLastPathSegment();
                String whereClause = Contract.Entry._ID + " = " + id;
                if (!TextUtils.isEmpty(selection)){
                    whereClause += " AND " + selection;
                }
                cursor = database.query(Contract.Entry.TABLE_NAME, projection, whereClause, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        /*
         * nullColumnHack optional; may be null. SQL doesn't allow inserting a completely empty row
         * without naming at least one column name. If your provided values is empty, no column names
         * are known and an empty row can't be inserted. If not set to null, the nullColumnHack
         * parameter provides the name of nullable column name to explicitly insert a NULL into in
         * the case where your values is empty.
         * */
        long id = database.insert(Contract.Entry.TABLE_NAME, null, values);
        getContext().getContentResolver().notifyChange(uri, null);
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int rowsUpdated;
        switch (uriMatcher.match(uri)){
            case CONTACTS:
                rowsUpdated = database.update(Contract.Entry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case CONTACTS_ID:
                String id = uri.getLastPathSegment();
                String whereClause = Contract.Entry._ID + " = " + id;
                if (!TextUtils.isEmpty(selection))
                {
                    whereClause += " AND " + selection;
                }
                rowsUpdated = database.update(Contract.Entry.TABLE_NAME, values, whereClause, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        if (rowsUpdated > 0)
            getContext().getContentResolver().notifyChange(uri, null);

        return rowsUpdated;

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int rowsDeleted;
        switch (uriMatcher.match(uri)){
            case CONTACTS:
                rowsDeleted = database.delete(Contract.Entry.TABLE_NAME, selection, selectionArgs);
                break;
            case CONTACTS_ID:
                String id = uri.getLastPathSegment();
                String whereClause = Contract.Entry._ID + " = " + id;
                if (!TextUtils.isEmpty(selection))
                {
                    whereClause += " AND " + selection;
                }
                rowsDeleted = database.delete(Contract.Entry.TABLE_NAME, whereClause, selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        if (rowsDeleted > 0)
            getContext().getContentResolver().notifyChange(uri, null);

        return rowsDeleted;
    }
}