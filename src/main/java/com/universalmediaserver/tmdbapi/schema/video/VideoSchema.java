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
package com.universalmediaserver.tmdbapi.schema.video;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.StringIdNameSchema;

/**
 * TMDb Video Schema.
 *
 * @author SurfaceS
 */
public class VideoSchema extends StringIdNameSchema {

	@SerializedName("iso_639_1")
	private String iso639Part1;
	@SerializedName("iso_3166_1")
	private String iso3166Part1;
	@SerializedName("key")
	private String key;
	@SerializedName("official")
	private Boolean official;
	@SerializedName("published_at")
	private String publishedAt;
	@SerializedName("site")
	private String site;
	@SerializedName("size")
	private Long size;
	@SerializedName("type")
	private String type;

	public String getIso639Part1() {
		return iso639Part1;
	}

	public String getIso3166Part1() {
		return iso3166Part1;
	}

	public String getKey() {
		return key;
	}

	public Boolean getOfficial() {
		return official;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public String getSite() {
		return site;
	}

	public Long getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	public void setIso639Part1(String value) {
		this.iso639Part1 = value;
	}

	public void setIso3166Part1(String value) {
		this.iso3166Part1 = value;
	}

	public void setKey(String value) {
		this.key = value;
	}

	public void setOfficial(Boolean value) {
		this.official = value;
	}

	public void setPublishedAt(String value) {
		this.publishedAt = value;
	}

	public void setSite(String value) {
		this.site = value;
	}

	public void setSize(Long value) {
		this.size = value;
	}

	public void setType(String value) {
		this.type = value;
	}

}
