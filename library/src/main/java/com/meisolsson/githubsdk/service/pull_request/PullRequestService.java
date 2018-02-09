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

package com.meisolsson.githubsdk.service.pull_request;

import com.meisolsson.githubsdk.model.Commit;
import com.meisolsson.githubsdk.model.GitHubFile;
import com.meisolsson.githubsdk.model.MergeResponse;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.PullRequest;
import com.meisolsson.githubsdk.model.request.pull_request.CreatePullRequest;
import com.meisolsson.githubsdk.model.request.pull_request.EditPullRequest;
import com.meisolsson.githubsdk.model.request.pull_request.MergeRequest;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PullRequestService {

    @GET("repos/{owner}/{repo}/pulls")
    Single<Response<Page<PullRequest>>> getPullRequests(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/pulls/{number}")
    Single<Response<PullRequest>> getPullRequest(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

    @POST("repos/{owner}/{repo}/pulls")
	Single<Response<PullRequest>> createPullRequest(@Path("owner") String owner, @Path("repo") String repo, @Body CreatePullRequest body);

    @PATCH("repos/{owner}/{repo}/pulls/{number}")
	Single<Response<PullRequest>> editPullRequest(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body EditPullRequest body);

    @GET("repos/{owner}/{repo}/pulls/{number}/commits")
	Single<Response<Page<Commit>>> getPullRequestCommits(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);

    @GET("repos/{owner}/{repo}/pulls/{number}/files")
	Single<Response<Page<GitHubFile>>> getPullRequestFiles(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);

    @GET("repos/{owner}/{repo}/pulls/{number}/merge")
	Single<Response<Void>> hasPullRequestBeenMerged(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

    @PUT("repos/{owner}/{repo}/pulls/{number}/merge")
	Single<Response<MergeResponse>> mergePullRequest(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body MergeRequest body);


}
