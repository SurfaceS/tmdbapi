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
package com.universalmediaserver.tmdbapi.endpoint.genre;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.genre.GenresSchema;
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
public class GenreEndpointTest extends BaseTestClass {

	static String TEST_LANGUAGE = "fr";

	public GenreEndpointTest() {
	}

	/**
	 * Test of getList method, of class GenreEndpoint.
	 */
	@Test
	public void testGetList() {
		System.out.println("GenreEndpoint getList");
		GenresSchema result = tmdb.genre().getList();
		assertParsedObject(result);
	}

	/**
	 * Test of getMovieList method, of class GenreEndpoint.
	 */
	@Test
	public void testGetMovieList() {
		System.out.println("GenreEndpoint getMovieList");
		GenresSchema result = tmdb.genre().getMovieList();
		assertParsedObject(result);
	}

	/**
	 * Test of getTvList method, of class GenreEndpoint.
	 */
	@Test
	public void testGetTvList() {
		System.out.println("GenreEndpoint getTvList");
		GenresSchema result = tmdb.genre().getTvList();
		assertParsedObject(result);
	}

	/**
	 * Test of setLanguage method, of class GenreEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("GenreEndpoint setLanguage");
		GenresSchema result = tmdb.genre().setLanguage(TEST_LANGUAGE).getTvList();
		assertParsedObject(result);
	}

}
