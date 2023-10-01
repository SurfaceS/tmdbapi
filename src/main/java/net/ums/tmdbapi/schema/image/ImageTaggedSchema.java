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

import net.ums.tmdbapi.schema.media.MediaTypeInterface;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Image Tagged Schema.
 *
 * @author SurfaceS
 */
public class ImageTaggedSchema extends ImageLanguageSchema {

	@SerializedName("image_type")
	private String imageType;
	@SerializedName("id")
	private String id;
	@SerializedName("media")
	private MediaTypeInterface media;
	@SerializedName("media_type")
	private String mediaType;

	public String getId() {
		return id;
	}

	public String getImageType() {
		return imageType;
	}

	public MediaTypeInterface getMedia() {
		return media;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setId(String value) {
		this.id = value;
	}

	public void setImageType(String value) {
		this.imageType = value;
	}

	public void setMedia(MediaTypeInterface value) {
		this.media = value;
	}

	public void setMediaType(String value) {
		this.mediaType = value;
	}

}
