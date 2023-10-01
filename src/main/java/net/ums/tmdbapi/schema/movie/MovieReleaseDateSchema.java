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
package net.ums.tmdbapi.schema.movie;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Movie Release Date Schema.
 *
 * @author SurfaceS
 */
public class MovieReleaseDateSchema {

	@SerializedName("certification")
	private String certification;
	@SerializedName("descriptors")
	private List<String> descriptors;
	@SerializedName("iso_639_1")
	private String iso639Part1;
	@SerializedName("release_date")
	private String releaseDate;
	@SerializedName("type")
	private Long type;
	@SerializedName("note")
	private String note;

	public String getCertification() {
		return certification;
	}

	public List<String> getDescriptors() {
		return descriptors;
	}

	public String getIso639Part1() {
		return iso639Part1;
	}

	public String getNote() {
		return note;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Long getType() {
		return type;
	}

	public void setCertification(String value) {
		this.certification = value;
	}

	public void setDescriptors(List<String> value) {
		this.descriptors = value;
	}

	public void setIso639Part1(String value) {
		this.iso639Part1 = value;
	}

	public void setNote(String value) {
		this.note = value;
	}

	public void setReleaseDate(String value) {
		this.releaseDate = value;
	}

	public void setType(Long value) {
		this.type = value;
	}

}
