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
import java.util.List;

/**
 * TMDb Watch Provider Country Schema.
 *
 * @author SurfaceS
 */
public class WatchProvidersCountrySchema {

	@SerializedName("ads")
	private List<WatchProviderSchema> ads;
	@SerializedName("buy")
	private List<WatchProviderSchema> buy;
	@SerializedName("flatrate")
	private List<WatchProviderSchema> flatrate;
	@SerializedName("free")
	private List<WatchProviderSchema> free;
	@SerializedName("link")
	private String link;
	@SerializedName("rent")
	private List<WatchProviderSchema> rent;

	public List<WatchProviderSchema> getAds() {
		return ads;
	}

	public List<WatchProviderSchema> getBuy() {
		return buy;
	}

	public List<WatchProviderSchema> getFlatrate() {
		return flatrate;
	}

	public List<WatchProviderSchema> getFree() {
		return free;
	}

	public String getLink() {
		return link;
	}

	public List<WatchProviderSchema> getRent() {
		return rent;
	}

	public void setAds(List<WatchProviderSchema> value) {
		this.ads = value;
	}

	public void setBuy(List<WatchProviderSchema> value) {
		this.buy = value;
	}

	public void setFlatrate(List<WatchProviderSchema> value) {
		this.flatrate = value;
	}

	public void setFree(List<WatchProviderSchema> value) {
		this.free = value;
	}

	public void setLink(String value) {
		this.link = value;
	}

	public void setRent(List<WatchProviderSchema> value) {
		this.rent = value;
	}

}
