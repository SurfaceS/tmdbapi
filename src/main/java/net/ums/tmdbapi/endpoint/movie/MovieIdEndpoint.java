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
package net.ums.tmdbapi.endpoint.movie;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.StatusSchema;
import net.ums.tmdbapi.schema.account.AccountStatesResponseSchema;
import net.ums.tmdbapi.schema.change.ChangesSchema;
import net.ums.tmdbapi.schema.credit.MediaCreditsResponseSchema;
import net.ums.tmdbapi.schema.image.ImagesResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieAlternativeTitlesResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieDetailsSchema;
import net.ums.tmdbapi.schema.movie.MovieExternalIdsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieKeywordsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieListsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieReleaseDatesResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieShortResultsSchema;
import net.ums.tmdbapi.schema.movie.MovieTranslationsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieTypedResultsSchema;
import net.ums.tmdbapi.schema.reviews.ReviewsResponseSchema;
import net.ums.tmdbapi.schema.video.VideosResponseSchema;
import net.ums.tmdbapi.schema.watchproviders.WatchProvidersResponseSchema;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Movie endpoint. Get the primary information about a movie.
 *
 * @author SurfaceS
 */
public class MovieIdEndpoint extends Endpoint {

	private static final String V3_MOVIE_ENDPOINT = V3_ENDPOINT + "movie/";
	private static final String ACCOUNT_STATES_ENDPOINT = "/" + MovieIdAppendToResponse.ACCOUNT_STATES;
	private static final String ALTERNATIVE_TITLES_ENDPOINT = "/" + MovieIdAppendToResponse.ALTERNATIVE_TITLES;
	private static final String CHANGES_ENDPOINT = "/" + MovieIdAppendToResponse.CHANGES;
	private static final String CREDITS_ENDPOINT = "/" + MovieIdAppendToResponse.CREDITS;
	private static final String EXTERNAL_IDS_ENDPOINT = "/" + MovieIdAppendToResponse.EXTERNAL_IDS;
	private static final String IMAGES_ENDPOINT = "/" + MovieIdAppendToResponse.IMAGES;
	private static final String KEYWORDS_ENDPOINT = "/" + MovieIdAppendToResponse.KEYWORDS;
	private static final String LISTS_ENDPOINT = "/" + MovieIdAppendToResponse.LISTS;
	private static final String RATING_ENDPOINT = "/rating";
	private static final String RECOMMENDATIONS_ENDPOINT = "/" + MovieIdAppendToResponse.RECOMMENDATIONS;
	private static final String RELEASE_DATES_ENDPOINT = "/" + MovieIdAppendToResponse.RELEASE_DATES;
	private static final String REVIEWS_ENDPOINT = "/" + MovieIdAppendToResponse.REVIEWS;
	private static final String SIMILAR_ENDPOINT = "/" + MovieIdAppendToResponse.SIMILAR;
	private static final String TRANSLATIONS_ENDPOINT = "/" + MovieIdAppendToResponse.TRANSLATIONS;
	private static final String VIDEOS_ENDPOINT = "/" + MovieIdAppendToResponse.VIDEOS;
	private static final String WATCH_PROVIDERS_ENDPOINT = "/" + MovieIdAppendToResponse.WATCH_PROVIDERS;

	private final long movieId;
	private final List<MovieIdAppendToResponse> appendToResponse = new ArrayList<>();
	private final List<String> includeImageLanguage = new ArrayList<>();
	private final List<String> includeVideoLanguage = new ArrayList<>();
	private String country;
	private String language;
	private String startDate;
	private String endDate;
	private int page;

	public MovieIdEndpoint(TMDbClient tmdbClient, long movieId) {
		super(tmdbClient);
		this.movieId = movieId;
	}

