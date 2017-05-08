

package com.mymarvel.core.data;

import android.support.annotation.StringDef;
import android.util.Log;

import com.mymarvel.core.BuildConfig;
import com.mymarvel.core.data.model.CharacterMarvel;
import com.mymarvel.core.data.model.Comic;
import com.mymarvel.core.data.model.DataWrapper;
import com.mymarvel.core.data.network.MarvelService;
import com.mymarvel.core.data.network.MarvelServiceFactory;
import com.mymarvel.core.data.network.RemoteCallback;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import retrofit2.Call;

/**
 * Api abstraction
 */
public class DataManager {

    private static DataManager sInstance;

    private final MarvelService mMarvelService;

    public static DataManager getInstance() {
        if (sInstance == null) {
            sInstance = new DataManager();
        }
        return sInstance;
    }

    private DataManager() {
        mMarvelService = MarvelServiceFactory.makeMarvelService();
    }

    public void getCharactersList(int offSet, int limit, String searchQuery,
                                  RemoteCallback<DataWrapper<List<CharacterMarvel>>> listener) {
        long timeStamp = System.currentTimeMillis();
        mMarvelService.getCharacters(BuildConfig.PUBLIC_KEY,
                buildMd5AuthParameter(timeStamp), timeStamp, offSet, limit, searchQuery)
                .enqueue(listener);
    }

    public void getCharacter(long characterId, RemoteCallback<DataWrapper<List<CharacterMarvel>>> listener) {
        long timeStamp = System.currentTimeMillis();
        mMarvelService.getCharacter(characterId, BuildConfig.PUBLIC_KEY,
                buildMd5AuthParameter(timeStamp), timeStamp)
                .enqueue(listener);
    }


    private static final String COMIC_TYPE_COMICS = "comics";
    private static final String COMIC_TYPE_SERIES = "series";
    private static final String COMIC_TYPE_STORIES = "stories";
    private static final String COMIC_TYPE_EVENTS = "events";


    @StringDef({COMIC_TYPE_COMICS, COMIC_TYPE_SERIES, COMIC_TYPE_STORIES, COMIC_TYPE_EVENTS})
    @Retention(RetentionPolicy.SOURCE)
    private @interface Type {
    }

    public void getComics(long characterId, Integer offset, Integer limit, RemoteCallback<DataWrapper<List<Comic>>> listener) {
        getComicListByType(characterId, COMIC_TYPE_COMICS, offset, limit).enqueue(listener);
    }

    public void getSeries(long characterId, Integer offset, Integer limit, RemoteCallback<DataWrapper<List<Comic>>> listener) {
        getComicListByType(characterId, COMIC_TYPE_SERIES, offset, limit).enqueue(listener);
    }

    public void getStories(long characterId, Integer offset, Integer limit, RemoteCallback<DataWrapper<List<Comic>>> listener) {
        getComicListByType(characterId, COMIC_TYPE_STORIES, offset, limit).enqueue(listener);
    }

    public void getEvents(long characterId, Integer offset, Integer limit, RemoteCallback<DataWrapper<List<Comic>>> listener) {
        getComicListByType(characterId, COMIC_TYPE_EVENTS, offset, limit).enqueue(listener);
    }

    /**
     * Base request to prevent code duplication
     *
     * @param id        {@link CharacterMarvel} Id
     * @param comicType Which {@link .Type} list should be requested
     */
    private Call<DataWrapper<List<Comic>>> getComicListByType(long id, @Type String comicType,
                                                              Integer offset, Integer limit) {
        long timeStamp = System.currentTimeMillis();
        return mMarvelService.getCharacterComics(id, comicType, offset, limit, BuildConfig.PUBLIC_KEY,
                buildMd5AuthParameter(timeStamp), timeStamp);
    }

    /**
     * Builds the required API "hash" parameter (timeStamp + privateKey + publicKey)
     *
     * @param timeStamp Current timeStamp
     * @return MD5 hash string
     */
    private static String buildMd5AuthParameter(long timeStamp) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest((timeStamp + BuildConfig.PRIVATE_KEY
                    + BuildConfig.PUBLIC_KEY).getBytes());
            BigInteger number = new BigInteger(1, messageDigest);

            String md5 = number.toString(16);
            while (md5.length() < 32) {
                md5 = 0 + md5;
            }
            return md5;

        } catch (NoSuchAlgorithmException e) {
            Log.e("DataManager", "Error hashing required parameters: " + e.getMessage());
            return "";
        }
    }
}