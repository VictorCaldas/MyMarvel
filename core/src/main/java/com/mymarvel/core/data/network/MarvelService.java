package com.mymarvel.core.data.network;

import android.support.annotation.Nullable;

import com.mymarvel.core.data.model.CharacterMarvel;
import com.mymarvel.core.data.model.Comic;
import com.mymarvel.core.data.model.DataWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MarvelService {

    /**
     * Retrieve list of characters
     */
    @GET("characters")
    Call<DataWrapper<List<CharacterMarvel>>> getCharacters(
            @Query("apikey") String publicKey,
            @Query("hash") String md5Digest,
            @Query("ts") long timestamp,
            @Nullable @Query("offset") Integer offset,
            @Nullable @Query("limit") Integer limit,
            @Nullable @Query("nameStartsWith") String searchQuery);

    /**
     * Retrieve character by given Id
     */
    @GET("characters/{characterId}")
    Call<DataWrapper<List<CharacterMarvel>>> getCharacter(
            @Path("characterId") long characterId,
            @Query("apikey") String publicKey,
            @Query("hash") String md5Digest,
            @Query("ts") long timestamp);

    /**
     * Retrieve list of comics by character Id
     */
    @GET("characters/{characterId}/{comicType}")
    Call<DataWrapper<List<Comic>>> getCharacterComics(
            @Path("characterId") long characterId,
            @Path("comicType") String comicType,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("apikey") String publicKey,
            @Query("hash") String md5Digest,
            @Query("ts") long timestamp);
}


