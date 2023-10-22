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
 * TMDb Configuration Schema.
 *
 * @author SurfaceS
 */
public class ConfigurationSchema {

	@SerializedName("images")
	private ConfigurationImagesSchema images;
	@SerializedName("change_keys")
	private List<String> changeKeys;

	public ConfigurationImagesSchema getImages() {
		return images;
	}

	public List<String> getChangeKeys() {
		return changeKeys;
	}

	public void setImages(ConfigurationImagesSchema value) {
		this.images = value;
	}

	public void setChangeKeys(List<String> value) {
		this.changeKeys = value;
	}

}
