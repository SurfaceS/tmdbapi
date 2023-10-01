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
package net.ums.tmdbapi.schema.credit;

import net.ums.tmdbapi.schema.media.MediaTypeInterface;
import net.ums.tmdbapi.schema.person.PersonShortTypedSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Credit Schema.
 *
 * @author SurfaceS
 */
public class CreditSchema {

	@SerializedName("credit_type")
	private String creditType;
	@SerializedName("department")
	private String department;
	@SerializedName("id")
	private String id;
	@SerializedName("job")
	private String job;
	@SerializedName("media")
	private MediaTypeInterface media;
	@SerializedName("media_type")
	private String mediaType;
	@SerializedName("person")
	private PersonShortTypedSchema person;

	public String getCreditType() {
		return creditType;
	}

	public String getDepartment() {
		return department;
	}

	public String getId() {
		return id;
	}

	public String getJob() {
		return job;
	}

	public MediaTypeInterface getMedia() {
		return media;
	}

	public String getMediaType() {
		return mediaType;
	}

	public PersonShortTypedSchema getPerson() {
		return person;
	}

	public void setCreditType(String value) {
		this.creditType = value;
	}

	public void setDepartment(String value) {
		this.department = value;
	}

	public void setId(String value) {
		this.id = value;
	}

	public void setJob(String value) {
		this.job = value;
	}

	public void setMedia(MediaTypeInterface value) {
		this.media = value;
	}

	public void setMediaType(String value) {
		this.mediaType = value;
	}

	public void setPerson(PersonShortTypedSchema value) {
		this.person = value;
	}

}
