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
package net.ums.tmdbapi.schema.authentication;

import net.ums.tmdbapi.schema.SuccessSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Authentication Guest Session Schema.
 *
 * @author SurfaceS
 */
public class AuthenticationGuestSessionSchema extends SuccessSchema {

	@SerializedName("guest_session_id")
	private String guestSessionId;
	@SerializedName("expires_at")
	private String expiresAt;

	public String getExpiresAt() {
		return expiresAt;
	}

	public String getGuestSessionId() {
		return guestSessionId;
	}

	public void setExpiresAt(String value) {
		this.expiresAt = value;
	}

	public void setGuestSessionId(String value) {
		this.guestSessionId = value;
	}

}
