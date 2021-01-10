package com.tasks.shoocaltask1;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IssueApi {
    @GET("19438/issues")
    Observable<List<UserData>> getData();

}