	/**
	 * Set query country.
	 *
	 * @param value query country
	 * @return this request
	 */
	public MovieIdEndpoint setCountry(String value) {
		this.country = value;
		return this;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public MovieIdEndpoint setLanguage(String value) {
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
	public MovieIdEndpoint setStartDate(String value) {
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
	public MovieIdEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this request
	 */
	public MovieIdEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	public MovieIdEndpoint appendToResponse(MovieIdAppendToResponse... appendsToResponse) {
		if (appendsToResponse != null) {
			for (MovieIdAppendToResponse movieIdAppendToResponse : appendsToResponse) {
				if (!appendToResponse.contains(movieIdAppendToResponse)) {
					appendToResponse.add(movieIdAppendToResponse);
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
	public MovieIdEndpoint includeImageLanguage(String... values) {
		if (values != null) {
			for (String imageLanguage : values) {
				if (!includeImageLanguage.contains(imageLanguage)) {
					includeImageLanguage.add(imageLanguage);
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
	public MovieIdEndpoint includeVideoLanguage(String... values) {
		if (values != null) {
			for (String videoLanguage : values) {
				if (!includeVideoLanguage.contains(videoLanguage)) {
					includeVideoLanguage.add(videoLanguage);
				}
			}
		}
		return this;
	}

	/**
	 * Get the primary information about a movie.
	 *
	 * @return Movie details.
	 */
	public MovieDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId, MovieDetailsSchema.class, query);
	}

	/**
	 * Get all of the alternative titles for a movie.
	 *
	 * @return Movie alternative titles.
	 */
	public MovieAlternativeTitlesResponseSchema getAlternativeTitles() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_COUNTRY, country);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + ALTERNATIVE_TITLES_ENDPOINT, MovieAlternativeTitlesResponseSchema.class, query);
	}

	/**
	 * Grab the following account states for a session. - Movie rating - If it
	 * belongs to your watchlist - If it belongs to your favourite list
	 *
	 * @return Movie Account States.
	 */
	public AccountStatesResponseSchema getAccountStates() {
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + ACCOUNT_STATES_ENDPOINT, AccountStatesResponseSchema.class, null);
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
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + CHANGES_ENDPOINT, ChangesSchema.class, query);
	}

	/**
	 * Get the credits (cast, crew and guest stars) for a movie.
	 *
	 * @return Movie credits.
	 */
	public MediaCreditsResponseSchema getCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + CREDITS_ENDPOINT, MediaCreditsResponseSchema.class, query);
	}

	/**
	 * Get the external ids for a movie.
	 *
	 * @return Movie external ids.
	 */
	public MovieExternalIdsResponseSchema getExternalIds() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + EXTERNAL_IDS_ENDPOINT, MovieExternalIdsResponseSchema.class, query);
	}

	/**
	 * Get the images that belong to a movie.
	 *
	 * @return Movie images.
	 */
	public ImagesResponseSchema getImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + IMAGES_ENDPOINT, ImagesResponseSchema.class, query);
	}

	/**
	 * Get the keywords that have been added to a movie.
	 *
	 * @return Movie keywords.
	 */
	public MovieKeywordsResponseSchema getKeywords() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + KEYWORDS_ENDPOINT, MovieKeywordsResponseSchema.class, query);
	}

	/**
	 * Get a list of lists that this movie belongs to.
	 *
	 * @return Movie Lists.
	 */
	public MovieListsResponseSchema getLists() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + LISTS_ENDPOINT, MovieListsResponseSchema.class, query);
	}

	/**
	 * Get a list of recommended movies for a movie.
	 *
	 * @return Recommendations Movies.
	 */
	public MovieTypedResultsSchema getRecommendations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + RECOMMENDATIONS_ENDPOINT, MovieTypedResultsSchema.class, query);
	}

	/**
	 * Get the release date along with the certification for a movie.
	 *
	 * @return Movie Release Dates.
	 */
	public MovieReleaseDatesResponseSchema getReleaseDates() {
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + RELEASE_DATES_ENDPOINT, MovieReleaseDatesResponseSchema.class, null);
	}

	/**
	 * Get the user reviews for a movie.
	 *
	 * @return Movie Reviews.
	 */
	public ReviewsResponseSchema getReviews() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + REVIEWS_ENDPOINT, ReviewsResponseSchema.class, query);
	}

	/**
	 * Get a list of similar movies. This is not the same as the
	 * "Recommendation" system you see on the website.
	 *
	 * These items are assembled by looking at keywords and genres.
	 *
	 * @return Similar Movies.
	 */
	public MovieShortResultsSchema getSimilar() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + SIMILAR_ENDPOINT, MovieShortResultsSchema.class, query);
	}

	/**
	 * Get the translation data for a movie.
	 *
	 * @return Movie translations.
	 */
	public MovieTranslationsResponseSchema getTranslations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + TRANSLATIONS_ENDPOINT, MovieTranslationsResponseSchema.class, query);
	}

	/**
	 * Get the videos that have been added to a movie.
	 *
	 * @return Movie videos.
	 */
	public VideosResponseSchema getVideos() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_VIDEO_LANGUAGE, includeVideoLanguage);
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + VIDEOS_ENDPOINT, VideosResponseSchema.class, query);
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
	 * @return Movie Watch Providers.
	 */
	public WatchProvidersResponseSchema getWatchProviders() {
		return tmdbClient.get(V3_MOVIE_ENDPOINT + movieId + WATCH_PROVIDERS_ENDPOINT, WatchProvidersResponseSchema.class, null);
	}

	/**
	 * Remove your rating for a movie. A valid session or guest session ID is
	 * required.
	 *
	 * @return Status
	 */
	public StatusSchema deleteRating() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryString(query, QUERY_GUEST_SESSION_ID, tmdbClient.getGuestSessionId());
		return tmdbClient.delete(V3_MOVIE_ENDPOINT + movieId + RATING_ENDPOINT, StatusSchema.class, query);
	}

	/**
	 * Rate a movie. A valid session or guest session ID is required.
	 *
	 * @return Status
	 */
	public StatusSchema postRating(float value) {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		addQueryString(query, QUERY_GUEST_SESSION_ID, tmdbClient.getGuestSessionId());
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("value", value);
		return tmdbClient.post(V3_MOVIE_ENDPOINT + movieId + RATING_ENDPOINT, StatusSchema.class, query, jsonObject.toString());
	}

}
