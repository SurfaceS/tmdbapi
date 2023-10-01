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
package net.ums.tmdbapi.endpoint.tv;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.change.ChangesIdsSchema;
import net.ums.tmdbapi.schema.tv.TvSchema;
import net.ums.tmdbapi.schema.tv.TvSimpleResultsSchema;
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
public class TvEndpointTest extends BaseTestClass {

	public TvEndpointTest() {
	}

	/**
	 * Test of getChanges method, of class TvEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("TvEndpoint getChanges");
		ChangesIdsSchema result = tmdb.tv().getChanges();
		assertParsedObject(result);
	}

	/**
	 * Test of getLatest method, of class TvEndpoint.
	 */
	@Test
	public void testGetLatest() {
		System.out.println("TvEndpoint getLatest");
		TvSchema result = tmdb.tv().getLatest();
		assertParsedObject(result);
	}

	/**
	 * Test of getAiringToday method, of class TvEndpoint.
	 */
	@Test
	public void testGetAiringToday() {
		System.out.println("TvEndpoint getAiringToday");
		TvSimpleResultsSchema result = tmdb.tv().getAiringToday();
		assertParsedObject(result);
	}

	/**
	 * Test of getOnTheAir method, of class TvEndpoint.
	 */
	@Test
	public void testGetOnTheAir() {
		System.out.println("TvEndpoint getOnTheAir");
		TvSimpleResultsSchema result = tmdb.tv().getOnTheAir();
		assertParsedObject(result);
	}

	/**
	 * Test of getPopular method, of class TvEndpoint.
	 */
	@Test
	public void testGetPopular() {
		System.out.println("TvEndpoint getPopular");
		TvSimpleResultsSchema result = tmdb.tv().getPopular();
		assertParsedObject(result);
	}

	/**
	 * Test of getTopRated method, of class TvEndpoint.
	 */
	@Test
	public void testGetTopRated() {
		System.out.println("TvEndpoint getTopRated");
		TvSimpleResultsSchema result = tmdb.tv().getTopRated();
		assertParsedObject(result);
	}

}
