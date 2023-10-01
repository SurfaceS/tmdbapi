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
package net.ums.tmdbapi.schema.find;

import net.ums.tmdbapi.schema.movie.MovieTypedSchema;
import net.ums.tmdbapi.schema.person.PersonTypedSchema;
import net.ums.tmdbapi.schema.tv.TvTypedSchema;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeTypedSchema;
import net.ums.tmdbapi.schema.tv.season.TvSeasonTypedSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Find Schema.
 *
 * @author SurfaceS
 */
public class FindSchema {

	@SerializedName("movie_results")
	private List<MovieTypedSchema> movieResults;
	@SerializedName("person_results")
	private List<PersonTypedSchema> personResults;
	@SerializedName("tv_results")
	private List<TvTypedSchema> tvResults;
	@SerializedName("tv_episode_results")
	private List<TvEpisodeTypedSchema> tvEpisodeResults;
	@SerializedName("tv_season_results")
	private List<TvSeasonTypedSchema> tvSeasonResults;

	public List<MovieTypedSchema> getMovieResults() {
		return movieResults;
	}

	public List<PersonTypedSchema> getPersonResults() {
		return personResults;
	}

	public List<TvTypedSchema> getTvResults() {
		return tvResults;
	}

	public List<TvEpisodeTypedSchema> getTvEpisodeResults() {
		return tvEpisodeResults;
	}

	public List<TvSeasonTypedSchema> getTvSeasonResults() {
		return tvSeasonResults;
	}

	public void setMovieResults(List<MovieTypedSchema> value) {
		this.movieResults = value;
	}

	public void setPersonResults(List<PersonTypedSchema> value) {
		this.personResults = value;
	}

	public void setTvResults(List<TvTypedSchema> value) {
		this.tvResults = value;
	}

	public void setTvEpisodeResults(List<TvEpisodeTypedSchema> value) {
		this.tvEpisodeResults = value;
	}

	public void setTvSeasonResults(List<TvSeasonTypedSchema> value) {
		this.tvSeasonResults = value;
	}

}
