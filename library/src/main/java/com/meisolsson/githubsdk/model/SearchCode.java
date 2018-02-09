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

package com.meisolsson.githubsdk.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class SearchCode implements Parcelable {

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String path();

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract String url();

    @Nullable
    public abstract Repository repository();

    @Nullable
    public abstract Double score();

    @Json(name = "text_matches")
    @Nullable
    public abstract List<TextMatch> textMatches();

    public static JsonAdapter<SearchCode> jsonAdapter(Moshi moshi) {
        return new AutoValue_SearchCode.MoshiJsonAdapter(moshi);
    }
}
