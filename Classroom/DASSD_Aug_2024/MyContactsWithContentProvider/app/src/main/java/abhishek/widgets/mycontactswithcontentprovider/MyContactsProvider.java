package abhishek.widgets.mycontactswithcontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyContactsProvider extends ContentProvider {

    public static final String AUTHORITY = "abhishek.widgets.mycontactswithcontentprovider.MyContactsProvider";
    public static final String BASE_PATH = MyContactsDBHelper.TABLE_NAME;

    public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH);

    private static final int ALL_CONTACTS = 1;
    private static final int SINGLE_CONTACT = 2;

    private UriMatcher uriMatcher = new UriMatcher(0);  // NO_MATCH



    // URI to fully access the db===>content://<package-name or authority>/table-name
    // URI to access specific record==>content://<package-name or authority>/table-name/7


    private void initUriMatcher() {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, ALL_CONTACTS);  // return 1
        uriMatcher.addURI(AUTHORITY, BASE_PATH+"/#", SINGLE_CONTACT);   // return 2

    }


    SQLiteDatabase sqlDB;



    @Override
    public boolean onCreate() {
        initUriMatcher();

        MyContactsDBHelper myContactsDBHelper = new MyContactsDBHelper(getContext());
        sqlDB = myContactsDBHelper.getWritableDatabase();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selectionCriteria,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder) {

        Cursor cursor = null;

        switch (uriMatcher.match(uri))  {

            case ALL_CONTACTS:
                cursor = sqlDB.query(MyContactsDBHelper.TABLE_NAME,
                        projection,
                        selectionCriteria,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            case SINGLE_CONTACT:

                String ID = uri.getLastPathSegment();
                // WHERE ID=val
                String whereClause = MyContactsDBHelper.COL_ID + "=" + ID;

                cursor = sqlDB.query(MyContactsDBHelper.TABLE_NAME,
                        projection,
                        whereClause,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);

        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        long id = sqlDB.insert(MyContactsDBHelper.TABLE_NAME, null, contentValues);

        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri,
                      @Nullable String selectionCriteria,
                      @Nullable String[] selectionArgs) {

        int deletedRowID = 0;

        int result = uriMatcher.match(uri);

        switch (result) {

            case ALL_CONTACTS:
                deletedRowID = sqlDB.delete(MyContactsDBHelper.TABLE_NAME, selectionCriteria, selectionArgs);
                break;


            case SINGLE_CONTACT:
                String idFromURI = uri.getLastPathSegment();
                //example: WHERE ID=val
                String whereClause = MyContactsDBHelper.COL_ID + " = " + idFromURI;

                deletedRowID = sqlDB.delete(MyContactsDBHelper.TABLE_NAME, whereClause, selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);





        }

        return deletedRowID;
    }

    @Override
    public int update(@NonNull Uri uri,
                      @Nullable ContentValues contentValues,
                      @Nullable String selectionCriteria,
                      @Nullable String[] selectionArgs) {


        int updateRow = 0;

        switch (uriMatcher.match(uri)){

            case ALL_CONTACTS:
                updateRow = sqlDB.update(MyContactsDBHelper.TABLE_NAME, contentValues, selectionCriteria, selectionArgs);
                break;

            case SINGLE_CONTACT:
                String idToUpdate = uri.getLastPathSegment();
                String whereClause = MyContactsDBHelper.COL_ID + " = " + idToUpdate;
                updateRow = sqlDB.update(MyContactsDBHelper.TABLE_NAME, contentValues, whereClause, selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);



        }


        return updateRow;
    }
}
