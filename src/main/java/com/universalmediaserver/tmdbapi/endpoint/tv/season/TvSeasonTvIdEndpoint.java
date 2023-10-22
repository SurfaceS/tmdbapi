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
package com.universalmediaserver.tmdbapi.endpoint.tv.season;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.credit.AggregateCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonAccountStatesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonExternalIdsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonImagesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonTranslationsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.video.VideosResponseSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tv Season endpoint. Get the TV season details.
 *
 * @author SurfaceS
 */
public class TvSeasonTvIdEndpoint extends Endpoint {

	private static final String V3_TV_ENDPOINT = V3_ENDPOINT + "tv/";
	private static final String SEASON_ENDPOINT = "/season/";
	private static final String ACCOUNT_STATES_ENDPOINT = "/" + TvSeasonAppendToResponse.ACCOUNT_STATES;
	private static final String AGGREGATE_CREDITS_ENDPOINT = "/" + TvSeasonAppendToResponse.AGGREGATE_CREDITS;
	private static final String CREDITS_ENDPOINT = "/" + TvSeasonAppendToResponse.CREDITS;
	private static final String EXTERNAL_IDS_ENDPOINT = "/" + TvSeasonAppendToResponse.EXTERNAL_IDS;
	private static final String IMAGES_ENDPOINT = "/" + TvSeasonAppendToResponse.IMAGES;
	private static final String TRANSLATIONS_ENDPOINT = "/" + TvSeasonAppendToResponse.TRANSLATIONS;
	private static final String VIDEOS_ENDPOINT = "/" + TvSeasonAppendToResponse.VIDEOS;

	private final long tvId;
	private final long seasonNumber;
	private final List<TvSeasonAppendToResponse> appendToResponse = new ArrayList<>();
	private final List<String> includeImageLanguage = new ArrayList<>();
	private final List<String> includeVideoLanguage = new ArrayList<>();
	private String language;

	public TvSeasonTvIdEndpoint(TMDbClient tmdbClient, long tvId, long seasonNumber) {
		super(tmdbClient);
		this.tvId = tvId;
		this.seasonNumber = seasonNumber;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this endpoint
	 */
	public TvSeasonTvIdEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * getDetails method support a query parameter called append_to_response.
	 * This makes it possible to make sub requests within the same namespace in
	 * a single HTTP request.
	 *
	 * @param values sub requests
	 * @return this endpoint
	 */
	public TvSeasonTvIdEndpoint appendToResponse(TvSeasonAppendToResponse... values) {
		if (values != null) {
			for (TvSeasonAppendToResponse value : values) {
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
	public TvSeasonTvIdEndpoint includeImageLanguage(String... values) {
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
	public TvSeasonTvIdEndpoint includeVideoLanguage(String... values) {
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
	 * Get TV season details by id.
	 *
	 * @return TV season details.
	 */
	public TvSeasonDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber, TvSeasonDetailsSchema.class, query);
	}

	/**
	 * Get your rating for a episode.
	 *
	 * @return TV episode rating.
	 */
	public TvSeasonAccountStatesResponseSchema getAccountStates() {
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + ACCOUNT_STATES_ENDPOINT, TvSeasonAccountStatesResponseSchema.class, null);
	}

	/**
	 * Get the aggregate credits for TV season.
	 *
	 * @return TV season aggregate credits.
	 */
	public AggregateCreditsResponseSchema getAggregateCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + AGGREGATE_CREDITS_ENDPOINT, AggregateCreditsResponseSchema.class, query);
	}

	/**
	 * Get the credits for TV season.
	 *
	 * @return TV season credits.
	 */
	public TvSeasonCreditsResponseSchema getCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + CREDITS_ENDPOINT, TvSeasonCreditsResponseSchema.class, query);
	}

	/**
	 * Get the external ids for a TV season.
	 *
	 * @return TV season external ids.
	 */
	public TvSeasonExternalIdsResponseSchema getExternalIds() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + EXTERNAL_IDS_ENDPOINT, TvSeasonExternalIdsResponseSchema.class, query);
	}

	/**
	 * Get the images that belong to a TV season. Querying images with a
	 * language parameter will filter the results.
	 *
	 * @return TV season images.
	 */
	public TvSeasonImagesResponseSchema getImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + IMAGES_ENDPOINT, TvSeasonImagesResponseSchema.class, query);
	}

	/**
	 * Get the translation data for an episode.
	 *
	 * @return TV season translations.
	 */
	public TvSeasonTranslationsResponseSchema getTranslations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + TRANSLATIONS_ENDPOINT, TvSeasonTranslationsResponseSchema.class, query);
	}

	/**
	 * Get the videos that have been added to a TV season.
	 *
	 * @return TV season videos.
	 */
	public VideosResponseSchema getVideos() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SEASON_ENDPOINT + seasonNumber + VIDEOS_ENDPOINT, VideosResponseSchema.class, query);
	}

}
