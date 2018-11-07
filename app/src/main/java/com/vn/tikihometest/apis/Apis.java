package com.vn.tikihometest.apis;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * The class is responsible to list all api that will be used in the app.
 */
public interface Apis {

    /**
     * Gets the list of keyword names.
     *
     * @return the list of keyword names emitted by the Observable
     */
    @GET("talenguyen/38b790795722e7d7b1b5db051c5786e5/raw/63380022f5f0c9a100f51a1e30887ca494c3326e/keywords.json")
    Observable<List<String>> getKeywordNames();

}
