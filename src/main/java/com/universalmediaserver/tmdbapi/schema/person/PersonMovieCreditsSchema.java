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
package com.universalmediaserver.tmdbapi.schema.person;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.movie.MovieJobCreditedSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieRoleCreditedSchema;
import java.util.List;

/**
 * TMDb Person Movie Credits Schema.
 *
 * @author SurfaceS
 */
public class PersonMovieCreditsSchema {

	@SerializedName("cast")
	private List<MovieRoleCreditedSchema> cast;
	@SerializedName("crew")
	private List<MovieJobCreditedSchema> crew;

	public List<MovieRoleCreditedSchema> getCast() {
		return cast;
	}

	public List<MovieJobCreditedSchema> getCrew() {
		return crew;
	}

	public void setCast(List<MovieRoleCreditedSchema> value) {
		this.cast = value;
	}

	public void setCrew(List<MovieJobCreditedSchema> value) {
		this.crew = value;
	}

}
