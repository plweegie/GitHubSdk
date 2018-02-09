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

package com.meisolsson.githubsdk.service.organizations;

import com.meisolsson.githubsdk.model.Membership;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Repository;
import com.meisolsson.githubsdk.model.Team;
import com.meisolsson.githubsdk.model.User;
import com.meisolsson.githubsdk.model.request.organization.CreateTeam;
import com.meisolsson.githubsdk.model.request.organization.CreateTeamMembership;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OrganizationTeamService {

    @GET("orgs/{org}/teams")
    Single<Response<Page<Team>>> getOrganizationTeams(@Path("org") String org, @Query("page") long page);

    @GET("teams/{id}")
    Single<Response<Team>> getTeam(@Path("id") long id);

    @POST("orgs/{org}/teams")
	Single<Response<Team>> createTeam(@Path("org") String org, @Body CreateTeam body);

    @PATCH("teams/{id}")
	Single<Response<Team>> editTeam(@Path("id") long id, @Body CreateTeam body);

    @DELETE("teams/{id}")
	Single<Response<Void>> deleteTeam(@Path("id") long id);

    @GET("teams/{id}/members")
	Single<Response<Page<User>>> getTeamMembers(@Path("id") long id, @Query("page") long page);

    @GET("teams/{id}/memberships/{username}")
	Single<Response<Membership>> getTeamMembership(@Path("id") long id, @Path("username") String username);

    @PUT("teams/{id}/memberships/{username}")
	Single<Response<Membership>> createTeamMembership(@Path("id") long id, @Path("username") String username, @Body CreateTeamMembership body);

    @DELETE("teams/{id}/memberships/{username}")
	Single<Response<Void>> deleteTeamMembership(@Path("id") long id, @Path("username") String username);

    @GET("teams/{id}/repos")
	Single<Response<Page<Repository>>> getTeamRepositories(@Path("id") long id, @Query("page") long page);

    @GET("teams/{id}/repos/{owner}/{repo}")
	Single<Response<Void>> isTeamManagingRepository(@Path("id") long id, @Path("owner") String owner, @Path("repo") String repo);

    @Headers("Content-Length: 0")
    @PUT("teams/{id}/repos/{org}/{repo}")
	Single<Response<Void>> changeTeamRepository(@Path("id") long id, @Path("org") String org, @Path("repo") String repo);

    @DELETE("teams/{id}/repos/{owner}/{repo}")
	Single<Response<Void>> deleteTeamRepository(@Path("id") long id, @Path("owner") String owner, @Path("repo") String repo);

    @GET("/user/teams")
	Single<Response<Page<Team>>> getTeams(@Query("page") long page);
}
