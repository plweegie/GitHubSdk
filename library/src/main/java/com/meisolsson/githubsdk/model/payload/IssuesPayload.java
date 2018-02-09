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

package com.meisolsson.githubsdk.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.GitHubStats;
import com.meisolsson.githubsdk.model.Issue;
import com.meisolsson.githubsdk.model.Label;
import com.meisolsson.githubsdk.model.User;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class IssuesPayload extends GitHubPayload<IssuesPayload.Builder> implements Parcelable {
    public enum Action {
        @Json(name = "opened") Opened,
        @Json(name = "closed") Closed,
        @Json(name = "reopened") Reopened
    }

    @Nullable
    public abstract Action action();

    @Nullable
    public abstract Issue issue();

    @Nullable
    public abstract GitHubStats changes();

    @Nullable
    public abstract User assignee();

    @Nullable
    public abstract Label label();

    public abstract Builder toBuilder();

    public static JsonAdapter<IssuesPayload> jsonAdapter(Moshi moshi) {
        return new AutoValue_IssuesPayload.MoshiJsonAdapter(moshi);
    }

    public static IssuesPayload createFromParcel(Parcel in) {
        return AutoValue_IssuesPayload.CREATOR.createFromParcel(in);
    }

    public static Builder builder() {
        return new AutoValue_IssuesPayload.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder extends GitHubPayload.Builder<IssuesPayload, Builder> {
        public abstract Builder action(Action action);

        public abstract Builder issue(Issue issue);

        public abstract Builder changes(GitHubStats changes);

        public abstract Builder assignee(User assignee);

        public abstract Builder label(Label label);

        public abstract IssuesPayload build();
    }
}
