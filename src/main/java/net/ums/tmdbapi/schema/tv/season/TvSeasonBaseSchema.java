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
package net.ums.tmdbapi.schema.tv.season;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Season Base Schema.
 *
 * @author SurfaceS
 */
public class TvSeasonBaseSchema extends IntegerIdNameSchema {

	@SerializedName("air_date")
	private String airDate;
	@SerializedName("overview")
	private String overview;
	@SerializedName("poster_path")
	private String posterPath;
	@SerializedName("season_number")
	private Long seasonNumber;
	@SerializedName("vote_average")
	private Double voteAverage;

	public String getAirDate() {
		return airDate;
	}

	public String getOverview() {
		return overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Long getSeasonNumber() {
		return seasonNumber;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public void setAirDate(String value) {
		this.airDate = value;
	}

	public void setOverview(String value) {
		this.overview = value;
	}

	public void setPosterPath(String value) {
		this.posterPath = value;
	}

	public void setSeasonNumber(Long value) {
		this.seasonNumber = value;
	}

	public void setVoteAverage(Double value) {
		this.voteAverage = value;
	}

}
