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
package net.ums.tmdbapi.endpoint.certification;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.certification.CertificationsSchema;
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
public class CertificationEndpointTest extends BaseTestClass {

	public CertificationEndpointTest() {
	}

	/**
	 * Test of getMovieList method, of class CertificationEndpoint.
	 */
	@Test
	public void testGetMovieList() {
		System.out.println("CertificationEndpoint getMovieList");
		CertificationsSchema result = tmdb.certification().getMovieList();
		assertParsedObject(result);
	}

	/**
	 * Test of getTvList method, of class CertificationEndpoint.
	 */
	@Test
	public void testGetTvList() {
		System.out.println("CertificationEndpoint getTvList");
		CertificationsSchema result = tmdb.certification().getTvList();
		assertParsedObject(result);
	}

}
