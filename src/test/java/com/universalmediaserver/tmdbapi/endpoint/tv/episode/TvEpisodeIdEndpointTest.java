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
package com.universalmediaserver.tmdbapi.endpoint.tv.episode;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.change.ChangesSchema;
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
public class TvEpisodeIdEndpointTest extends BaseTestClass {

	static int TV_EPISODE_ID = 3921673;
	static String START_DATE = "2023-01-01";
	static String END_DATE = "2023-01-14";

	public TvEpisodeIdEndpointTest() {
	}

	/**
	 * Test of getChanges method, of class TvEpisodeIdEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("TvEpisodeIdEndpoint getChanges");
		ChangesSchema result = tmdb.tvEpisode(TV_EPISODE_ID).getChanges();
		assertParsedObject(result);
		assertNotNull(result.getChanges());
	}

	/**
	 * Test of setStartDate and setEndDate method, of class TvEpisodeIdEndpoint.
	 */
	@Test
	public void testSetStartEndDate() {
		System.out.println("TvEpisodeIdEndpoint setStartDate");
		ChangesSchema result = tmdb.tvEpisode(TV_EPISODE_ID).setStartDate(START_DATE).setEndDate(END_DATE).getChanges();
		assertParsedObject(result);
		assertNotNull(result.getChanges());
		assertEquals(result.getChanges().size(), 2);
	}

}
