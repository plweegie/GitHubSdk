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

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CommentRequest {

    @NonNull
    public abstract String body();

    public static JsonAdapter<CommentRequest> jsonAdapter(Moshi moshi){
        return new AutoValue_CommentRequest.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CommentRequest.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder body(@NonNull String body);

        public abstract CommentRequest build();
    }
}
