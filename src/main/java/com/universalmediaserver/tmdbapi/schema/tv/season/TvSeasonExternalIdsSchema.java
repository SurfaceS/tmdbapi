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
package com.universalmediaserver.tmdbapi.schema.tv.season;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Season External Ids Schema.
 *
 * @author SurfaceS
 */
public class TvSeasonExternalIdsSchema {

	@SerializedName("freebase_id")
	private String freebaseId;
	@SerializedName("freebase_mid")
	private String freebaseMid;
	@SerializedName("tvdb_id")
	private Long tvdbId;
	@SerializedName("tvrage_id")
	private Long tvrageId;
	@SerializedName("wikidata_id")
	private String wikidataId;

	public String getFreebaseId() {
		return freebaseId;
	}

	public String getFreebaseMid() {
		return freebaseMid;
	}

	public Long getTvdbId() {
		return tvdbId;
	}

	public Long getTvrageId() {
		return tvrageId;
	}

	public String getWikidataId() {
		return wikidataId;
	}

	public void setFreebaseId(String value) {
		this.freebaseId = value;
	}

	public void setFreebaseMid(String value) {
		this.freebaseMid = value;
	}

	public void setTvdbId(Long value) {
		this.tvdbId = value;
	}

	public void setTvrageId(Long value) {
		this.tvrageId = value;
	}

	public void setWikidataId(String value) {
		this.wikidataId = value;
	}

}
