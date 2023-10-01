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
package net.ums.tmdbapi.schema.network;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Network Base Schema.
 *
 * @author SurfaceS
 */
public class NetworkBaseSchema extends IntegerIdNameSchema {

	@SerializedName("logo_path")
	private String logoPath;
	@SerializedName("origin_country")
	private String originCountry;

	public String getLogoPath() {
		return logoPath;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setLogoPath(String value) {
		this.logoPath = value;
	}

	public void setOriginCountry(String value) {
		this.originCountry = value;
	}

}
