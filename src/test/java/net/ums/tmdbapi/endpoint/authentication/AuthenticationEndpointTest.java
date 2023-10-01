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
package net.ums.tmdbapi.endpoint.authentication;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.SuccessSchema;
import net.ums.tmdbapi.schema.authentication.AuthenticationGuestSessionSchema;
import net.ums.tmdbapi.schema.authentication.AuthenticationRequestTokenSchema;
import net.ums.tmdbapi.schema.authentication.AuthenticationSessionSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 *
 * @author SurfaceS
 */
@EnabledIf(
		value = "haveTmdbReadAccess",
		disabledReason = BaseTestClass.TMDB_API_ENV_MISSING
)
public class AuthenticationEndpointTest extends BaseTestClass {

	public AuthenticationEndpointTest() {
	}

	/**
	 * Test of createGuestSession method, of class AuthenticationEndpoint.
	 */
	@Test
	public void testCreateGuestSession() {
		System.out.println("AuthenticationEndpoint createGuestSession");
		AuthenticationGuestSessionSchema sessionResult = tmdb.authentication().createGuestSession();
		assertParsedObject(sessionResult);
		assertNotNull(sessionResult.getGuestSessionId());
	}

	/**
	 * Test of createSessionWithLogin method, of class AuthenticationEndpoint.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbCredential",
			disabledReason = TMDB_CREDENTIAL_MISSING
	)
	public void testCreateSessionWithLogin() {
		System.out.println("AuthenticationEndpoint createSessionWithLogin");
		AuthenticationRequestTokenSchema tokenResult = tmdb.authentication().createRequestToken();
		assertParsedObject(tokenResult);
		assertNotNull(tokenResult.getRequestToken());
		AuthenticationRequestTokenSchema validateResult = tmdb.authentication().validateTokenWithLogin(tokenResult.getRequestToken(), getTmdbUsername(), getTmdbPassword());
		assertParsedObject(validateResult);
		assertNotNull(validateResult.getRequestToken());
		AuthenticationSessionSchema sessionResult = tmdb.authentication().createSession(validateResult.getRequestToken());
		assertParsedObject(sessionResult);
		assertNotNull(sessionResult.getSessionId());
		SuccessSchema deleteResult = tmdb.authentication().deleteSession(sessionResult.getSessionId());
		assertParsedObject(deleteResult);
		assertTrue(deleteResult.getSuccess());
	}

	/**
	 * Test of convertSession method, of class AuthenticationEndpoint.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbApiAccessToken",
			disabledReason = TMDB_API_ACCESS_TOKEN_MISSING
	)
	public void testConvertSession() {
		System.out.println("AuthenticationEndpoint convertSession");
		AuthenticationSessionSchema sessionResult = tmdb.authentication().convertSession(getTmdbApiAccessToken());
		assertParsedObject(sessionResult);
		SuccessSchema deleteResult = tmdb.authentication().deleteSession(sessionResult.getSessionId());
		assertParsedObject(deleteResult);
		assertTrue(deleteResult.getSuccess());
	}

}
