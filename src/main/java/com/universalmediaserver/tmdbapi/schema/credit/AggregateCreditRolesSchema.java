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
package com.universalmediaserver.tmdbapi.schema.credit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb AggregateCredit Roles Schema.
 *
 * @author SurfaceS
 */
public class AggregateCreditRolesSchema extends AggregateCreditSchema {

	@SerializedName("order")
	private Long order;
	@SerializedName("roles")
	private List<AggregateCreditRoleSchema> roles;

	public Long getOrder() {
		return order;
	}

	public List<AggregateCreditRoleSchema> getRoles() {
		return roles;
	}

	public void setOrder(Long value) {
		this.order = value;
	}

	public void setRoles(List<AggregateCreditRoleSchema> value) {
		this.roles = value;
	}

}
