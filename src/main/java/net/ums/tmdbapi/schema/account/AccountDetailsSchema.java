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
package net.ums.tmdbapi.schema.account;

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Account Details Schema.
 *
 * @author SurfaceS
 */
public class AccountDetailsSchema extends IntegerIdNameSchema {

	@SerializedName("avatar")
	private AccountAvatarSchema avatar;
	@SerializedName("include_adult")
	private Boolean includeAdult;
	@SerializedName("iso_3166_1")
	private String iso3166Part1;
	@SerializedName("iso_639_1")
	private String iso639Part1;
	@SerializedName("username")
	private String username;

	public AccountAvatarSchema getAvatar() {
		return avatar;
	}

	public Boolean getIncludeAdult() {
		return includeAdult;
	}

	public String getIso3166Part1() {
		return iso3166Part1;
	}

	public String getIso639Part1() {
		return iso639Part1;
	}

	public String getUsername() {
		return username;
	}

	public void setAvatar(AccountAvatarSchema value) {
		this.avatar = value;
	}

	public void setIncludeAdult(Boolean value) {
		this.includeAdult = value;
	}

	public void setIso3166Part1(String value) {
		this.iso3166Part1 = value;
	}

	public void setIso639Part1(String value) {
		this.iso639Part1 = value;
	}

	public void setUsername(String value) {
		this.username = value;
	}

}
