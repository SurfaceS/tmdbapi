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
package net.ums.tmdbapi.endpoint.tv;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.StatusSchema;
import net.ums.tmdbapi.schema.account.AccountStatesResponseSchema;
import net.ums.tmdbapi.schema.change.ChangesSchema;
import net.ums.tmdbapi.schema.credit.AggregateCreditsResponseSchema;
import net.ums.tmdbapi.schema.credit.MediaCreditsResponseSchema;
import net.ums.tmdbapi.schema.image.ImagesResponseSchema;
import net.ums.tmdbapi.schema.reviews.ReviewsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvAlternativeTitlesResponseSchema;
import net.ums.tmdbapi.schema.tv.TvContentRatingsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvDetailsSchema;
import net.ums.tmdbapi.schema.tv.TvEpisodeGroupsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvExternalIdsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvKeywordsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvScreenedTheatricallyResponseSchema;
import net.ums.tmdbapi.schema.tv.TvSimpleResultsSchema;
import net.ums.tmdbapi.schema.tv.TvTranslationsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvTypedResultsSchema;
import net.ums.tmdbapi.schema.video.VideosResponseSchema;
import net.ums.tmdbapi.schema.watchproviders.WatchProvidersResponseSchema;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tv Endpoint. Get the primary TV show details.
 *
 * @author SurfaceS
 */
public class TvIdEndpoint extends Endpoint {

	private static final String V3_TV_ENDPOINT = V3_ENDPOINT + "tv/";
	private static final String ACCOUNT_STATES_ENDPOINT = "/" + TvIdAppendToResponse.ACCOUNT_STATES;
	private static final String AGGREGATE_CREDITS_ENDPOINT = "/" + TvIdAppendToResponse.AGGREGATE_CREDITS;
	private static final String ALTERNATIVE_TITLES_ENDPOINT = "/" + TvIdAppendToResponse.ALTERNATIVE_TITLES;
	private static final String CHANGES_ENDPOINT = "/" + TvIdAppendToResponse.CHANGES;
	private static final String CONTENT_RATINGS_ENDPOINT = "/" + TvIdAppendToResponse.CONTENT_RATINGS;
	private static final String CREDITS_ENDPOINT = "/" + TvIdAppendToResponse.CREDITS;
	private static final String EPISODE_GROUPS_ENDPOINT = "/" + TvIdAppendToResponse.EPISODE_GROUPS;
	private static final String EXTERNAL_IDS_ENDPOINT = "/" + TvIdAppendToResponse.EXTERNAL_IDS;
	private static final String IMAGES_ENDPOINT = "/" + TvIdAppendToResponse.IMAGES;
	private static final String KEYWORDS_ENDPOINT = "/" + TvIdAppendToResponse.KEYWORDS;
	private static final String RATING_ENDPOINT = "/rating";
	private static final String RECOMMENDATIONS_ENDPOINT = "/" + TvIdAppendToResponse.RECOMMENDATIONS;
	private static final String REVIEWS_ENDPOINT = "/" + TvIdAppendToResponse.REVIEWS;
	private static final String SCREENED_THEATRICALLY_ENDPOINT = "/" + TvIdAppendToResponse.SCREENED_THEATRICALLY;
	private static final String SIMILAR_ENDPOINT = "/" + TvIdAppendToResponse.SIMILAR;
	private static final String TRANSLATIONS_ENDPOINT = "/" + TvIdAppendToResponse.TRANSLATIONS;
	private static final String VIDEOS_ENDPOINT = "/" + TvIdAppendToResponse.VIDEOS;
	private static final String WATCH_PROVIDERS_ENDPOINT = "/" + TvIdAppendToResponse.WATCH_PROVIDERS;

	private final long tvId;
	private final List<TvIdAppendToResponse> appendToResponse = new ArrayList<>();
	private final List<String> includeImageLanguage = new ArrayList<>();
	private final List<String> includeVideoLanguage = new ArrayList<>();
	private String language;
	private String startDate;
	private String endDate;
	private int page;

