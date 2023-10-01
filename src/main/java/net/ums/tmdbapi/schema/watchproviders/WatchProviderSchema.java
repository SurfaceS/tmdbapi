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
package net.ums.tmdbapi.schema.watchproviders;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Watch Provider Schema.
 *
 * @author SurfaceS
 */
public class WatchProviderSchema {

	@SerializedName("display_priority")
	private Long displayPriority;
	@SerializedName("logo_path")
	private String logoPath;
	@SerializedName("provider_id")
	private Long providerId;
	@SerializedName("provider_name")
	private String providerName;

	public Long getDisplayPriority() {
		return displayPriority;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public Long getProviderId() {
		return providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setDisplayPriority(Long value) {
		this.displayPriority = value;
	}

	public void setLogoPath(String value) {
		this.logoPath = value;
	}

	public void setProviderId(Long value) {
		this.providerId = value;
	}

	public void setProviderName(String value) {
		this.providerName = value;
	}

}
