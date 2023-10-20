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
package com.universalmediaserver.tmdbapi.endpoint.tv.episodegroup;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.tv.episodegroups.TvEpisodeGroupsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Tv Episode Group Endpoint.
 *
 * @author SurfaceS
 */
public class TvEpisodeGroupEndpoint extends Endpoint {

	private static final String V3_TV_EPISODE_GROUP_ENDPOINT = V3_ENDPOINT + "tv/episode_group/";

	private final String episodeGroupId;
	private String language;

	public TvEpisodeGroupEndpoint(TMDbClient tmdbClient, String episodeGroupId) {
		super(tmdbClient);
		this.episodeGroupId = episodeGroupId;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public TvEpisodeGroupEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Get the details of a TV episode group.
	 *
	 * Groups support 7 different types which are enumerated as the following:
	 * 1: Original air date 2: Absolute 3: DVD 4: Digital 5: Story arc 6:
	 * Production 7: TV
	 *
	 * @return TV episode group details.
	 */
	public TvEpisodeGroupsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_TV_EPISODE_GROUP_ENDPOINT + episodeGroupId, TvEpisodeGroupsSchema.class, query);
	}

}
