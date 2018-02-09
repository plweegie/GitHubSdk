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

package com.meisolsson.githubsdk.model.request.repository;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class DeleteContent implements Parcelable {

    @NonNull
    public abstract String path();

    @NonNull
    public abstract String message();

    @NonNull
    public abstract String sha();

    @Nullable
    public abstract String branch();

    public static JsonAdapter<DeleteContent> jsonAdapter(Moshi moshi) {
        return new AutoValue_DeleteContent.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_DeleteContent.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder path(@NonNull String path);

        public abstract Builder message(@NonNull String message);

        public abstract Builder sha(@NonNull String sha);

        public abstract Builder branch(@Nullable String branch);

        public abstract DeleteContent build();
    }
}
