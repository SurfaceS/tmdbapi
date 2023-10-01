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
package net.ums.tmdbapi.schema.person;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Person External Ids Schema.
 *
 * @author SurfaceS
 */
public class PersonExternalIdsSchema {

	@SerializedName("facebook_id")
	private String facebookId;
	@SerializedName("freebase_id")
	private String freebaseId;
	@SerializedName("freebase_mid")
	private String freebaseMid;
	@SerializedName("imdb_id")
	private String imdbId;
	@SerializedName("instagram_id")
	private String instagramId;
	@SerializedName("tvrage_id")
	private Long tvrageId;
	@SerializedName("twitter_id")
	private String twitterId;
	@SerializedName("wikidata_id")
	private String wikidataId;

	public String getFreebaseId() {
		return freebaseId;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public String getFreebaseMid() {
		return freebaseMid;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getInstagramId() {
		return instagramId;
	}

	public Long getTvrageId() {
		return tvrageId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public String getWikidataId() {
		return wikidataId;
	}

	public void setFacebookId(String value) {
		this.facebookId = value;
	}

	public void setFreebaseId(String value) {
		this.freebaseId = value;
	}

	public void setFreebaseMid(String value) {
		this.freebaseMid = value;
	}

	public void setImdbId(String value) {
		this.imdbId = value;
	}

	public void setInstagramId(String value) {
		this.instagramId = value;
	}

	public void setTvrageId(Long value) {
		this.tvrageId = value;
	}

	public void setTwitterId(String value) {
		this.twitterId = value;
	}

	public void setWikidataId(String value) {
		this.wikidataId = value;
	}

}
