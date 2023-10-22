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
package com.universalmediaserver.tmdbapi.endpoint.find;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.find.FindSchema;
import static org.junit.jupiter.api.Assertions.*;
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
public class FindEndpointTest extends BaseTestClass {

	public FindEndpointTest() {
	}

	/**
	 * Test of getResults method, of class FindEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("FindEndpoint getResults");
		System.out.println("FindEndpoint get a movie from imdbId");
		FindSchema result = tmdb.find("tt0816692", FindExternalSource.IMDB_ID).getResults();
		assertParsedObject(result);
		assertNotNull(result.getMovieResults(), "Movie results is null");
		assertFalse(result.getMovieResults().isEmpty(), "Movie results is empty");
		assertEquals(result.getMovieResults().get(0).getTitle(), "Interstellar");
		System.out.println("FindEndpoint get a tv show from imdbId");
		result = tmdb.find("tt0760437", FindExternalSource.IMDB_ID).getResults();
		assertParsedObject(result);
		assertNotNull(result.getTvResults(), "TV results is null");
		assertFalse(result.getTvResults().isEmpty(), "TV results is empty");
		assertEquals(result.getTvResults().get(0).getName(), "Ben 10");
		System.out.println("FindEndpoint get a tv season from tvdbId");
		result = tmdb.find("16658", FindExternalSource.TVDB_ID).getResults();
		assertParsedObject(result);
		assertNotNull(result.getTvSeasonResults(), "Season results is null");
		assertFalse(result.getTvSeasonResults().isEmpty(), "Season results is empty");
		assertEquals(result.getTvSeasonResults().get(0).getName(), "Book Three: Fire");
		System.out.println("FindEndpoint get a tv episode from imdbId");
		result = tmdb.find("tt0994359", FindExternalSource.IMDB_ID).getResults();
		assertParsedObject(result);
		assertNotNull(result.getTvEpisodeResults(), "Episode results is null");
		assertFalse(result.getTvEpisodeResults().isEmpty(), "Episode results is empty");
		assertEquals(result.getTvEpisodeResults().get(0).getName(), "Confirmed Dead");
		System.out.println("FindEndpoint get a person from imdbId");
		result = tmdb.find("nm0000093", FindExternalSource.IMDB_ID).getResults();
		assertParsedObject(result);
		assertNotNull(result.getPersonResults(), "Person results is null");
		assertFalse(result.getPersonResults().isEmpty(), "Person results is empty");
		assertEquals(result.getPersonResults().get(0).getName(), "Brad Pitt");
	}

	/**
	 * Test of setLanguage method, of class FindEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("FindEndpoint setLanguage");
		FindSchema result = tmdb.find("tt0816692", FindExternalSource.IMDB_ID).setLanguage("fr").getResults();
		assertParsedObject(result);
		assertNotNull(result.getMovieResults(), "Movie results is null");
		assertFalse(result.getMovieResults().isEmpty(), "Movie results is empty");
		assertTrue(result.getMovieResults().get(0).getOverview().startsWith("Dans un futur proche"), "Movie result are not in asked language");
	}

}
