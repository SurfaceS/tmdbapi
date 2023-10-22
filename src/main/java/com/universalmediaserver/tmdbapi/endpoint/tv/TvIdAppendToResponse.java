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
package com.universalmediaserver.tmdbapi.endpoint.tv;

/**
 * The supported Append To Response for TV show.
 *
 * @author SurfaceS
 */
public enum TvIdAppendToResponse {

	ACCOUNT_STATES("account_states"),
	AGGREGATE_CREDITS("aggregate_credits"),
	ALTERNATIVE_TITLES("alternative_titles"),
	CHANGES("changes"),
	CONTENT_RATINGS("content_ratings"),
	CREDITS("credits"),
	EPISODE_GROUPS("episode_groups"),
	EXTERNAL_IDS("external_ids"),
	IMAGES("images"),
	KEYWORDS("keywords"),
	RECOMMENDATIONS("recommendations"),
	REVIEWS("reviews"),
	SCREENED_THEATRICALLY("screened_theatrically"),
	SIMILAR("similar"),
	TRANSLATIONS("translations"),
	VIDEOS("videos"),
	WATCH_PROVIDERS("watch/providers");

	final String value;

	TvIdAppendToResponse(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
