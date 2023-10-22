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
package com.universalmediaserver.tmdbapi.endpoint.tv.episode;

import com.google.gson.JsonObject;
import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.StatusSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeAccountStatesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeExternalIdsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeImagesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeTranslationsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.video.VideosResponseSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tv Episode Endpoint. Get the TV episode details.
 *
 * @author SurfaceS
 */
public class TvEpisodeTvIdEndpoint extends Endpoint {

	private static final String V3_TV_ENDPOINT = V3_ENDPOINT + "tv/";
	private static final String SEASON_ENDPOINT = "/season/";
	private static final String EPISODE_ENDPOINT = "/episode/";
	private static final String ACCOUNT_STATES_ENDPOINT = "/" + TvEpisodeAppendToResponse.ACCOUNT_STATES;
	private static final String CREDITS_ENDPOINT = "/" + TvEpisodeAppendToResponse.CREDITS;
	private static final String EXTERNAL_IDS_ENDPOINT = "/" + TvEpisodeAppendToResponse.EXTERNAL_IDS;
	private static final String IMAGES_ENDPOINT = "/" + TvEpisodeAppendToResponse.IMAGES;
	private static final String RATING_ENDPOINT = "/rating";
	private static final String TRANSLATIONS_ENDPOINT = "/" + TvEpisodeAppendToResponse.TRANSLATIONS;
	private static final String VIDEOS_ENDPOINT = "/" + TvEpisodeAppendToResponse.VIDEOS;

	private final long tvId;
	private final long seasonNumber;
	private final long episodeNumber;
	private final List<TvEpisodeAppendToResponse> appendToResponse = new ArrayList<>();
	private final List<String> includeImageLanguage = new ArrayList<>();
	private final List<String> includeVideoLanguage = new ArrayList<>();
	private String language;

	public TvEpisodeTvIdEndpoint(TMDbClient tmdbClient, long tvId, long seasonNumber, long episodeNumber) {
		super(tmdbClient);
		this.tvId = tvId;
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public TvEpisodeTvIdEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * This makes it possible to make sub requests within the same namespace in
	 * a single HTTP request. Each request will get appended to the response as
	 * a new JSON object.
	 *
	 * @param values sub requests
	 * @return this request
	 */
	public TvEpisodeTvIdEndpoint appendToResponse(TvEpisodeAppendToResponse... values) {
		if (values != null) {
			for (TvEpisodeAppendToResponse value : values) {
				if (!appendToResponse.contains(value)) {
					appendToResponse.add(value);
				}
			}
		}
		return this;
	}

	/**
	 * Include an image fallback language. Especially useful for backdrops.
	 *
	 * @param values fallback languages
	 * @return this request
	 */
	public TvEpisodeTvIdEndpoint includeImageLanguage(String... values) {
		if (values != null) {
			for (String value : values) {
				if (!includeImageLanguage.contains(value)) {
					includeImageLanguage.add(value);
				}
			}
		}
		return this;
	}

	/**
	 * Include a video fallback language.
	 *
	 * @param values fallback languages
	 * @return this request
	 */
	public TvEpisodeTvIdEndpoint includeVideoLanguage(String... values) {
		if (values != null) {
			for (String value : values) {
				if (!includeVideoLanguage.contains(value)) {
					includeVideoLanguage.add(value);
				}
			}
		}
		return this;
	}

	/**
	 * Get TV episode details.
	 *
	 * @return TV episode details.
	 */
	public TvEpisodeDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber, TvEpisodeDetailsSchema.class, query);
	}

	/**
	 * Get your rating for a episode.
	 *
	 * @return TV episode rating.
	 */
	public TvEpisodeAccountStatesResponseSchema getAccountStates() {
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber + ACCOUNT_STATES_ENDPOINT, TvEpisodeAccountStatesResponseSchema.class, null);
	}

	/**
	 * Get the credits (cast, crew and guest stars) for a TV episode.
	 *
	 * @return TV episode credits.
	 */
	public TvEpisodeCreditsResponseSchema getCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber + CREDITS_ENDPOINT, TvEpisodeCreditsResponseSchema.class, query);
	}

	/**
	 * Get the external ids for a TV episode.
	 *
	 * @return TV episode external ids.
	 */
	public TvEpisodeExternalIdsResponseSchema getExternalIds() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber + EXTERNAL_IDS_ENDPOINT, TvEpisodeExternalIdsResponseSchema.class, query);
	}

	/**
	 * Get the images that belong to a TV episode.
	 *
	 * @return TV episode images.
	 */
	public TvEpisodeImagesResponseSchema getImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber + IMAGES_ENDPOINT, TvEpisodeImagesResponseSchema.class, query);
	}

	/**
	 * Get the translation data for an episode.
	 *
	 * @return TV episode translations.
	 */
	public TvEpisodeTranslationsResponseSchema getTranslations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber + TRANSLATIONS_ENDPOINT, TvEpisodeTranslationsResponseSchema.class, query);
	}

	/**
	 * Get the videos that have been added to a TV episode.
	 *
	 * @return TV episode videos.
	 */
	public VideosResponseSchema getVideos() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EPISODE_ENDPOINT + episodeNumber + VIDEOS_ENDPOINT, VideosResponseSchema.class, query);
	}

	/**
	 * Remove your rating for a TV episode. A valid session or guest session ID
	 * is required.
	 *
	 * @return TV season videos.
	 */
	public StatusSchema deleteRating() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryString(query, QUERY_GUEST_SESSION_ID, tmdbClient.getGuestSessionId());
		return tmdbClient.delete(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + RATING_ENDPOINT, StatusSchema.class, query);
	}

	/**
	 * Rate a TV episode. A valid session or guest session ID is required.
	 *
	 * @return TV season videos.
	 */
	public StatusSchema postRating(float value) {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryString(query, QUERY_GUEST_SESSION_ID, tmdbClient.getGuestSessionId());
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("value", value);
		return tmdbClient.post(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + RATING_ENDPOINT, StatusSchema.class, query, jsonObject.toString());
	}

}
