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

import net.ums.tmdbapi.endpoint.account.AccountIdV4Endpoint;
import net.ums.tmdbapi.endpoint.account.AccountV3Endpoint;
import net.ums.tmdbapi.endpoint.account.AccountV4Endpoint;
import net.ums.tmdbapi.endpoint.auth.AuthEndpoint;
import net.ums.tmdbapi.endpoint.authentication.AuthenticationEndpoint;
import net.ums.tmdbapi.endpoint.certification.CertificationEndpoint;
import net.ums.tmdbapi.endpoint.collection.CollectionEndpoint;
import net.ums.tmdbapi.endpoint.company.CompanyEndpoint;
import net.ums.tmdbapi.endpoint.configuration.ConfigurationEndpoint;
import net.ums.tmdbapi.endpoint.credit.CreditEndpoint;
import net.ums.tmdbapi.endpoint.find.FindEndpoint;
import net.ums.tmdbapi.endpoint.find.FindExternalSource;
import net.ums.tmdbapi.endpoint.genre.GenreEndpoint;
import net.ums.tmdbapi.endpoint.keyword.KeywordEndpoint;
import net.ums.tmdbapi.endpoint.list.ListIdV4Endpoint;
import net.ums.tmdbapi.endpoint.list.ListV4Endpoint;
import net.ums.tmdbapi.endpoint.movie.MovieEndpoint;
import net.ums.tmdbapi.endpoint.movie.MovieIdEndpoint;
import net.ums.tmdbapi.endpoint.network.NetworkEndpoint;
import net.ums.tmdbapi.endpoint.person.PersonEndpoint;
import net.ums.tmdbapi.endpoint.person.PersonIdEndpoint;
import net.ums.tmdbapi.endpoint.review.ReviewEndpoint;
import net.ums.tmdbapi.endpoint.search.SearchEndpoint;
import net.ums.tmdbapi.endpoint.trending.TrendingEndpoint;
import net.ums.tmdbapi.endpoint.trending.TrendingTimeWindow;
import net.ums.tmdbapi.endpoint.tv.TvEndpoint;
import net.ums.tmdbapi.endpoint.tv.TvIdEndpoint;
import net.ums.tmdbapi.endpoint.tv.episode.TvEpisodeIdEndpoint;
import net.ums.tmdbapi.endpoint.tv.episode.TvEpisodeTvIdEndpoint;
import net.ums.tmdbapi.endpoint.tv.episodegroup.TvEpisodeGroupEndpoint;
import net.ums.tmdbapi.endpoint.tv.season.TvSeasonIdEndpoint;
import net.ums.tmdbapi.endpoint.tv.season.TvSeasonTvIdEndpoint;
import net.ums.tmdbapi.endpoint.watchproviders.WatchProvidersEndpoint;
import net.ums.tmdbapi.schema.StatusSchema;
import net.ums.tmdbapi.schema.media.MediaTypeInterface;
import net.ums.tmdbapi.schema.media.MediaTypeInterfaceDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * Create a new TMDb client.
 *
 * @author SurfaceS
 */
public class TMDbClient {

	private static final String DEFAULT_BASE_URL = "https://api.themoviedb.org";
	private static final Gson GSON = new GsonBuilder()
			.registerTypeAdapter(MediaTypeInterface.class, new MediaTypeInterfaceDeserializer())
			.create();

	private String apiKey;
	private String accessToken;
	private String baseUrl;
	private String defaultLanguage;
	private String readToken;
	private String guestSessionId;
	private String sessionId;
	/**
	 * used for testing json members
	 */
	private String lastBody;
	private boolean testing;

	/**
	 * Create a new TMDb client.
	 *
	 * This profile can be used if an access token (v4) is set after. TMDb API
	 * require either api key (v3), read token(v4) or access token (v4).
	 */
	public TMDbClient() {
		this(DEFAULT_BASE_URL, null);
	}

