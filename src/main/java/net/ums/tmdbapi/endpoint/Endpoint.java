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
package net.ums.tmdbapi.endpoint;

import net.ums.tmdbapi.TMDbClient;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;

/**
 * Endpoint.
 *
 * @author SurfaceS
 */
public class Endpoint {

	protected static final String V3_ENDPOINT = "3/";
	protected static final String V4_ENDPOINT = "4/";

	protected static final String QUERY_ACCESS_TOKEN = "access_token";
	protected static final String QUERY_APPEND_TO_RESPONSE = "append_to_response";
	protected static final String QUERY_COUNTRY = "country";
	protected static final String QUERY_END_DATE = "end_date";
	protected static final String QUERY_EXTERNAL_SOURCE = "external_source";
	protected static final String QUERY_FIRST_AIR_DATE_YEAR = "first_air_date_year";
	protected static final String QUERY_GUEST_SESSION_ID = "guest_session_id";
	protected static final String QUERY_INCLUDE_ADULT = "include_adult";
	protected static final String QUERY_INCLUDE_IMAGE_LANGUAGE = "include_image_language";
	protected static final String QUERY_INCLUDE_VIDEO_LANGUAGE = "include_video_language";
	protected static final String QUERY_LANGUAGE = "language";
	protected static final String QUERY_PAGE = "page";
	protected static final String QUERY_PRIMARY_RELEASE_YEAR = "primary_release_year";
	protected static final String QUERY_QUERY = "query";
	protected static final String QUERY_REGION = "region";
	protected static final String QUERY_SESSION_ID = "session_id";
	protected static final String QUERY_SORT_BY = "sort_by";
	protected static final String QUERY_START_DATE = "start_date";
	protected static final String QUERY_WATCH_REGION = "watch_region";
	protected static final String QUERY_YEAR = "year";

	protected Endpoint(TMDbClient tmdbClient) {
		this.tmdbClient = tmdbClient;
	}

	protected final TMDbClient tmdbClient;

	protected static void addQueryBoolean(Map<String, String> query, String parameter, boolean value, boolean defaultValue) {
		if (value != defaultValue) {
			query.put(parameter, String.valueOf(value));
		}
	}

	protected static void addQueryEnums(Map<String, String> query, String parameter, List<? extends Enum> values) {
		if (values != null && !values.isEmpty()) {
			StringBuilder valueBuilder = new StringBuilder();
			for (Object value : values) {
				if (!valueBuilder.isEmpty()) {
					valueBuilder.append(",");
				}
				valueBuilder.append(value.toString());
			}
			query.put(parameter, valueBuilder.toString());
		}
	}

	protected static void addQueryNumber(Map<String, String> query, String parameter, long value) {
		if (value > 0) {
			query.put(parameter, Long.toString(value));
		}
	}

	protected static void addQueryString(Map<String, String> query, String parameter, String value) {
		addQueryString(query, parameter, value, null);
	}

	protected static void addQueryString(Map<String, String> query, String parameter, String value, String defaultValue) {
		if (value != null) {
			query.put(parameter, value);
		} else if (defaultValue != null) {
			query.put(parameter, defaultValue);
		}
	}

	protected static void addQueryStrings(Map<String, String> query, String parameter, List<String> values) {
		if (values != null && !values.isEmpty()) {
			StringBuilder valueBuilder = new StringBuilder();
			for (String imageLanguage : values) {
				if (!valueBuilder.isEmpty()) {
					valueBuilder.append(",");
				}
				valueBuilder.append(imageLanguage);
			}
			query.put(parameter, valueBuilder.toString());
		}
	}

	protected static void addPostString(JsonObject postObject, String parameter, String value) {
		addPostString(postObject, parameter, value, null);
	}

	protected static void addPostString(JsonObject postObject, String parameter, String value, String defaultValue) {
		if (value != null) {
			postObject.addProperty(parameter, value);
		} else if (defaultValue != null) {
			postObject.addProperty(parameter, defaultValue);
		}
	}

	protected static void addPostBoolean(JsonObject postObject, String parameter, Boolean value) {
		addPostBoolean(postObject, parameter, value, null);
	}

	protected static void addPostBoolean(JsonObject postObject, String parameter, Boolean value, Boolean defaultValue) {
		if (value != null && (defaultValue == null || !value.equals(defaultValue))) {
			postObject.addProperty(parameter, value);
		}
	}

}
