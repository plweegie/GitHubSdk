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

package com.meisolsson.githubsdk.model.request;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class RequestToken implements Parcelable {

    @Json(name = "client_id")
    @NonNull
    public abstract String clientId();

    @Json(name = "client_secret")
    @NonNull
    public abstract String clientSecret();

    @Json(name = "redirect_uri")
    @Nullable
    public abstract String redirectUri();

    @NonNull
    abstract String code();

    public static JsonAdapter<RequestToken> jsonAdapter(Moshi moshi){
        return new AutoValue_RequestToken.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_RequestToken.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder clientId(@NonNull String clientId);

        public abstract Builder clientSecret(@NonNull String clientSecret);

        public abstract Builder redirectUri(@Nullable String redirectUri);

        public abstract Builder code(@NonNull String code);

        public abstract RequestToken build();
    }
}
