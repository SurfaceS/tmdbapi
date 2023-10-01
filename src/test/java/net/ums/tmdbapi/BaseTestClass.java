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
package net.ums.tmdbapi;

import net.ums.tmdbapi.schema.authentication.AuthenticationRequestTokenSchema;
import net.ums.tmdbapi.schema.authentication.AuthenticationSessionSchema;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;

/**
 * Base setup and compare parsed object to json string.
 *
 * @author SurfaceS
 */
public class BaseTestClass {

	private static final Gson GSON = new Gson().newBuilder().setPrettyPrinting().create();
	private static final String TMDB_ACCOUNT = "TMDB_ACCOUNT";
	private static final String TMDB_API_ACCESS_TOKEN = "TMDB_API_ACCESS_TOKEN";
	private static final String TMDB_API_KEY = "TMDB_API_KEY";
	private static final String TMDB_API_READ_TOKEN = "TMDB_API_READ_TOKEN";
	private static final String TMDB_PASSWORD = "TMDB_PASSWORD";
	private static final String TMDB_USERNAME = "TMDB_USERNAME";
	private static final String TMDB_BAD_CREDENTIAL = "Can't log in with defined " + TMDB_USERNAME + " and " + TMDB_PASSWORD + " credentials.";

	protected static String tmdbApiKey;
	protected static String tmdbApiReadToken;
	protected static String tmdbApiAccessToken;
	protected static String tmdbAccount;
	protected static String tmdbUsername;
	protected static String tmdbPassword;
	protected static TMDbClient tmdb;

	public static final String TMDB_API_ENV_MISSING = TMDB_API_KEY + ", " + TMDB_API_READ_TOKEN + " and " + TMDB_API_ACCESS_TOKEN + " are not defined in the system environment.";
	public static final String TMDB_CREDENTIAL_MISSING = TMDB_USERNAME + " and/or " + TMDB_PASSWORD + " are not defined in the system environment.";
	public static final String TMDB_API_ACCESS_TOKEN_MISSING = TMDB_API_ACCESS_TOKEN + " is not defined in the system environment.";
	public static final String TMDB_ACCOUNT_MISSING = TMDB_ACCOUNT + " is not defined in the system environment.";

	protected static boolean haveTmdbApiKey() {
		return System.getenv(TMDB_API_KEY) != null;
	}

	protected static boolean haveTmdbApiReadToken() {
		return System.getenv(TMDB_API_READ_TOKEN) != null;
	}

	protected static boolean haveTmdbApiAccessToken() {
		return System.getenv(TMDB_API_ACCESS_TOKEN) != null;
	}

	protected static boolean haveTmdbReadAccess() {
		return haveTmdbApiKey() || haveTmdbApiReadToken() || haveTmdbApiAccessToken();
	}

	protected static boolean haveTmdbCredential() {
		return System.getenv(TMDB_USERNAME) != null && System.getenv(TMDB_PASSWORD) != null;
	}

	protected static boolean haveTmdbAccount() {
		return System.getenv(TMDB_ACCOUNT) != null;
	}

	protected static boolean haveTmdbSessionProspective() {
		return haveTmdbCredential() || haveTmdbApiAccessToken();
	}

	@BeforeAll
	public static void setUpClass() {
		setTmdbClient();
	}

	@AfterAll()
	public static void tearDownClass() {
		deleteSessionV3();
	}

	private static void setTmdbClient() {
		tmdbApiKey = System.getenv(TMDB_API_KEY);
		tmdbApiReadToken = System.getenv(TMDB_API_READ_TOKEN);
		tmdbApiAccessToken = System.getenv(TMDB_API_ACCESS_TOKEN);
		tmdbAccount = System.getenv(TMDB_ACCOUNT);
		tmdbUsername = System.getenv(TMDB_USERNAME);
		tmdbPassword = System.getenv(TMDB_PASSWORD);
		if (tmdbApiKey == null && tmdbApiReadToken == null) {
			return;
		}
		if (tmdbApiKey == null) {
			tmdb = new TMDbClient(tmdbApiReadToken);
		} else {
			tmdb = new TMDbClient(tmdbApiKey);
			tmdb.setReadToken(tmdbApiReadToken);
		}
		tmdb.setTesting(true);
		tmdb.setAccessToken(tmdbApiAccessToken);
	}

