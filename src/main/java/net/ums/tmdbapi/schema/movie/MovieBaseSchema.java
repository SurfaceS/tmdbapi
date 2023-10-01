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
package net.ums.tmdbapi.schema.movie;

import net.ums.tmdbapi.schema.IntegerIdSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Movie Base Schema.
 *
 * @author SurfaceS
 */
public class MovieBaseSchema extends IntegerIdSchema {

	@SerializedName("adult")
	private Boolean adult;
	@SerializedName("backdrop_path")
	private String backdropPath;
	@SerializedName("original_language")
	private String originalLanguage;
	@SerializedName("original_title")
	private String originalTitle;
	@SerializedName("overview")
	private String overview;
	@SerializedName("popularity")
	private Double popularity;
	@SerializedName("poster_path")
	private String posterPath;
	@SerializedName("release_date")
	private String releaseDate;
	@SerializedName("title")
	private String title;
	@SerializedName("video")
	private Boolean video;
	@SerializedName("vote_average")
	private Double voteAverage;
	@SerializedName("vote_count")
	private Long voteCount;

	public boolean getAdult() {
		return adult;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public String getOverview() {
		return overview;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public double getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getTitle() {
		return title;
	}

	public boolean getVideo() {
		return video;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setAdult(Boolean value) {
		this.adult = value;
	}

	public void setBackdropPath(String value) {
		this.backdropPath = value;
	}

	public void setOriginalLanguage(String value) {
		this.originalLanguage = value;
	}

	public void setOriginalTitle(String value) {
		this.originalTitle = value;
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

	public void setReleaseDate(String value) {
		this.releaseDate = value;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public void setVideo(Boolean value) {
		this.video = value;
	}

	public void setVoteAverage(Double value) {
		this.voteAverage = value;
	}

	public void setVoteCount(Long value) {
		this.voteCount = value;
	}

}
