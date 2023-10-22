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
package com.universalmediaserver.tmdbapi.schema.configuration;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb configuration images Schema.
 *
 * @author SurfaceS
 */
public class ConfigurationImagesSchema {

	@SerializedName("base_url")
	private String baseUrl;
	@SerializedName("secure_base_url")
	private String secureBaseUrl;
	@SerializedName("backdrop_sizes")
	private List<String> backdropSizes;
	@SerializedName("logo_sizes")
	private List<String> logoSizes;
	@SerializedName("poster_sizes")
	private List<String> posterSizes;
	@SerializedName("profile_sizes")
	private List<String> profileSizes;
	@SerializedName("still_sizes")
	private List<String> stillSizes;

	public List<String> getBackdropSizes() {
		return backdropSizes;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public List<String> getPosterSizes() {
		return posterSizes;
	}

	public List<String> getProfileSizes() {
		return profileSizes;
	}

	public List<String> getLogoSizes() {
		return logoSizes;
	}

	public List<String> getStillSizes() {
		return stillSizes;
	}

	public String getSecureBaseUrl() {
		return secureBaseUrl;
	}

	public void setBackdropSizes(List<String> value) {
		this.backdropSizes = value;
	}

	public void setBaseUrl(String value) {
		this.baseUrl = value;
	}

	public void setPosterSizes(List<String> value) {
		this.posterSizes = value;
	}

	public void setProfileSizes(List<String> value) {
		this.profileSizes = value;
	}

	public void setLogoSizes(List<String> logoSizes) {
		this.logoSizes = logoSizes;
	}

	public void setSecureBaseUrl(String value) {
		this.secureBaseUrl = value;
	}

	public void setStillSizes(List<String> value) {
		this.stillSizes = value;
	}

}
