/*
 * Copyright 2015 Henrik Olsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meisolsson.githubsdk.service.repositories;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Status;
import com.meisolsson.githubsdk.model.request.repository.CreateStatus;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryStatusService {

    @POST("repos/{owner}/{repo}/statuses/{sha}")
    Single<Response<Status>> createStatus(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha, @Body CreateStatus request);

    @GET("repos/{owner}/{repo}/commits/{sha}/statuses")
    Single<Response<Page<Status>>> getStatuses(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha, @Query("page") long page);
}
