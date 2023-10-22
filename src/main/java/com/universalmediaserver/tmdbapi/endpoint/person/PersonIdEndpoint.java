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
package com.universalmediaserver.tmdbapi.endpoint.person;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.change.ChangesSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonCombinedCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonExternalIdsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonImagesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonMovieCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonTaggedImagesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonTranslationsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonTvCreditsResponseSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Person endpoint.
 *
 * @author SurfaceS
 */
public class PersonIdEndpoint extends Endpoint {

	private static final String V3_PERSON_ENDPOINT = V3_ENDPOINT + "person/";
	private static final String CHANGES_ENDPOINT = "/" + PersonIdAppendToResponse.CHANGES;
	private static final String COMBINED_CREDITS_ENDPOINT = "/" + PersonIdAppendToResponse.COMBINED_CREDITS;
	private static final String EXTERNAL_IDS_ENDPOINT = "/" + PersonIdAppendToResponse.EXTERNAL_IDS;
	private static final String IMAGES_ENDPOINT = "/" + PersonIdAppendToResponse.IMAGES;
	private static final String MOVIE_CREDITS_ENDPOINT = "/" + PersonIdAppendToResponse.MOVIE_CREDITS;
	private static final String TAGGED_IMAGES_ENDPOINT = "/" + PersonIdAppendToResponse.TAGGED_IMAGES;
	private static final String TRANSLATIONS_ENDPOINT = "/" + PersonIdAppendToResponse.TRANSLATIONS;
	private static final String TV_CREDITS_ENDPOINT = "/" + PersonIdAppendToResponse.TV_CREDITS;

	private final long personId;
	private final List<PersonIdAppendToResponse> appendToResponse = new ArrayList<>();
	private final List<String> includeImageLanguage = new ArrayList<>();
	private String language;
	private String startDate;
	private String endDate;
	private int page;

	public PersonIdEndpoint(TMDbClient tmdbClient, long personId) {
		super(tmdbClient);
		this.personId = personId;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public PersonIdEndpoint setLanguage(String value) {
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
	public PersonIdEndpoint setStartDate(String value) {
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
	public PersonIdEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this request
	 */
	public PersonIdEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	public PersonIdEndpoint appendToResponse(PersonIdAppendToResponse... values) {
		if (values != null) {
			for (PersonIdAppendToResponse value : values) {
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
	public PersonIdEndpoint includeImageLanguage(String... values) {
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
	 * Get the primary person details by id.
	 *
	 * @return Person details.
	 */
	public PersonDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId, PersonDetailsSchema.class, query);
	}

	/**
	 * Get the changes for a person. By default only the last 24 hours are
	 * returned.
	 *
	 * @return Person changes.
	 */
	public ChangesSchema getChanges() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_START_DATE, startDate);
		addQueryString(query, QUERY_END_DATE, endDate);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + CHANGES_ENDPOINT, ChangesSchema.class, query);
	}

	/**
	 * Get the movie and TV credits together in a single response.
	 *
	 * @return Combined credits.
	 */
	public PersonCombinedCreditsResponseSchema getCombinedCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + COMBINED_CREDITS_ENDPOINT, PersonCombinedCreditsResponseSchema.class, query);
	}

	/**
	 * Get the external ids for a person.
	 *
	 * @return Person external ids.
	 */
	public PersonExternalIdsResponseSchema getExternalIds() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + EXTERNAL_IDS_ENDPOINT, PersonExternalIdsResponseSchema.class, query);
	}

	/**
	 * Get the images that belong to a person.
	 *
	 * @return images.
	 */
	public PersonImagesResponseSchema getImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + IMAGES_ENDPOINT, PersonImagesResponseSchema.class, query);
	}

	/**
	 * Get the movie credits for a person.
	 *
	 * @return Movie credits.
	 */
	public PersonMovieCreditsResponseSchema getMovieCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + MOVIE_CREDITS_ENDPOINT, PersonMovieCreditsResponseSchema.class, query);
	}

	/**
	 * Get the images that this person has been tagged in.
	 *
	 * @return Movie images.
	 */
	public PersonTaggedImagesResponseSchema getTaggedImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + TAGGED_IMAGES_ENDPOINT, PersonTaggedImagesResponseSchema.class, query);
	}

	/**
	 * Get the translation data for a person.
	 *
	 * @return Person translations.
	 */
	public PersonTranslationsResponseSchema getTranslations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + TRANSLATIONS_ENDPOINT, PersonTranslationsResponseSchema.class, query);
	}

	/**
	 * Get the TV show credits for a person.
	 *
	 * @return TV show credits.
	 */
	public PersonTvCreditsResponseSchema getTvCredits() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_PERSON_ENDPOINT + personId + TV_CREDITS_ENDPOINT, PersonTvCreditsResponseSchema.class, query);
	}

}