	/**
	 * Create a new TMDb client.
	 *
	 * @param apiKeyOrReadToken api key (v3) or read token (v4)
	 */
	public TMDbClient(String apiKeyOrReadToken) {
		this(DEFAULT_BASE_URL, apiKeyOrReadToken);
	}

	/**
	 * Create a new TMDb client.
	 *
	 * @param baseUrl the base api url
	 * @param apiKeyOrReadToken api key (v3) or read token (v4)
	 */
	public TMDbClient(String baseUrl, String apiKeyOrReadToken) {
		this.baseUrl = baseUrl;
		if (apiKeyOrReadToken != null && apiKeyOrReadToken.length() > 32) {
			this.readToken = apiKeyOrReadToken;
		} else {
			this.apiKey = apiKeyOrReadToken;
		}
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getDefaultLanguage() {
		return defaultLanguage;
	}

	public String getGuestSessionId() {
		return guestSessionId;
	}

	public String getLastBody() {
		return lastBody;
	}

	public String getReadToken() {
		return readToken;
	}

	public String getSessionId() {
		return sessionId;
	}

	public int getVersion() {
		return readToken != null ? 4 : 3;
	}

	public void setAccessToken(String value) {
		this.accessToken = value;
	}

	public void setApiKey(String value) {
		this.apiKey = value;
	}

	public void setBaseUrl(String value) {
		this.baseUrl = value;
	}

	public void setDefaultLanguage(String value) {
		this.defaultLanguage = value;
	}

	public void setGuestSessionId(String value) {
		this.guestSessionId = value;
	}

	public void setReadToken(String value) {
		this.readToken = value;
	}

	public void setSessionId(String value) {
		this.sessionId = value;
	}

	public void setTesting(boolean value) {
		this.testing = value;
	}

	/**
	 * Get User account endpoint (V3).
	 *
	 * @return Account endpoint.
	 */
	public AccountV3Endpoint account() {
		return new AccountV3Endpoint(this);
	}

	/**
	 * Get User account endpoint (V4).
	 *
	 * @return Account V4 endpoint.
	 */
	public AccountV4Endpoint accountV4() {
		return new AccountV4Endpoint(this);
	}

	/**
	 * Get User account endpoint (V4).
	 *
	 * @return Account V4 endpoint.
	 */
	public AccountIdV4Endpoint accountV4(String accountId) {
		return new AccountIdV4Endpoint(this, accountId);
	}

	/**
	 * Get User Authorization endpoint (V4).
	 *
	 * @return Auth endpoint.
	 */
	public AuthEndpoint auth() {
		return new AuthEndpoint(this);
	}

	/**
	 * Get Authentication endpoint (V3).
	 *
	 * @return Authentication endpoint.
	 */
	public AuthenticationEndpoint authentication() {
		return new AuthenticationEndpoint(this);
	}

	/**
	 * Get Certification endpoint.
	 *
	 * @return Certification endpoint.
	 */
	public CertificationEndpoint certification() {
		return new CertificationEndpoint(this);
	}

	/**
	 * Get Collection endpoint.
	 *
	 * @return Collection endpoint.
	 */
	public CollectionEndpoint collection(long collectionId) {
		return new CollectionEndpoint(this, collectionId);
	}

	/**
	 * Get company endpoint.
	 *
	 * @return Company endpoint.
	 */
	public CompanyEndpoint company(long companyId) {
		return new CompanyEndpoint(this, companyId);
	}

	/**
	 * Get credit endpoint.
	 *
	 * @return Credit endpoint.
	 */
	public CreditEndpoint credit(String creditId) {
		return new CreditEndpoint(this, creditId);
	}

	/**
	 * Get configuration endpoint.
	 *
	 * @return Configuration endpoint.
	 */
	public ConfigurationEndpoint configuration() {
		return new ConfigurationEndpoint(this);
	}

	/**
	 * Get Find endpoint.
	 *
	 * @return Find endpoint.
	 */
	public FindEndpoint find(String externalId, FindExternalSource externalSource) {
		return new FindEndpoint(this, externalId, externalSource);
	}

	/**
	 * Get genre endpoint.
	 *
	 * @return Genre endpoint.
	 */
	public GenreEndpoint genre() {
		return new GenreEndpoint(this);
	}

	/**
	 * Get keyword request by tvId.
	 *
	 * @return Keyword request.
	 */
	public KeywordEndpoint keyword(long keywordId) {
		return new KeywordEndpoint(this, keywordId);
	}

	/**
	 * Get List endpoint (V4).
	 *
	 * @return List endpoint.
	 */
	public ListV4Endpoint listV4(String name, String iso639Part1) {
		return new ListV4Endpoint(this, name, iso639Part1);
	}

	/**
	 * Get List endpoint (V4).
	 *
	 * @return List endpoint.
	 */
	public ListIdV4Endpoint listV4(long listId) {
		return new ListIdV4Endpoint(this, listId);
	}

	/**
	 * Get Movie endpoint.
	 *
	 * @return Movie endpoint.
	 */
	public MovieEndpoint movie() {
		return new MovieEndpoint(this);
	}

	/**
	 * Get Movie request by tvId.
	 *
	 * @return Movie request.
	 */
	public MovieIdEndpoint movie(long movieId) {
		return new MovieIdEndpoint(this, movieId);
	}

	/**
	 * Get network request by tvId.
	 *
	 * @return Network request.
	 */
	public NetworkEndpoint network(long networkId) {
		return new NetworkEndpoint(this, networkId);
	}

	/**
	 * Get person endpoint.
	 *
	 * @return Person endpoint.
	 */
	public PersonEndpoint person() {
		return new PersonEndpoint(this);
	}

	/**
	 * Get person request.
	 *
	 * @return Person request.
	 */
	public PersonIdEndpoint person(long personId) {
		return new PersonIdEndpoint(this, personId);
	}

	/**
	 * Get review request.
	 *
	 * @return Review request.
	 */
	public ReviewEndpoint review(String reviewId) {
		return new ReviewEndpoint(this, reviewId);
	}

	/**
	 * Get Search request by searchQuery.
	 *
	 * @return Search request.
	 */
	public SearchEndpoint search(String searchQuery) {
		return new SearchEndpoint(this, searchQuery);
	}

	/**
	 * Get trending request by timeWindow.
	 *
	 * @return Trending request.
	 */
	public TrendingEndpoint trending(TrendingTimeWindow timeWindow) {
		return new TrendingEndpoint(this, timeWindow);
	}

	/**
	 * Get TV show endpoint.
	 *
	 * @return TV show endpoint.
	 */
	public TvEndpoint tv() {
		return new TvEndpoint(this);
	}

	/**
	 * Get TV episode request by tvId.
	 *
	 * @return TV Episode request.
	 */
	public TvIdEndpoint tv(long tvId) {
		return new TvIdEndpoint(this, tvId);
	}

	/**
	 * Get TV episode request by episodeId.
	 *
	 * @return TV Episode request.
	 */
	public TvEpisodeIdEndpoint tvEpisode(long episodeId) {
		return new TvEpisodeIdEndpoint(this, episodeId);
	}

	/**
	 * Get TV episode request by tvId.
	 *
	 * @return TV Episode request.
	 */
	public TvEpisodeTvIdEndpoint tvEpisode(long tvId, long seasonNumber, long episodeNumber) {
		return new TvEpisodeTvIdEndpoint(this, tvId, seasonNumber, episodeNumber);
	}

	/**
	 * Get TV episode group request by tvId.
	 *
	 * @return TV Episode group request.
	 */
	public TvEpisodeGroupEndpoint tvEpisodeGroup(String episodeGroupId) {
		return new TvEpisodeGroupEndpoint(this, episodeGroupId);
	}

	/**
	 * Get TV season endpoint by tvId.
	 *
	 * @return TV Season endpoint.
	 */
	public TvSeasonTvIdEndpoint tvSeason(long tvId, long seasonNumber) {
		return new TvSeasonTvIdEndpoint(this, tvId, seasonNumber);
	}

	/**
	 * Get TV season endpoint by seasonId.
	 *
	 * @return TV Season endpoint.
	 */
	public TvSeasonIdEndpoint tvSeason(long seasonId) {
		return new TvSeasonIdEndpoint(this, seasonId);
	}

	/**
	 * Get TV season endpoint by seasonId.
	 *
	 * @return TV Season endpoint.
	 */
	public WatchProvidersEndpoint watchProviders() {
		return new WatchProvidersEndpoint(this);
	}

	public <T> T get(String endpoint, Class<T> resultClass, Map<String, String> query) {
		try {
			HttpRequest request = getBuilder(endpoint, query).GET().build();
			return getResult(request, resultClass);
		} catch (TMDbException ex) {
			Logger.getLogger(TMDbClient.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
		}
		return null;
	}

	public <T> T post(String endpoint, Class<T> resultClass, Map<String, String> query, String postData) {
		try {
			HttpRequest request = getBuilder(endpoint, query).POST(BodyPublishers.ofString(postData)).build();
			return getResult(request, resultClass);
		} catch (TMDbException ex) {
			Logger.getLogger(TMDbClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public <T> T put(String endpoint, Class<T> resultClass, Map<String, String> query, String postData) {
		try {
			HttpRequest request = getBuilder(endpoint, query).PUT(BodyPublishers.ofString(postData)).build();
			return getResult(request, resultClass);
		} catch (TMDbException ex) {
			Logger.getLogger(TMDbClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public <T> T delete(String endpoint, Class<T> resultClass, Map<String, String> query) {
		try {
			HttpRequest request = getBuilder(endpoint, query).DELETE().build();
			return getResult(request, resultClass);
		} catch (TMDbException ex) {
			Logger.getLogger(TMDbClient.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	private <T> T getResult(HttpRequest request, Class<T> resultClass) throws TMDbException {
		try {
			HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String body = response.body();
			if (testing) {
				lastBody = body;
			}
			if (response.statusCode() >= 200 && response.statusCode() < 300) {
				return GSON.fromJson(body, resultClass);
			} else {
				StatusSchema status = GSON.fromJson(body, StatusSchema.class);
				throw new TMDbException(response.statusCode() + ": TMDb status" + status.getStatusCode() + ": " + status.getStatusMessage());
			}
		} catch (IOException ex) {
			throw new TMDbException("Error while sending the request", ex);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		return null;
	}

	private HttpRequest.Builder getBuilder(String endpoint, Map<String, String> query) throws TMDbException {
		StringBuilder urlBuilder = new StringBuilder();
		if (query == null) {
			query = new HashMap<>();
		}
		//api key is needed everywhere
		if (!query.containsKey("api_key")) {
			query.put("api_key", apiKey);
		}
		for (Entry<String, String> param : query.entrySet()) {
			if (!StringUtils.isAllBlank(param.getValue())) {
				urlBuilder.append(urlBuilder.isEmpty() ? "?" : "&");
				String key = param.getKey();
				String value = URLEncoder.encode(param.getValue(), StandardCharsets.UTF_8);
				urlBuilder.append(key).append("=").append(value);
			}
		}
		urlBuilder.insert(0, endpoint);
		URL contextUrl;
		try {
			contextUrl = new URL(baseUrl);
		} catch (MalformedURLException ex) {
			throw new TMDbException("Base url '" + baseUrl + "' malformed", ex);
		}
		URI requestUri;
		try {
			URL requestUrl = new URL(contextUrl, urlBuilder.toString());
			requestUri = requestUrl.toURI();
		} catch (MalformedURLException | URISyntaxException ex) {
			throw new TMDbException("Request url malformed", ex);
		}
		HttpRequest.Builder builder = HttpRequest.newBuilder(requestUri)
				.setHeader("Content-Type", "application/json;charset=utf-8")
				.setHeader("accept", "application/json");
		if (accessToken != null) {
			builder.setHeader("Authorization", "Bearer " + accessToken);
		} else if (readToken != null) {
			builder.setHeader("Authorization", "Bearer " + readToken);
		}
		return builder;
	}

}
