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
package com.universalmediaserver.tmdbapi.endpoint.authentication;

import com.google.gson.JsonObject;
import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.SuccessSchema;
import com.universalmediaserver.tmdbapi.schema.authentication.AuthenticationGuestSessionSchema;
import com.universalmediaserver.tmdbapi.schema.authentication.AuthenticationRequestTokenSchema;
import com.universalmediaserver.tmdbapi.schema.authentication.AuthenticationSessionSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Authentication endpoint. User authentication.
 *
 * @author SurfaceS
 */
public class AuthenticationEndpoint extends Endpoint {

	private static final String V3_AUTHENTICATION_ENDPOINT = V3_ENDPOINT + "authentication/";
	private static final String V3_AUTHENTICATION_GUEST_SESSION_ENDPOINT = V3_AUTHENTICATION_ENDPOINT + "guest_session";
	private static final String V3_AUTHENTICATION_GUEST_SESSION_NEW_ENDPOINT = V3_AUTHENTICATION_GUEST_SESSION_ENDPOINT + "/new";
	private static final String V3_AUTHENTICATION_TOKEN_ENDPOINT = V3_AUTHENTICATION_ENDPOINT + "token";
	private static final String V3_AUTHENTICATION_TOKEN_VALIDATE_WITH_LOGIN_ENDPOINT = V3_AUTHENTICATION_TOKEN_ENDPOINT + "/validate_with_login";
	private static final String V3_AUTHENTICATION_TOKEN_NEW_ENDPOINT = V3_AUTHENTICATION_TOKEN_ENDPOINT + "/new";
	private static final String V3_AUTHENTICATION_SESSION_ENDPOINT = V3_AUTHENTICATION_ENDPOINT + "session";
	private static final String V3_AUTHENTICATION_SESSION_NEW_ENDPOINT = V3_AUTHENTICATION_SESSION_ENDPOINT + "/new";
	private static final String V3_AUTHENTICATION_SESSION_CONVERT_4_ENDPOINT = V3_AUTHENTICATION_SESSION_ENDPOINT + "/convert/4";

	public AuthenticationEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Create a new guest session. Guest sessions are a type of session that
	 * will let a user rate movies and TV shows but not require them to have a
	 * TMDB user account.
	 *
	 * Please note, you should only generate a single guest session per user (or
	 * device) as you will be able to attach the ratings to a TMDB user account
	 * in the future. There is also IP limits in place so you should always make
	 * sure it's the end user doing the guest session actions.
	 *
	 * If a guest session is not used for the first time within 24 hours, it
	 * will be automatically deleted.
	 *
	 * @return Guest Session
	 */
	public AuthenticationGuestSessionSchema createGuestSession() {
		return tmdbClient.get(V3_AUTHENTICATION_GUEST_SESSION_NEW_ENDPOINT, AuthenticationGuestSessionSchema.class, null);
	}

	/**
	 * Create a temporary request token that can be used to validate a TMDB user
	 * login. This token will auto expire after 60 minutes if it's not used.
	 *
	 * @return Request Token
	 */
	public AuthenticationRequestTokenSchema createRequestToken() {
		return tmdbClient.get(V3_AUTHENTICATION_TOKEN_NEW_ENDPOINT, AuthenticationRequestTokenSchema.class, null);
	}

	/**
	 * Create a session from V4 user access token. Use this method to create a
	 * v3 session ID if you already have a valid v4 user access token. The v4
	 * token needs to be authenticated by the user. Your standard "read token"
	 * will not validate to create a session ID.
	 *
	 * @return Session
	 */
	public AuthenticationSessionSchema convertSession(String accessToken) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("access_token", accessToken);
		AuthenticationSessionSchema result = tmdbClient.post(V3_AUTHENTICATION_SESSION_CONVERT_4_ENDPOINT, AuthenticationSessionSchema.class, null, jsonObject.toString());
		if (result != null && result.getSuccess() && result.getSessionId() != null) {
			tmdbClient.setSessionId(result.getSessionId());
		}
		return result;
	}

	/**
	 * Create a session. You can use this method to create a fully valid session
	 * ID once a user has validated the request token.
	 *
	 * Please note, the preferred method of validating a request token is to
	 * have a user authenticate the request via the TMDB website.
	 *
	 * Not all applications have access to a web view so you can use the method
	 * with username and password as a substitute.
	 *
	 * @return Session
	 */
	public AuthenticationSessionSchema createSession(String requestToken) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("request_token", requestToken);
		AuthenticationSessionSchema result = tmdbClient.post(V3_AUTHENTICATION_SESSION_NEW_ENDPOINT, AuthenticationSessionSchema.class, null, jsonObject.toString());
		if (result != null && result.getSuccess() && result.getSessionId() != null) {
			tmdbClient.setSessionId(result.getSessionId());
		}
		return result;
	}

	/**
	 * Delete a session. If you would like to delete (or "logout") from a
	 * session, call this method with a valid session ID.
	 *
	 * @return Success
	 */
	public SuccessSchema deleteSession(String sessionId) {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, sessionId);
		SuccessSchema result = tmdbClient.delete(V3_AUTHENTICATION_SESSION_ENDPOINT, SuccessSchema.class, query);
		if (result != null && result.getSuccess()) {
			tmdbClient.setSessionId(null);
		}
		return result;
	}

	/**
	 * Create a session. This method allows an application to validate a request
	 * token by entering a username and password.
	 *
	 * This method is a substitute when the applciation do not have access to a
	 * web view to validate the request token.
	 *
	 * @return Request Token validated
	 */
	public AuthenticationRequestTokenSchema validateTokenWithLogin(String requestToken, String username, String password) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("request_token", requestToken);
		jsonObject.addProperty("username", username);
		jsonObject.addProperty("password", password);
		return tmdbClient.post(V3_AUTHENTICATION_TOKEN_VALIDATE_WITH_LOGIN_ENDPOINT, AuthenticationRequestTokenSchema.class, null, jsonObject.toString());
	}

}
