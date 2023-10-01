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
package net.ums.tmdbapi.endpoint.person;

/**
 * The supported Append To Response for movie.
 *
 * @author SurfaceS
 */
public enum PersonIdAppendToResponse {

	CHANGES("changes"),
	COMBINED_CREDITS("combined_credits"),
	EXTERNAL_IDS("external_ids"),
	IMAGES("images"),
	MOVIE_CREDITS("movie_credits"),
	TAGGED_IMAGES("tagged_images"),
	TRANSLATIONS("translations"),
	TV_CREDITS("tv_credits");

	final String value;

	PersonIdAppendToResponse(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
