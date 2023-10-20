/*
 * Copyright (C) 2023 Universal Media Server
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.universalmediaserver.tmdbapi.schema.media;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.universalmediaserver.tmdbapi.schema.movie.MovieJobCreditTypedSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieRoleCreditTypedSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieRoleTypedSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieTypedSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonShortTypedSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonTypedSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvJobCreditTypedSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvPlainSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvRoleCreditTypedSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvTypedSchema;
import java.lang.reflect.Type;

/**
 *
 * @author SurfaceS
 */
public class MediaTypeInterfaceDeserializer implements JsonDeserializer<MediaTypeInterface> {

	private static final String MEDIA_TYPE = "media_type";

	@Override
	public MediaTypeInterface deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		if (json.isJsonObject()) {
			JsonObject media = json.getAsJsonObject();
			if (media.has(MEDIA_TYPE)) {
				String mediaType = media.get(MEDIA_TYPE).getAsString();
				switch (mediaType) {
					case "movie" -> {
						return deserializeMovie(json, media, context);
					}
					case "person" -> {
						return deserializePerson(json, media, context);
					}
					case "tv" -> {
						return deserializeTv(json, media, context);
					}
					default ->
						throw new JsonParseException("Unknown media type " + mediaType);
				}
			}
		}
		throw new JsonParseException("Wrong media");
	}

	private MediaTypeInterface deserializeMovie(JsonElement json, JsonObject media, JsonDeserializationContext context) throws JsonParseException {
		if (media.has("character")) {
			if (media.has("credit_id")) {
				return context.deserialize(json, MovieRoleCreditTypedSchema.class);
			}
			return context.deserialize(json, MovieRoleTypedSchema.class);
		}
		if (media.has("job") && media.has("credit_id")) {
			return context.deserialize(json, MovieJobCreditTypedSchema.class);
		}
		return context.deserialize(json, MovieTypedSchema.class);
	}

	private MediaTypeInterface deserializePerson(JsonElement json, JsonObject media, JsonDeserializationContext context) throws JsonParseException {
		if (media.has("known_for")) {
			return context.deserialize(json, PersonTypedSchema.class);
		}
		return context.deserialize(json, PersonShortTypedSchema.class);
	}

	private MediaTypeInterface deserializeTv(JsonElement json, JsonObject media, JsonDeserializationContext context) throws JsonParseException {
		if (media.has("character") && media.has("credit_id")) {
			return context.deserialize(json, TvRoleCreditTypedSchema.class);
		}
		if (media.has("job") && media.has("credit_id")) {
			return context.deserialize(json, TvJobCreditTypedSchema.class);
		}
		if (media.has("episodes")) {
			return context.deserialize(json, TvPlainSchema.class);
		}
		return context.deserialize(json, TvTypedSchema.class);
	}

}
