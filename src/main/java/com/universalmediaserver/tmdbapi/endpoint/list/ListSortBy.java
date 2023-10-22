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
package com.universalmediaserver.tmdbapi.endpoint.list;

/**
 * The supported sort option for List.
 *
 * @author SurfaceS
 */
public enum ListSortBy {

	ORIGINAL_ORDER_ASCENDING("original_order.asc"),
	ORIGINAL_ORDER_DESCENDING("original_order.desc"),
	PRIMARY_RELEASE_DATE_ASCENDING("primary_release_date.asc"),
	PRIMARY_RELEASE_DATE_DESCENDING("primary_release_date.desc"),
	TITLE_ASCENDING("title.asc"),
	TITLE_DESCENDING("title.desc"),
	VOTE_AVERAGE_ASCENDING("vote_average.asc"),
	VOTE_AVERAGE_DESCENDING("vote_average.desc");

	final String value;

	ListSortBy(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