	protected static String getTmdbApiAccessToken() {
		return tmdbApiAccessToken;
	}

	protected static String getTmdbUsername() {
		return tmdbUsername;
	}

	protected static String getTmdbPassword() {
		return tmdbPassword;
	}

	protected static String getTmdbAccount() {
		return tmdbAccount;
	}

	protected static boolean getSessionV3() {
		if (tmdb != null) {
			if (tmdb.getSessionId() != null) {
				return true;
			}
			if (tmdbApiAccessToken != null) {
				AuthenticationSessionSchema sessionResult = tmdb.authentication().convertSession(tmdbApiAccessToken);
				if (sessionResult != null && sessionResult.getSessionId() != null) {
					return tmdb.getSessionId() != null;
				}
			}
			if (tmdbUsername != null && tmdbPassword != null) {
				AuthenticationRequestTokenSchema tokenResult = tmdb.authentication().createRequestToken();
				if (tokenResult == null || tokenResult.getRequestToken() == null) {
					return false;
				}
				AuthenticationRequestTokenSchema validateResult = tmdb.authentication().validateTokenWithLogin(tokenResult.getRequestToken(), tmdbUsername, tmdbPassword);
				if (validateResult == null || validateResult.getRequestToken() == null) {
					System.out.println(TMDB_BAD_CREDENTIAL);
					return false;
				}
				AuthenticationSessionSchema sessionResult = tmdb.authentication().createSession(validateResult.getRequestToken());
				if (sessionResult != null && sessionResult.getSessionId() != null) {
					return tmdb.getSessionId() != null;
				}
			}
		}
		return false;
	}

	protected static void deleteSessionV3() {
		if (tmdb != null && tmdb.getSessionId() != null) {
			tmdb.authentication().deleteSession(tmdb.getSessionId());
		}
	}

	protected static void assertParsedObject(Object parsed) {
		assertTrue(compare(tmdb.getLastBody(), parsed), "Parsed data missing something");
	}

	protected static boolean compare(String source, Object parsed) {
		JsonElement j1 = GSON.fromJson(source, JsonElement.class);
		//remove nulls
		j1 = GSON.toJsonTree(j1);
		JsonElement j2 = GSON.toJsonTree(parsed);
		if (!j1.equals(j2)) {
			compare(j1, j2, "$");
			System.out.println("received :");
			System.out.println(j1.toString());
			System.out.println("parsed :");
			System.out.println(j2.toString());
			return false;
		}
		return true;
	}

	private static void compare(JsonElement j1, JsonElement j2, String identifier) {
		if (j1.isJsonObject()) {
			if (!j2.isJsonObject()) {
				System.out.println(identifier + " is an object but parsed value is not.");
			} else if (!j1.equals(j2)) {
				compare(j1.getAsJsonObject(), j2.getAsJsonObject(), identifier);
			}
		} else if (j1.isJsonArray()) {
			if (!j2.isJsonArray()) {
				System.out.println(identifier + " is an array but parsed value is not.");
			} else if (!j1.equals(j2)) {
				compare(j1.getAsJsonArray(), j2.getAsJsonArray(), identifier);
			}
		} else if (j1.isJsonPrimitive()) {
			if (!j2.isJsonPrimitive()) {
				System.out.println(identifier + " is a primitive but parsed value is not.");
			} else if (!j1.equals(j2)) {
				System.out.println(identifier + " is a primitive not equals in parsed value.");
			}
		}
	}

	private static void compare(JsonObject j1, JsonObject j2, String identifier) {
		for (String key : j1.keySet()) {
			if (!j2.has(key)) {
				System.out.println(identifier + "." + key + " was not found in parsed value.");
			} else if (!j1.get(key).equals(j2.get(key))) {
				compare(j1.get(key), j2.get(key), identifier + "." + key);
			}
		}
	}

	private static void compare(JsonArray j1, JsonArray j2, String identifier) {
		if (j1.size() != j2.size()) {
			System.out.println(identifier + " array size not equals in parsed value.");
			return;
		}
		for (int i = 0; i < j1.size(); i++) {
			if (!j1.get(i).equals(j2.get(i))) {
				compare(j1.get(i), j2.get(i), identifier + "[" + i + "]");
			}
		}
	}

}
