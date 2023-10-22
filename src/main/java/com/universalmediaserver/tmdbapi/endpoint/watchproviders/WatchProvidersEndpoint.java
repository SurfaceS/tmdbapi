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
package com.universalmediaserver.tmdbapi.endpoint.watchproviders;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.watchproviders.WatchProviderRegionsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.watchproviders.WatchProviderResponseSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Watch Providers Endpoint.
 *
 * @author SurfaceS
 */
public class WatchProvidersEndpoint extends Endpoint {

	private static final String V3_WATCH_PROVIDERS_ENDPOINT = V3_ENDPOINT + "watch/providers/";
	private static final String REGIONS_ENDPOINT = V3_WATCH_PROVIDERS_ENDPOINT + "regions";
	private static final String MOVIE_ENDPOINT = V3_WATCH_PROVIDERS_ENDPOINT + "movie";
	private static final String TV_ENDPOINT = V3_WATCH_PROVIDERS_ENDPOINT + "tv";

	private String language;
	private String watchRegion;

	public WatchProvidersEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this endpoint
	 */
	public WatchProvidersEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Set query watch region.
	 *
	 * @param value query watch region
	 * @return this endpoint
	 */
	public WatchProvidersEndpoint setWatchRegion(String value) {
		this.watchRegion = value.toUpperCase();
		return this;
	}

	/**
	 * Get Available Regions. Returns a list of all of the countries we have
	 * watch provider (OTT/streaming) data for.
	 *
	 * @return Available Regions.
	 */
	public WatchProviderRegionsResponseSchema getRegions() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(REGIONS_ENDPOINT, WatchProviderRegionsResponseSchema.class, query);
	}

	/**
	 * Returns a list of the watch provider (OTT/streaming) data TMDb have
	 * available for movies.
	 *
	 * @return Movie Providers.
	 */
	public WatchProviderResponseSchema forMovies() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryString(query, QUERY_WATCH_REGION, watchRegion);
		return tmdbClient.get(MOVIE_ENDPOINT, WatchProviderResponseSchema.class, query);
	}

	/**
	 * Returns a list of the watch provider (OTT/streaming) data TMDb have
	 * available for TV series.
	 *
	 * @return Movie Providers.
	 */
	public WatchProviderResponseSchema forTv() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryString(query, QUERY_WATCH_REGION, watchRegion);
		return tmdbClient.get(TV_ENDPOINT, WatchProviderResponseSchema.class, query);
	}

}
