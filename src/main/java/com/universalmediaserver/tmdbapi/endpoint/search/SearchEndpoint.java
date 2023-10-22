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
package com.universalmediaserver.tmdbapi.endpoint.search;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;

/**
 * Find endpoint. The find method makes it easy to search for objects in our
 * database by an external id. This method will search all objects (movies, TV
 * shows and people) and return the results in a single response.
 *
 * @author SurfaceS
 */
public class SearchEndpoint extends Endpoint {

	private final String searchQuery;

	public SearchEndpoint(TMDbClient tmdbClient, String searchQuery) {
		super(tmdbClient);
		this.searchQuery = searchQuery;
	}

	/**
	 * Search for a collection.
	 */
	public SearchCollectionEndpoint forCollection() {
		return new SearchCollectionEndpoint(tmdbClient, searchQuery);
	}

	/**
	 * Search for a company.
	 */
	public SearchCompanyEndpoint forCompany() {
		return new SearchCompanyEndpoint(tmdbClient, searchQuery);
	}

	/**
	 * Search for keywords.
	 */
	public SearchKeywordEndpoint forKeyword() {
		return new SearchKeywordEndpoint(tmdbClient, searchQuery);
	}

	/**
	 * Search for a movie.
	 */
	public SearchMovieEndpoint forMovie() {
		return new SearchMovieEndpoint(tmdbClient, searchQuery);
	}

	/**
	 * Search multiple models in a single request.
	 */
	public SearchMultiEndpoint forMulti() {
		return new SearchMultiEndpoint(tmdbClient, searchQuery);
	}

	/**
	 * Search for a person.
	 */
	public SearchPersonEndpoint forPerson() {
		return new SearchPersonEndpoint(tmdbClient, searchQuery);
	}

	/**
	 * Search for a TV show.
	 */
	public SearchTvEndpoint forTvShow() {
		return new SearchTvEndpoint(tmdbClient, searchQuery);
	}

}
