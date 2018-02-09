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

package com.meisolsson.githubsdk.service.issues;

import com.meisolsson.githubsdk.model.Milestone;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.request.issue.CreateMilestone;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IssueMilestoneService {

    @GET("repos/{owner}/{repo}/milestones")
    Single<Response<Page<Milestone>>> getRepositoryMilestones(@Path("owner") String owner, @Path("repo") String repo,
                                                              @Query("state") String state, @Query("page") long page);

    @GET("repos/{owner}/{repo}/milestones/{number}")
    Single<Response<Milestone>> getMilestone(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

    @POST("repos/{owner}/{repo}/milestones")
    Single<Response<Milestone>> createMilestone(@Path("owner") String owner, @Path("repo") String repo, @Body CreateMilestone body);

    @PATCH("repos/{owner}/{repo}/milestones/{number}")
    Single<Response<Milestone>> editMilestone(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body CreateMilestone body);

    @DELETE("repos/{owner}/{repo}/milestones/{number}")
    Single<Response<Void>> deleteMilestone(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

}
