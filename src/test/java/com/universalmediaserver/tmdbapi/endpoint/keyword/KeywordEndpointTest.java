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
package com.universalmediaserver.tmdbapi.endpoint.keyword;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.keyword.KeywordDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.keyword.KeywordMoviesResponseSchema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 *
 * @author SurfaceS
 */
@EnabledIf(
		value = "haveTmdbReadAccess",
		disabledReason = BaseTestClass.TMDB_API_ENV_MISSING
)
public class KeywordEndpointTest extends BaseTestClass {

	static long KEYWORD_ID = 3417;
	static String TEST_LANGUAGE = "fr";

	public KeywordEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class KeywordEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("KeywordEndpoint getDetails");
		KeywordDetailsSchema result = tmdb.keyword(KEYWORD_ID).getDetails();
		assertParsedObject(result);
	}

	/**
	 * Test of getMovies method, of class KeywordEndpoint.
	 */
	@Test
	public void testGetMovies() {
		System.out.println("KeywordEndpoint getMovies");
		KeywordMoviesResponseSchema result = tmdb.keyword(KEYWORD_ID).getMovies();
		assertParsedObject(result);
	}

	/**
	 * Test of setLanguage method, of class KeywordEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("KeywordEndpoint setLanguage");
		KeywordMoviesResponseSchema result = tmdb.keyword(KEYWORD_ID).setLanguage(TEST_LANGUAGE).getMovies();
		assertParsedObject(result);
	}

	/**
	 * Test of appendToResponse method, of class KeywordEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("KeywordEndpoint appendToResponse");
		KeywordDetailsSchema result = tmdb.keyword(KEYWORD_ID)
				.appendToResponse(
						KeywordAppendToResponse.MOVIES
				).getDetails();
		assertParsedObject(result);
	}

}
