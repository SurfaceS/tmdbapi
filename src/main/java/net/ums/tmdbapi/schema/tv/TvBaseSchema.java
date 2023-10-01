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
package net.ums.tmdbapi.schema.tv;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Tv Base Schema.
 *
 * @author SurfaceS
 */
public class TvBaseSchema extends IntegerIdNameSchema {

	@SerializedName("backdrop_path")
	private String backdropPath;
	@SerializedName("first_air_date")
	private String firstAirDate;
	@SerializedName("original_language")
	private String originalLanguage;
	@SerializedName("original_name")
	private String originalName;
	@SerializedName("origin_country")
	private List<String> originCountry;
	@SerializedName("overview")
	private String overview;
	@SerializedName("popularity")
	private Double popularity;
	@SerializedName("poster_path")
	private String posterPath;
	@SerializedName("vote_average")
	private Double voteAverage;
	@SerializedName("vote_count")
	private Long voteCount;

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getFirstAirDate() {
		return firstAirDate;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalName() {
		return originalName;
	}

	public List<String> getOriginCountry() {
		return originCountry;
	}

	public String getOverview() {
		return overview;
	}

	public double getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setBackdropPath(String value) {
		this.backdropPath = value;
	}

	public void setFirstAirDate(String value) {
		this.firstAirDate = value;
	}

	public void setOriginalLanguage(String value) {
		this.originalLanguage = value;
	}

	public void setOriginalName(String value) {
		this.originalName = value;
	}

	public void setOriginCountry(List<String> value) {
		this.originCountry = value;
	}

	public void setOverview(String value) {
		this.overview = value;
	}

	public void setPopularity(Double value) {
		this.popularity = value;
	}

	public void setPosterPath(String value) {
		this.posterPath = value;
	}

	public void setVoteAverage(Double value) {
		this.voteAverage = value;
	}

	public void setVoteCount(Long value) {
		this.voteCount = value;
	}

}
