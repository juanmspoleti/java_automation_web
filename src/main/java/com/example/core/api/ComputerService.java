package com.example.core.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Implementations for the Computer database endpoints
 */
public interface ComputerService {
    @POST("computers/{id}/delete")
    Call<ResponseBody> deleteComputer(@Path("id") String computerId);

    @FormUrlEncoded
    @POST("computers")
    Call<ResponseBody> createComputer(@Field("name") String name, @Field("introduced") String introducedDate, @Field("discontinued") String discontinuedDate, @Field("company") String company);

}