	public TvIdEndpoint(TMDbClient tmdbClient, long tvId) {
		super(tmdbClient);
		this.tvId = tvId;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public TvIdEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * You can query up to 14 days in a single query by using the startDate and
	 * endDate query parameters.
	 *
	 * @param value start date
	 * @return this request
	 */
	public TvIdEndpoint setStartDate(String value) {
		this.startDate = value;
		return this;
	}

	/**
	 * You can query up to 14 days in a single query by using the startDate and
	 * endDate query parameters.
	 *
	 * @param value end date
	 * @return this request
	 */
	public TvIdEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this request
	 */
	public TvIdEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	public TvIdEndpoint appendToResponse(TvIdAppendToResponse... values) {
		if (values != null) {
			for (TvIdAppendToResponse value : values) {
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
	public TvIdEndpoint includeImageLanguage(String... values) {
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
	public TvIdEndpoint includeVideoLanguage(String... values) {
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
	 * Get TV show details.
	 *
	 * @return TV show details.
	 */
	public TvDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId, TvDetailsSchema.class, query);
	}

	/**
	 * Grab the following account states for a session. - TV rating - If it
	 * belongs to your watchlist - If it belongs to your favourite list
	 *
	 * @return Movie Account States.
	 */
	public AccountStatesResponseSchema getAccountStates() {
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + ACCOUNT_STATES_ENDPOINT, AccountStatesResponseSchema.class, null);
	}

	/**
	 * Get the aggregate credits for TV show.
	 *
	 * @return TV show aggregate credits.
	 */
	public AggregateCreditsResponseSchema getAggregateCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + AGGREGATE_CREDITS_ENDPOINT, AggregateCreditsResponseSchema.class, query);
	}

	/**
	 * Get all of the alternative titles for a TV show.
	 *
	 * @return TV show alternative titles.
	 */
	public TvAlternativeTitlesResponseSchema getAlternativeTitles() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + ALTERNATIVE_TITLES_ENDPOINT, TvAlternativeTitlesResponseSchema.class, query);
	}

	/**
	 * Get the changes for a movie. By default only the last 24 hours are
	 * returned.
	 *
	 * @return Movie changes.
	 */
	public ChangesSchema getChanges() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_START_DATE, startDate);
		addQueryString(query, QUERY_END_DATE, endDate);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + CHANGES_ENDPOINT, ChangesSchema.class, query);
	}

	/**
	 * Get the list of content ratings (certifications) that have been added to
	 * a TV show.
	 *
	 * @return TV swow content ratings.
	 */
	public TvContentRatingsResponseSchema getContentRatings() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + CONTENT_RATINGS_ENDPOINT, TvContentRatingsResponseSchema.class, query);
	}

	/**
	 * Get the credits (cast, crew and guest stars) for a TV swow.
	 *
	 * @return TV swow credits.
	 */
	public MediaCreditsResponseSchema getCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + CREDITS_ENDPOINT, MediaCreditsResponseSchema.class, query);
	}

	/**
	 * Get all of the episode groups that have been created for a TV show.
	 *
	 * @return TV episode groups.
	 */
	public TvEpisodeGroupsResponseSchema getEpisodeGroups() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + EPISODE_GROUPS_ENDPOINT, TvEpisodeGroupsResponseSchema.class, query);
	}

	/**
	 * Get the external ids for a TV swow.
	 *
	 * @return TV swow external ids.
	 */
	public TvExternalIdsResponseSchema getExternalIds() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + EXTERNAL_IDS_ENDPOINT, TvExternalIdsResponseSchema.class, query);
	}

	/**
	 * Get the images that belong to a TV swow.
	 *
	 * @return TV swow images.
	 */
	public ImagesResponseSchema getImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + IMAGES_ENDPOINT, ImagesResponseSchema.class, query);
	}

	/**
	 * Get the keywords that have been added to a TV show.
	 *
	 * @return TV swow keywords.
	 */
	public TvKeywordsResponseSchema getKeywords() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + KEYWORDS_ENDPOINT, TvKeywordsResponseSchema.class, query);
	}

	/**
	 * Get the list of TV show recommendations for this item.
	 *
	 * @return TV show recommendations.
	 */
	public TvTypedResultsSchema getRecommendations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + RECOMMENDATIONS_ENDPOINT, TvTypedResultsSchema.class, query);
	}

	/**
	 * Get the reviews for a TV show.
	 *
	 * @return TV Reviews.
	 */
	public ReviewsResponseSchema getReviews() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + REVIEWS_ENDPOINT, ReviewsResponseSchema.class, query);
	}

	/**
	 * Get a list of seasons or episodes that have been screened in a film
	 * festival or theatre.
	 *
	 * @return TV show screened theatrically.
	 */
	public TvScreenedTheatricallyResponseSchema getScreenedTheatrically() {
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SCREENED_THEATRICALLY_ENDPOINT, TvScreenedTheatricallyResponseSchema.class, null);
	}

	/**
	 * Get a list of similar TV shows. This is not the same as the
	 * "Recommendation" system you see on the website.
	 *
	 * These items are assembled by looking at keywords and genres.
	 *
	 * @return Similar TV shows.
	 */
	public TvSimpleResultsSchema getSimilar() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + SIMILAR_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

	/**
	 * Get the translation data for a TV swow.
	 *
	 * @return TV swow translations.
	 */
	public TvTranslationsResponseSchema getTranslations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + TRANSLATIONS_ENDPOINT, TvTranslationsResponseSchema.class, query);
	}

	/**
	 * Get the videos that have been added to a TV swow.
	 *
	 * @return TV swow videos.
	 */
	public VideosResponseSchema getVideos() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + VIDEOS_ENDPOINT, VideosResponseSchema.class, query);
	}

	/**
	 * Get Watch Providers.
	 *
	 * Powered by TMDB partnership with JustWatch, you can query this method to
	 * get a list of the availabilities per country by provider.
	 *
	 * You can link to the provided TMDB URL to help support TMDB and provide
	 * the actual deep links to the content.
	 *
	 * @return TV Watch Providers.
	 */
	public WatchProvidersResponseSchema getWatchProviders() {
		return tmdbClient.get(V3_TV_ENDPOINT + tvId + WATCH_PROVIDERS_ENDPOINT, WatchProvidersResponseSchema.class, null);
	}

	/**
	 * Remove your rating for a TV show. A valid session or guest session ID is
	 * required.
	 *
	 * @return Status
	 */
	public StatusSchema deleteRating() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryString(query, QUERY_GUEST_SESSION_ID, tmdbClient.getGuestSessionId());
		return tmdbClient.delete(V3_TV_ENDPOINT + tvId + RATING_ENDPOINT, StatusSchema.class, query);
	}

	/**
	 * Rate a TV show. A valid session or guest session ID is required.
	 *
	 * @return Status
	 */
	public StatusSchema postRating(float value) {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryString(query, QUERY_GUEST_SESSION_ID, tmdbClient.getGuestSessionId());
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("value", value);
		return tmdbClient.post(V3_TV_ENDPOINT + tvId + RATING_ENDPOINT, StatusSchema.class, query, jsonObject.toString());
	}

}
