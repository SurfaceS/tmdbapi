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
package net.ums.tmdbapi.schema.keyword;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import net.ums.tmdbapi.schema.movie.MovieShortResultsSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Keyword Details Schema.
 *
 * @author SurfaceS
 */
public class KeywordDetailsSchema extends IntegerIdNameSchema {

	@SerializedName("movies")
	private MovieShortResultsSchema movies;

	public MovieShortResultsSchema getMovies() {
		return movies;
	}

	public void setMovies(MovieShortResultsSchema value) {
		this.movies = value;
	}

}
