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
package net.ums.tmdbapi.endpoint.tv.episodegroup;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.tv.episodegroups.TvEpisodeGroupsSchema;
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
public class TvEpisodeGroupEndpointTest extends BaseTestClass {

	public TvEpisodeGroupEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class TvEpisodeGroupEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("TvEpisodeGroupEndpoint getDetails");
		TvEpisodeGroupsSchema result = tmdb.tvEpisodeGroup("5acf93e60e0a26346d0000ce").getDetails();
		assertParsedObject(result);
	}

	/**
	 * Test of setLanguage method, of class TvEpisodeGroupEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("TvEpisodeGroupEndpoint setLanguage");
		TvEpisodeGroupsSchema result = tmdb.tvEpisodeGroup("5acf93e60e0a26346d0000ce").setLanguage("fr").getDetails();
		assertParsedObject(result);
	}

}
