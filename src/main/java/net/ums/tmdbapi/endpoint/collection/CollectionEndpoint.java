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
package net.ums.tmdbapi.endpoint.collection;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.collection.CollectionImagesResponseSchema;
import net.ums.tmdbapi.schema.collection.CollectionTranslationsResponseSchema;
import net.ums.tmdbapi.schema.collection.CollectionDetailsSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Collection endpoint. Get collection details.
 *
 * @author SurfaceS
 */
public class CollectionEndpoint extends Endpoint {

	private static final String COLLECTION_ENDPOINT = V3_ENDPOINT + "collection/";
	private static final String IMAGES_ENDPOINT = "/images";
	private static final String TRANSLATION_ENDPOINT = "/translations";

	private final long collectionId;
	private final List<CollectionAppendToResponse> appendToResponse = new ArrayList<>();
	private final List<String> includeImageLanguage = new ArrayList<>();
	private String language;

	public CollectionEndpoint(TMDbClient tmdbClient, long collectionId) {
		super(tmdbClient);
		this.collectionId = collectionId;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public CollectionEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	public CollectionEndpoint appendToResponse(CollectionAppendToResponse... values) {
		if (values != null) {
			for (CollectionAppendToResponse value : values) {
				if (!appendToResponse.contains(value)) {
					appendToResponse.add(value);
				}
			}
		}
		return this;
	}

	/**
	 * In the event you query one of the distinct /images methods, you can query
	 * languages by using the include_image_language query parameter.
	 *
	 * It will override the language param for images methods. It will finding
	 * the backdrops and posters in a users specified language but also to grab
	 * all of the images that haven't been tagged with a language yet.
	 *
	 * @param values
	 * @return this request
	 */
	public CollectionEndpoint includeImageLanguage(String... values) {
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
	 * Get collection details.
	 *
	 * @return Collection details.
	 */
	public CollectionDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(COLLECTION_ENDPOINT + collectionId, CollectionDetailsSchema.class, query);
	}

	/**
	 * Get collection images.
	 *
	 * @return Collection images.
	 */
	public CollectionImagesResponseSchema getImages() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryStrings(query, QUERY_INCLUDE_IMAGE_LANGUAGE, includeImageLanguage);
		return tmdbClient.get(COLLECTION_ENDPOINT + collectionId + IMAGES_ENDPOINT, CollectionImagesResponseSchema.class, query);
	}

	/**
	 * Get collection translations.
	 *
	 * @return Collection translations.
	 */
	public CollectionTranslationsResponseSchema getTranslations() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language);
		return tmdbClient.get(COLLECTION_ENDPOINT + collectionId + TRANSLATION_ENDPOINT, CollectionTranslationsResponseSchema.class, query);
	}

}
