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
package net.ums.tmdbapi.endpoint.auth;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.StatusSchema;
import net.ums.tmdbapi.schema.auth.AuthAccessTokenSchema;
import net.ums.tmdbapi.schema.auth.AuthRequestTokenSchema;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Auth endpoint (V4). User Authorization.
 *
 * @author SurfaceS
 */
public class AuthEndpoint extends Endpoint {

	private static final String AUTHENTICATION_ENDPOINT = V4_ENDPOINT + "auth/";
	private static final String REQUEST_TOKEN_ENDPOINT = AUTHENTICATION_ENDPOINT + "request_token";
	private static final String ACCESS_TOKEN_ENDPOINT = AUTHENTICATION_ENDPOINT + "access_token";

	public AuthEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Create a temporary request token that can be used to validate a TMDB user
	 * login. This method generates a new request token that you can ask a user
	 * to approve. This is the first step in getting permission from a user to
	 * read and write data on their behalf.
	 *
	 * @return Request Token
	 */
	public AuthRequestTokenSchema createRequestToken() {
		return createRequestToken(null);
	}

	/**
	 * Create a temporary request token that can be used to validate a TMDB user
	 * login. This method generates a new request token that you can ask a user
	 * to approve. This is the first step in getting permission from a user to
	 * read and write data on their behalf.
	 *
	 * Note that there is an optional body you can post alongside this request
	 * to set a redirect URL or callback that will be executed once a request
	 * token has been approved on TMDb.
	 *
	 * @return Request Token
	 */
	public AuthRequestTokenSchema createRequestToken(String redirectTo) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("redirect_to", redirectTo);
		return tmdbClient.post(REQUEST_TOKEN_ENDPOINT, AuthRequestTokenSchema.class, null, jsonObject.toString());
	}

	/**
	 * Create Access Token.
	 * <p>
	 * This method will finish the user authentication flow and issue an
	 * official user access token.
	 * <p>
	 * The request token in this request is sent along as part of the POST body.
	 * <p>
	 * You should still use your standard API read access token for
	 * authenticating this request.
	 *
	 * @return Request Token
	 */
	public AuthAccessTokenSchema createAccessToken(String requestToken) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("request_token", requestToken);
		return tmdbClient.post(ACCESS_TOKEN_ENDPOINT, AuthAccessTokenSchema.class, null, jsonObject.toString());
	}

	/**
	 * Delete Access Token.
	 * <br>
	 * This method gives your users the ability to revoke access token.
	 *
	 * @return Status
	 */
	public StatusSchema deleteAccessToken(String accessToken) {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_ACCESS_TOKEN, accessToken);
		return tmdbClient.delete(ACCESS_TOKEN_ENDPOINT, StatusSchema.class, null);
	}

}
