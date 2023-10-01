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
package net.ums.tmdbapi.schema.image;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Typed Image Schema.
 *
 * @author SurfaceS
 */
public class ImageTypedSchema extends ImageSchema {

	@SerializedName("file_type")
	private String fileType;
	@SerializedName("id")
	private String id;

	public String getFileType() {
		return fileType;
	}

	public String getId() {
		return id;
	}

	public void setFileType(String value) {
		this.fileType = value;
	}

	public void setId(String value) {
		this.id = value;
	}

}
