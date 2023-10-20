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
package com.universalmediaserver.tmdbapi.schema.tv.episode;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Episode Short Schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeShortSchema extends TvEpisodeBaseSchema {

	@SerializedName("air_date")
	private String airDate;
	@SerializedName("name")
	private String name;
	@SerializedName("overview")
	private String overview;
	@SerializedName("production_code")
	private String productionCode;
	@SerializedName("runtime")
	private Long runtime;
	@SerializedName("still_path")
	private String stillPath;
	@SerializedName("vote_average")
	private Double voteAverage;
	@SerializedName("vote_count")
	private Long voteCount;

	public String getAirDate() {
		return airDate;
	}

	public String getName() {
		return name;
	}

	public String getOverview() {
		return overview;
	}

	public String getProductionCode() {
		return productionCode;
	}

	public Long getRuntime() {
		return runtime;
	}

	public String getStillPath() {
		return stillPath;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public void setAirDate(String value) {
		this.airDate = value;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setOverview(String value) {
		this.overview = value;
	}

	public void setProductionCode(String value) {
		this.productionCode = value;
	}

	public void setRuntime(Long value) {
		this.runtime = value;
	}

	public void setStillPath(String value) {
		this.stillPath = value;
	}

	public void setVoteAverage(Double value) {
		this.voteAverage = value;
	}

	public void setVoteCount(Long value) {
		this.voteCount = value;
	}

}
