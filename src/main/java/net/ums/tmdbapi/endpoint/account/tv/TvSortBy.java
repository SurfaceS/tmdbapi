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
package net.ums.tmdbapi.endpoint.account.tv;

/**
 * The supported sort option for TV show.
 *
 * @author SurfaceS
 */
public enum TvSortBy {

	FIRST_AIR_DATE_ASCENDING("first_air_date.asc"),
	FIRST_AIR_DATE_DESCENDING("first_air_date.desc"),
	NAME_ASCENDING("name.asc"),
	NAME_DESCENDING("name.desc"),
	VOTE_AVERAGE_ASCENDING("vote_average.asc"),
	VOTE_AVERAGE_DESCENDING("vote_average.desc");

	final String value;

	TvSortBy(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
