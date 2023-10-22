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
package com.universalmediaserver.tmdbapi.endpoint.tv.season;

/**
 * The supported Append To Response for Tv Season.
 *
 * @author SurfaceS
 */
public enum TvSeasonAppendToResponse {
	ACCOUNT_STATES("account_states"),
	AGGREGATE_CREDITS("aggregate_credits"),
	CREDITS("credits"),
	EXTERNAL_IDS("external_ids"),
	IMAGES("images"),
	TRANSLATIONS("translations"),
	VIDEOS("videos");

	final String value;

	TvSeasonAppendToResponse(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
