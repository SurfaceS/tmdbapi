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
package com.universalmediaserver.tmdbapi.schema.movie;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Movie Role Credited Schema.
 *
 * @author SurfaceS
 */
public class MovieRoleCreditedSchema extends MovieRoleSchema {

	@SerializedName("order")
	private Long order;

	@SerializedName("credit_id")
	private String creditId;

	public String getCreditId() {
		return creditId;
	}

	public Long getOrder() {
		return order;
	}

	public void setCreditId(String value) {
		this.creditId = value;
	}

	public void setOrder(Long value) {
		this.order = value;
	}

}
